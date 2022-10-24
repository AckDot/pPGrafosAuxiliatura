import java.util.ArrayList;

/**
 * Write a description of class ListaAdyacente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaAdyacente
{
    //Metodos de la lista de adyacencia 
    int nVertices;
    ArrayList<Adyacente>[] lista;

    public ListaAdyacente(int nVertices)
    {
        this.nVertices = nVertices;
        this.lista = new ArrayList[this.nVertices];   

        for(int i=0; i<nVertices; i++){
            this.lista[i]= new ArrayList<Adyacente>();
        }
    }

    public boolean insertarArista(int origen, int destino){
        this.lista[origen].add(new Adyacente(destino, 0));
        return true;
    }

    public ArrayList<Adyacente> getAdyacentes(int vertice){
        ArrayList<Adyacente> listaAdyacentes = new ArrayList<>();
        if(vertice >= nVertices){
            return listaAdyacentes;
        }
        for(int i = 0 ; i < this.lista[vertice].size() ; i++ ){
            Adyacente ad = this.lista[vertice].get(i);
            listaAdyacentes.add(ad);
        }
        return listaAdyacentes;
    }

    public String toString(){
        String grafo = "";
        for(int i =0; i <this.lista.length ; i++){
            grafo += i+" ->";
            for(Adyacente adyacente: this.lista[i]){
                grafo += adyacente.toString();
            }
            grafo += "\n";
        }
        return grafo;
    }

    public void dibujarGrafo(){
        System.out.println(this.toString());
    }

    public int getNumVertices(){
        return lista.length;
    }

    public int getNumAristas(){
        int cantAristas = 0;
        for(int i = 0 ; i < lista.length ; i ++){
            for(int j = 0 ; j < lista[i].size() ; j++){
                cantAristas++;
            }
        }
        return cantAristas;
    }    

    public boolean existeArista(int origen, int destino){
        ArrayList<Adyacente> ls = getAdyacentes(origen);
        if(nVertices > origen && origen >= 0 && destino >=0 && destino < nVertices){
            for(int i = 0 ; i < ls.size() ; i++){
                if(ls.get(i).getNodo() == destino){
                    return true;
                }
                if(ls.get(i) == null){
                    return false;
                }
            }
        }
        return false;
    }

    public double getpesoArista(int origen, int destino){
        double pesoArista = 0.0; 
        if(nVertices > origen && origen >= 0 && destino >=0 && destino < nVertices){
            for(int i = 0 ; i < this.lista.length ; i ++){
                for(int j = 0 ; j < this.lista[i].size() ; j++){
                    if(this.lista[i].get(j) != null && this.lista[i].get(j).getNodo() == destino){
                        pesoArista = this.lista[i].get(j).getPeso();
                    }
                }
            }
        }
        return pesoArista;
    }

    public boolean insertarArista(int origen, int destino, double peso){
        boolean sePudo; // true si se pudo añadir correctamente en la lista
        if(nVertices > origen && origen >= 0 && destino >=0 && destino < nVertices){
            this.lista[origen].add(new Adyacente(destino, peso));
            sePudo = true;
        }else{
            sePudo = false;
        }
        return sePudo;
    }

    public boolean quitarArista(int origen, int destino){
        boolean aux = false;
        int i = 0;
        if(nVertices > origen && origen >= 0 && destino >=0 && destino < nVertices){
            while(i < lista[origen].size() && !aux){
                Adyacente actual = lista[origen].get(i);
                if(actual.getNodo() == destino){
                    lista[origen].remove(i);
                    aux = true;
                }
                i++;
            }
        }
        return aux;
    }
    // extension de una arista que termina en el vertice indicado
    public int getGradoVertice_positivo(int vertice){
        int count = 0; // es 0 para que en caso de que el vertice no exista devuelva 0
        if(vertice>= 0 && vertice < nVertices){
            for(int i = 0 ; i < lista.length ; i++){
                for(int j = 0 ; j < lista[i].size() ; j++){
                    if(lista[i].get(j).getNodo() ==  vertice){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // extension de una arista que inicia en el vertice indicado
    public int getGradoVertice_negativo(int vertice){
        int count = 0; // es 0 para que en caso de que el vertice no exista devuelva 0
        if(vertice>= 0 && vertice < nVertices){   
            for(Adyacente ad : lista[vertice]){
                count++;  
            }
        }
        return count;
    }

    public boolean esCompleto(){
        for(int i = 0; i < lista.length ; i++){
            for(int j = 0; j < lista[i].size(); j++){
                if(getpesoArista(i, j) == 0.0 && i != j){
                    return false;
                }
            }
        }
        return true;
    }

    //debe haber un vertice que se conecte a todos los demas
    public boolean esGrafoRueda(){
        boolean esgrafoRueda = false;
        int count = 0;
        if(getNumAristas() == 2*(nVertices-1)){
            for(int i = 0 ; i<nVertices && !esgrafoRueda ; i++){
                int gradoActual = getGradoVertice_positivo(i);
                int gradoAux = getGradoVertice_negativo(i);
                if(gradoActual>=3 || gradoAux>=3 ){ // si no es 3 o mayor a 3 los vertices que tiene el vertice no es grafo rueda
                    if(gradoActual == nVertices-1){
                        esgrafoRueda = true;
                    }
                }
            }
        }
        return esgrafoRueda;
    }

    public boolean existeBucle(){      
        boolean existe = false;
        for(int i = 0 ; i<nVertices && !existe ; i++){
            for(int j = 0 ; j<lista[i].size() && !existe; j++){
                if(lista[i].get(j).getNodo() == i){
                    existe = true;
                }
            }
        }
        return existe;
    }

    public boolean existeCiclo(){
        boolean existe = true;
        if(getNumAristas() == getNumVertices()){
            for(int i = 0 ; i< nVertices && existe ; i++){
                if(getGradoVertice_positivo(i) ==1 ){
                    existe = true;
                }else{return false;}
            }
        }
        return existe;
    }
}