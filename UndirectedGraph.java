
public class UndirectedGraph extends DirectedGraph {
	
	
	public boolean addEdge(Character vertex1, Character vertex2) {
		return super.addEdge(vertex1, vertex2) && super.addEdge(vertex2, vertex1);
	}
	
	public int edgeCount() {
		return super.edgeCount() / 2;
	}
	
	public boolean removeEdge(Character vertex1, Character vertex2) {
		return super.removeEdge(vertex1, vertex2) && super.removeEdge(vertex2, vertex1);
	}
	
}
