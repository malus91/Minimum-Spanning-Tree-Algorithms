

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * The class to implement the kruskal algorithm.
 * @author 
 *     Group -G12
 *     Anirudh Kuttiyil Valsalan
 *     Malini Kottarappatt Bhaskaran
 *     Neha Nirmala Srinivas
 *     Saumya Ann George
 *
 */
public class KruskalAlgoImpl {
/**
 * kruskal method to find the minimum distances in an undirected graph.
 * @param 
 *    List<Edge> edges :edges list
 * @param 
 *    int numVertices :numVertices
 * @return
 *    long :Length of the spanning tree.
 */
	public  long kruskal(List<Edge> edges, int numVertices) {
		//create disjoint set class.
		DisjointSets ds = new DisjointSets(numVertices);
		//create priority queue of edges.
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
		long totalLength = 0;
		System.out.println("Shortest path using Kruskal ");
		List<Edge> mst = new ArrayList<>();
		//Iterate until the size of array list become equal to numVertices - 1
		while (mst.size() != numVertices - 1) {

			Edge e = pq.remove();

			int uset = ds.find(e.From.name);
			int vset = ds.find(e.To.name);
			//union sets if both vertices belongs to different sets.
			if (uset != vset) {

				System.out.println(e.toString());
				totalLength = totalLength + e.Weight;
				mst.add(e);
				ds.union(uset, vset);
			}

		}
		return totalLength;
	}


	
}
