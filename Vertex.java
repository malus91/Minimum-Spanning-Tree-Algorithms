

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vertex implements Index, Comparator<Vertex>{
    public int name; // name of the vertex
    public boolean seen; // flag to check if the vertex has already been visited
    public Vertex parent; // parent of the vertex
    public int distance; // distance to the vertex from the source vertex
    public List<Edge> Adj, revAdj; // adjacency list; use LinkedList or ArrayList
    public int index;
    public boolean isInfinity;
    /**
     * Constructor for the vertex
     * 
     * @param n
     *            : int - name of the vertex
     */
    Vertex(int n) {
	name = n;
	seen = false;
	parent = null;
	Adj = new ArrayList<Edge>();
	revAdj = new ArrayList<Edge>();   /* only for directed graphs */
	isInfinity=true;
    }

    /**
     * Method to represent a vertex by its name
     */
    public String toString() {
	return Integer.toString(name);
    }

	public int compare(Vertex u, Vertex v) {
		if (u.isInfinity) {
			return 1;
		}
		if (v.isInfinity) {
			return -1;
		} else {
			return u.distance - v.distance;

		}
	}

	@Override
	public void putIndex(int index) {
		this.index=index;
		
	}

	@Override
	public int getIndex() {
		return index;
	}
	

	
	
}