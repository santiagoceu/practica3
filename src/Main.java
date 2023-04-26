public class Main {
    public static void main(String[] args) {

        Graph<Object> g = new Graph<>();
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("a");
        g.addVertex("4");
        g.addEdge("1","2");
        //g.addEdge("1","a");
        g.addEdge("2","1");
        g.addEdge("2","3");
        g.addEdge("a","4");
        g.addEdge("1","3");
        g.addEdge("3","2");
        g.addEdge("3","4");
        g.addEdge("3","1");
        g.addVertex("5");
        g.addVertex("6");
        g.addVertex("7");
        g.addVertex("8");
        g.addEdge("5","6");
        g.addEdge("6","7");
        g.addEdge("6","5");
        //g.addEdge("2","3");
        g.addEdge("4","5");
        //g.addEdge("1","3");
        g.addEdge("7","2");
        g.addEdge("7","8");
        g.addEdge("6","1");
        System.out.println(g.obtainAdjacents("1").toString());
        System.out.println(g.containsVertex("3"));
        System.out.println(g);
        System.out.println(g.onePath("1","7"));
    }
}