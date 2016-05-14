
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
/**
 * class to implement prime based minimum spanning tree.
 * 
 * @author 
 *     Group -G12
 *     Anirudh Kuttiyil Valsalan
 *     Malini Kottarappatt Bhaskaran
 *     Neha Nirmala Srinivas
 *     Saumya Ann George
 *
 */
public class PrimBasedMST {
/**
 * Method to find minimum spanning tree using primes algorithm.
 * @param 
 *     input graph Graph g.
 * @return
 *     length of the spanning tree.
 */
	public long primMST(Graph g) {

		Iterator<Vertex> itVert = g.iterator();
		for (Vertex v : g) {
			v.seen = false;
		}
		Vertex vert = itVert.next();
		vert.seen = true;
		long wmst = 0;

		/** Compare function to compare edges based on their weight */
		Comparator<Edge> asc = new Comparator<Edge>() {

			public int compare(Edge u, Edge v) {
				return (u.Weight - v.Weight);
			}
		};

		/** Priority queue with edges in ascending order */
		PriorityQueue<Edge> pq = new PriorityQueue<>(asc);

		for (Edge e : vert.Adj) {
			pq.add(e);
		}

		System.out.println("Primes 1 path is");
		// add the adjacent edges of unseen vertices to priority queue.
		while (!pq.isEmpty()) {
			Edge e = pq.remove();
			if (e.From.seen == true && e.To.seen == true) {
				continue;
			}
			System.out.println(e.toString());
			// find out the unseen vertex and assign to u.
			Vertex u = (e.From.seen == true) ? e.From : e.To;

			Vertex v = e.otherEnd(u);
			v.parent = u;
			wmst = wmst + e.Weight;

			v.seen = true;
			for (Edge f : v.Adj) {
				Vertex w = f.otherEnd(v);
				if (!w.seen)
					pq.add(f);
			}
		}
		return wmst;

	}
	

	
}