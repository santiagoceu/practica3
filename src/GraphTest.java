import org.junit.Assert;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘
     * encuentra un camino entre ‘v1‘ y ‘v2‘ cuando existe.
     */
    @Test
    public void onePathFindsAPath() {
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
// Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
// Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
//Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }
}