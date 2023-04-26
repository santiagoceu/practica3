import java.util.*;
public class Graph<V> {
    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
    /******************************************************************
     * Añade el vértice ‘v‘ al grafo.
     *
     * @param v vértice a añadir.
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso
     * contrario.
     ******************************************************************/
    public boolean addVertex(V v) {
        boolean exists = !(adjacencyList.get(v)==null);
        adjacencyList.put(v, new HashSet<>());
        return exists;
    }
    /******************************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso
    contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2){
        adjacencyList.putIfAbsent(v1, new HashSet<>());
        adjacencyList.putIfAbsent(v2, new HashSet<>());
        return adjacencyList.get(v1).add(v2);
    }
    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) {
        return adjacencyList.get(v );

    }
    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }
    /******************************************************************
    * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
    * @return una cadena de caracteres con la lista de
    * adyacencia.
    ******************************************************************/
    @Override
    public String toString(){

        return adjacencyList.toString();
    }
    /*********************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
     * ‘v2‘. En caso contrario, devuelve ‘null‘.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta
     * ‘v2‘ * pasando por arcos del grafo.
     *********************************************************/

    public List<V> onePath(V v1, V v2) {

        HashMap<V,V> trace = new LinkedHashMap<>();
        Stack<V> stack = new Stack<>();
        stack.add(v1);
        trace.put(v1,null);
        boolean found = false;
        while (!stack.isEmpty() && !found) {
            V s = stack.pop();
            found = s==v2;
            for (V v : obtainAdjacents(s)) {

                if (!trace.containsKey(v)) {
                    trace.put(v,s);
                    stack.add(v);
                }
            }
        }
        if (found) {
            //System.out.println("encontrado");
            //System.out.println(trace);

            return backpedal(v2,trace);
        }
        else return null;
    }
    /**
    Recorre la traza y la va añadiendo a un array para devolver.
    @param v el vector destino al que queremos llegar en onePath
     @param m la traza obtenida en onePath
     @return List para devolver a onePath

     */
    private List<V> backpedal(V v, Map<V,V> m) {
        if (m.get(v)==null) return new ArrayList<V>(Arrays.asList(v));
        else {
            List<V> back = backpedal(m.get(v), m);
            back.add(v);
            return back;
        }
    }
}