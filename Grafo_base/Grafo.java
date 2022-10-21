import java.util.ArrayList;

public interface Grafo
{
    int getNumVertices();
    int getNumAristas();    
    boolean existeArista(int origen, int destino);
    double getPesoArista(int origen, int destino);
    boolean insertarArista(int origen, int destino);
    //porque tiene que devolver un boolean , o que tendria que hacer ?
    boolean insertarArista(int origen, int destino, double peso);
    //porque tiene que devolver un boolean , o que tendria que hacer ?
    boolean quitarArista(int origen, int destino);
    ArrayList<Adyacente> getAdyacentes(int vertice); 
    //esta clase no podria devolver los vertices en double ?
    //la clase Adyacente puede ser modificada , 
    //la idea es obtener la lista de vertices adyacentes dado un vertice
    int getGradoVertice_positivo(int vertice); 
    //(grado positivo) ->numero de aristas que terminan en el vertice
    int getGradoVertice_negativo(int vertice); 
    //(grado negativo) ->numero de aristas que inician en el vertice
    void dibujarGrafo();
    boolean esCompleto();
    boolean esGrafoRueda();
    boolean existeBucle();
    boolean existeCiclo();
}
