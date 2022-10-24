import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Jose Roberto Vargas Orellana 
 * 
 */
public class Adyacente implements Grafo
{
    // Aca esta todo implementado de la lista de Adyacentes
    //y los metodos de adyacente para realizar pruebas
    private int nodo ;
    private double peso ;
    ArrayList<Adyacente>[] lista; //aca no se usa lista , solo esta puesto por la 
    int nVertices;
    boolean dirigido;

    public Adyacente(int nodo, double peso)
    {
        this.peso=peso;
        this.nodo=nodo;
    }

    public String toString(){ //metodo exclusivo para ser usado en ListaAdyacente
        return "(" + this.nodo +"," + this.peso +")";
    }

    public double getPeso(){
        return this.peso;
    }

    public int getNodo(){
        return this.nodo;
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
        return getAdyacente(origen, destino) != null;
    }

    public double getPesoArista(int origen, int destino){
        double pesoArista = 0.0; 
        for(int i = 0 ; i < lista.length ; i ++){
            for(int j = 0 ; j < lista[i].size() ; j++){
                if(!this.lista[origen].equals(null) && this.lista[origen].get(j).getNodo() == destino){
                    pesoArista = this.lista[origen].get(destino).getPeso();
                }
            }
        }

        return pesoArista;
    }

    private Adyacente getAdyacente(int origen, int destino){
        Adyacente a = null;
        boolean bandera = false;
        int i = 0;
        while(i < lista[origen].size() && !bandera){
            Adyacente actual = lista[origen].get(i);
            if(actual.getNodo() == destino){
                a = actual;
                bandera = true;
            }
            i++;
        }
        return a;
    }

    public boolean insertarArista(int origen, int destino, double peso){
        boolean sePudo; // true si se pudo añadir correctamente en la lista
        if(nVertices > origen && origen >= 0 && nVertices > destino && destino >=0){
            this.lista[origen].add(new Adyacente(destino, peso));
            //this.lista[destino].add(new Adyacente(origen, peso));
            sePudo = true;
        }else{
            sePudo = false;
        }
        return sePudo;
    }

    public boolean quitarArista(int origen, int destino){
        boolean aux = false;
        int i = 0;
        while(i < lista[origen].size() && !aux){
            Adyacente actual = lista[origen].get(i);
            if(actual.getNodo() == destino){
                lista[origen].remove(i);
                aux = true;
            }
            i++;
        }
        return aux;
    }
    // extension de una arista que termina en el vertice indicado
    public int getGradoVertice_positivo(int vertice){
        int count = -1; // es -1 para que en caso de que el vertice no exista devuelva -1
        for(int i = 0 ; i < lista.length ; i ++){
            for(int j = 0 ; i < lista[i].size() ; j++){
                if(lista[i].get(j).getNodo() ==  vertice){
                    count++;  
                }
            }
        }
        return count;
    }
    // extension de una arista que inicia en el vertice indicado
    public int getGradoVertice_negativo(int vertice){
        int count = -1; // es -1 para que en caso de que el vertice no exista devuelva -1
        for(Adyacente ad : lista[vertice]){
            count++;  
        }
        return count;
    }

    public boolean esCompleto(){
        for(int i = 0; i < lista.length; i++){
            for(int j = 0; j < lista[i].size(); j++){
                if(lista[i].get(j).getPesoArista(i, j) == 0.0 && i != j){
                    return false;
                }
            }
        }
        return true;
    }

    //debe haber un vertice que se conecte a todos los demas
    public boolean esGrafoRueda(){
        boolean esgrafoRueda = true;
        int count = 0;
        if(getNumAristas() == 2*(nVertices-1)){
            for(int i = 0 ; i<nVertices && esgrafoRueda ; i++){
                int gradoActual = getGradoVertice_positivo(i);
                if(gradoActual!=3){
                    if(gradoActual == nVertices-1){
                        count++;
                    }else{
                        esgrafoRueda = false;
                    }
                }
            }
        }
        return esgrafoRueda && count==1;
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
        if(getNumAristas() == nVertices){
            for(int i = 0 ; i<nVertices && existe ; i++){
                if(getGradoVertice_positivo(i)!= 2){
                    existe = false;
                }
            }
        }
        return existe;
    }

    //Metodos de la lista de adyacencia 

    public ArrayList<Adyacente>[] ListaAdyacencia(int nVertices,  boolean dirigido)
    {
        this.nVertices = nVertices;
        this.dirigido = dirigido;        
        this.lista = new ArrayList[this.nVertices];   

        for(int i=0; i<nVertices; i++){
            this.lista[i]= new ArrayList<Adyacente>();
        }
        return lista;
    }

    public boolean insertarArista(int origen, int destino){
        this.lista[origen].add(new Adyacente(destino, 0));

        if(!this.dirigido){
            this.lista[destino].add(new Adyacente(origen, 0));
        }
        return true;
    }

    public ArrayList<Adyacente> getAdyacentes(int vertice){
        ArrayList<Adyacente> listaAdyacentes = new ArrayList<>();
        for(Adyacente ad: this.lista[vertice]){
            listaAdyacentes.add(ad);
        }
        return listaAdyacentes;
    }

    public void dibujarGrafo(){
        System.out.println(this.lista.toString());
    }

}
