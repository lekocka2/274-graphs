import java.util.*;

/**
 * Implements the Graph interface using a Map
 * The map will act somewhat like using adjacency lists.
 * @author Norm Krumpe
 *
 */
public class DirectedGraph implements Graph {
	
	// The character is a vertex
	// The set of characters is all the neighbors of that vertex.
	// addVertex should put a new key-value pair in the map
	// addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	private Map<Character, Set<Character>> map;
	
	/*
	 * Constructs a new graph by creating an empty map
	 * 
	 */
	public DirectedGraph() {
		map = new TreeMap<Character, Set<Character>>();
	}

	/*
	 * addVertex('a') should put a key-value pair
	 * in the map with no neighbors for 'a' yet.
	 */
	@Override
	public boolean addVertex(Character vertex) {
		// if vertex is already in graph, return false
		if (vertex == null || map.containsKey(vertex)) {
			return false;
		}
		
		map.put(vertex, new TreeSet<Character>());
		return true;
	}

	@Override
	public boolean removeVertex(Character vertex) {
		if (!hasVertex(vertex)) {
			return false;
		}
		
		// vertex exists:
		// loop to remove the vertex as a neighbor from 
		// all the other vertices:
		for (Character v : map.keySet()) {
			//map.get(v).remove(vertex);
			removeEdge(v, vertex);
		}
		
		// now remove the key vertex itself
		map.remove(vertex);
		return true;
	}

	/*
	 * addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	 */
	@Override
	public boolean addEdge(Character vertex1, Character vertex2) {
		// Things that could go wrong that should result in 
		// returning false:
		if (vertex1 == null || vertex2 == null) {
			return false;
		}
		
		if (vertex1 == vertex2) {
			return false;
		}
		
		if (!map.containsKey(vertex1) || !map.containsKey(vertex2)) {
			return false;
		}		
		
		return map.get(vertex1).add(vertex2);
	
	}

	@Override
	public boolean removeEdge(Character vertex1, Character vertex2) {
		if (!hasEdge(vertex1, vertex2)) {
			return false;
		}
		
		// We know the edge exists, so remove it
		map.get(vertex1).remove(vertex2);
		return true;
	}

	@Override
	public boolean hasVertex(Character vertex) {
		return map.containsKey(vertex);
	}

	@Override
	public boolean hasEdge(Character vertex1, Character vertex2) {
		return hasVertex(vertex1)
				&& map.get(vertex1).contains(vertex2);
	}

	@Override
	public boolean isEmpty() {		
		return map.size() == 0;
	}

	@Override
	public int vertexCount() {		
		return map.size();
	}

	@Override
	public int edgeCount() {		
		int count = 0;
		
		for(Character vertex : map.keySet()) {
			count += map.get(vertex).size();
		}
		return count;
	}

	@Override
	public List<Character> breadthFirstTraversal(Character vertex) {		
		List<Character> result = new ArrayList<>();
		Set<Character> visited = new HashSet<>();
		Queue<Character> q = new LinkedList<>();
		
		q.add(vertex);
		visited.add(vertex);

		while(!q.isEmpty()) {
			Character front = q.remove();
			result.add(front);

			for(Character neighbor : map.get(front)) {
				if(!visited.contains(neighbor)) {
					visited.add(neighbor);
					q.add(neighbor);
				}
			}
		}
		return result;
	}

	@Override
	public List<Character> depthFirstTraversal(Character vertex) {		
		List<Character> result = new ArrayList<>();
		Set<Character> visited = new HashSet<>();
		Stack<Character> stk = new Stack<>();
		
		stk.push(vertex);
		visited.add(vertex);
		
		while(!stk.isEmpty()) {
			Character top = stk.peek();
			boolean foundUnvisitedNeighbor = false;
			for(Character neighbor : map.get(top)) {
				if(!visited.contains(neighbor)) {
					stk.push(neighbor);
					visited.add(neighbor);
					result.add(neighbor);
					foundUnvisitedNeighbor = true;
					break;
				}
			}
			
			if(!foundUnvisitedNeighbor) {
				stk.pop();
			}
		}
		
		return result;
	}

	@Override
	public List<Character> shortestPath(Character start, Character end) {		
		return null;
	}

	@Override
	public void makeComplete() {		
		for(Character vertex : map.keySet()) {
			for(Character other : map.keySet()) {
				addEdge(vertex, other);
			}
		}
	}
	
	
	// Returns a string representation of the graph
	// Each line is a vertex followed by its neighbors
	public String toString() {
		String result = "";
		
		// loop through the map
		for (Character v : map.keySet()) {
			result += v + " --> ";
			result += map.get(v); // grabs the set of neighbors
			result += "\n";
		}		
		
		return result;
	}
}
