
public class GraphTester {

    public static void main(String[] args) {
    	
//    	Graph g = new UndirectedGraph();
//    	g.addVertex('a');
//    	g.addVertex('b');
//    	g.addVertex('c');
//    	g.addVertex('d');
//    	g.addVertex('e');
//    	g.addVertex('f');
//    	g.addVertex('g');
    	Graph g = slideSample41();
    	
    	g.addEdge('a', 'b');
    	g.addEdge('b', 'c');
    	
    	System.out.println(g);
    	System.out.println(g.edgeCount());
    	g.makeComplete();
    	System.out.println(g.edgeCount());
    	
//        Graph g = slideSample41();
//        
//        System.out.println(g);
//        g.makeComplete();
//        System.out.println(g);
//        System.out.println(g.vertexCount());
//        System.out.println(g.edgeCount());
        
    }

    // See slide 41 in this week's notes. A directed graph with
    // 9 nodes and 13 edges
    public static Graph slideSample41() {
        Graph dg = new UndirectedGraph();
        dg.addVertex('a');
        dg.addVertex('b');
        dg.addVertex('c');
        dg.addVertex('d');
        dg.addVertex('e');
        dg.addVertex('f');
        dg.addVertex('g');
        dg.addVertex('h');
        dg.addVertex('i');

        dg.addEdge('a', 'b');
        dg.addEdge('a', 'e');
        dg.addEdge('a', 'd');
        dg.addEdge('b', 'e');
        dg.addEdge('c', 'b');
        dg.addEdge('d', 'g');
        dg.addEdge('e', 'f');
        dg.addEdge('e', 'h');
        dg.addEdge('g', 'h');
        dg.addEdge('h', 'i');
        dg.addEdge('i', 'f');
        dg.addEdge('f', 'h');
        dg.addEdge('f', 'c');
        
        return dg;
    }
    
}
