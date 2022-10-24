import java.util.ArrayList;

public class PruebasGrafos
{    
    public static void main (String[] args){
        // Lista Adyacencia de grafoConexo 
        //listaAdyacenciaGraphConexo();
        //listaAdyacenciaGraphNoConexo();
        listaAdyacenciaGraphRuedaCiclo();
    }    

    private static void listaAdyacenciaGraphConexo(){
        ListaAdyacente grafoConexo = new ListaAdyacente(5) ;
        boolean seLogro = true;
        int origen = 0;
        int destino =1;
        while(seLogro && destino < 5){
            if(destino==4){
                seLogro = grafoConexo.insertarArista(origen, destino, 5);
                seLogro = grafoConexo.insertarArista(destino, 0 , 5);
            }else{
                seLogro = grafoConexo.insertarArista(origen, destino, 5);
            }
            origen++; 
            destino++;
        }
        grafoConexo.dibujarGrafo();
        System.out.println("Grafo conexo : ");
        System.out.println("Es Completo ? : "+grafoConexo.esCompleto());
        System.out.println("Es Grafo tipo Rueda ? : "+grafoConexo.esGrafoRueda());
        System.out.println("Existe Arista origen : 7 , destino : 8  ???: "+grafoConexo.existeArista(7, 8));
        System.out.println("Existe Arista origen : 4 , destino : 0  ???: "+grafoConexo.existeArista(4,0));
        System.out.println("Existe bucle ?? "+grafoConexo.existeBucle());
        System.out.println("Existe Ciclo ?? "+grafoConexo.existeCiclo());
        System.out.println("Cantidad de aristas que inician en vertice 4 : "+grafoConexo.getGradoVertice_negativo(4));
        System.out.println("Cantidad de aristas que terminan en vertice 4 :"+grafoConexo.getGradoVertice_positivo(4));
        System.out.println("Adyacentes de 0 :"+grafoConexo.getAdyacentes(0));
        System.out.println("Cantidad de Aristas del grafo Conexo:"+grafoConexo.getNumAristas());
        System.out.println("Cantidad de Vertices del grafo Conexo:"+grafoConexo.getNumVertices());
        System.out.println("Peso de la arista entre los vertices 1 y 2:"+grafoConexo.getpesoArista(1, 2));
    }

    private static void listaAdyacenciaGraphNoConexo(){
        ListaAdyacente grafoNoConexo = new ListaAdyacente(5) ;
        boolean seLogro = true;
        seLogro = grafoNoConexo.insertarArista(0, 1, 5);
        seLogro = grafoNoConexo.insertarArista(1, 2, 5);
        seLogro = grafoNoConexo.insertarArista(2, 0, 5);
        seLogro = grafoNoConexo.insertarArista(3, 4, 5);        
        seLogro = grafoNoConexo.insertarArista(4, 4, 5); //bucle en 4
        grafoNoConexo.dibujarGrafo();
        System.out.println("Grafo no conexo : ");
        System.out.println("Es Completo ? : "+grafoNoConexo.esCompleto());
        System.out.println("Es Grafo tipo Rueda ? : "+grafoNoConexo.esGrafoRueda());
        System.out.println("Existe Arista origen : 7 , destino : 8  ???: "+grafoNoConexo.existeArista(7, 8));
        System.out.println("Existe Arista origen : 3 , destino : 4  ???: "+grafoNoConexo.existeArista(3,4));
        System.out.println("Existe bucle ?? "+grafoNoConexo.existeBucle());
        System.out.println("Existe Ciclo ?? "+grafoNoConexo.existeCiclo());
        System.out.println("Cantidad de aristas que inician en vertice 0 : "+grafoNoConexo.getGradoVertice_negativo(0));
        System.out.println("Cantidad de aristas que terminan en vertice 0 :"+grafoNoConexo.getGradoVertice_positivo(0));
        System.out.println("Adyacentes de 0 :"+grafoNoConexo.getAdyacentes(0));
        System.out.println("Cantidad de Aristas del grafo Conexo:"+grafoNoConexo.getNumAristas());
        System.out.println("Cantidad de Vertices del grafo Conexo:"+grafoNoConexo.getNumVertices());
        System.out.println("Peso de la arista entre los vertices 1 y 2:"+grafoNoConexo.getpesoArista(1, 2));
    }

    private static void listaAdyacenciaGraphRuedaCiclo(){
        ListaAdyacente grafoRueda = new ListaAdyacente(6) ;
        boolean seLogro = true;
        seLogro = grafoRueda.insertarArista(0, 1, 10);
        seLogro = grafoRueda.insertarArista(1, 5, 3);
        seLogro = grafoRueda.insertarArista(5, 3, 4);
        seLogro = grafoRueda.insertarArista(3, 4, 6);        
        seLogro = grafoRueda.insertarArista(4, 0, 9);
        seLogro = grafoRueda.insertarArista(2, 0, 2);
        seLogro = grafoRueda.insertarArista(2, 4, 7);
        seLogro = grafoRueda.insertarArista(2, 3, 1);
        seLogro = grafoRueda.insertarArista(2, 5, 5);
        seLogro = grafoRueda.insertarArista(2, 1, 8);
        grafoRueda.dibujarGrafo();
        System.out.println("Grafo tipo Rueda Ciclo : ");
        System.out.println("Es Completo ? : "+grafoRueda.esCompleto());
        System.out.println("Es Grafo tipo Rueda ? : "+grafoRueda.esGrafoRueda());
        System.out.println("Existe Arista origen : 7 , destino : 8  ???: "+grafoRueda.existeArista(7, 8));
        System.out.println("Existe Arista origen : 3 , destino : 4  ???: "+grafoRueda.existeArista(3,4));
        System.out.println("Existe bucle ?? "+grafoRueda.existeBucle());
        System.out.println("Existe Ciclo ?? "+grafoRueda.existeCiclo());
        System.out.println("Cantidad de aristas que inician en vertice 0 : "+grafoRueda.getGradoVertice_negativo(0));
        System.out.println("Cantidad de aristas que terminan en vertice 0 :"+grafoRueda.getGradoVertice_positivo(0));
        System.out.println("Adyacentes de 0 :"+grafoRueda.getAdyacentes(0));
        System.out.println("Cantidad de Aristas del grafo Conexo:"+grafoRueda.getNumAristas());
        System.out.println("Cantidad de Vertices del grafo Conexo:"+grafoRueda.getNumVertices());
        System.out.println("Peso de la arista entre los vertices 1 y 2:"+grafoRueda.getpesoArista(1, 2));
    }
}
