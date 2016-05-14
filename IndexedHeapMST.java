

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * The class to implement the IndexedHeap based prime algorithm.
 * @author 
 *     Group -G12
 *     Anirudh Kuttiyil Valsalan
 *     Malini Kottarappatt Bhaskaran
 *     Neha Nirmala Srinivas
 *     Saumya Ann George
 *
 */
public class IndexedHeapMST {
   
/**
 * Method to do primeIndex Minimum Spanning Tree.
 * @param 
 *        Graph g:Graph input
 * @return
 *       long length :length of minimum spanning tree.
 */
   public  long PrimIndexedMST(Graph g)
 {
		long wmst = 0;
		int count = 1;
		Vertex src = g.verts.get(1);

		// Code for Prim's algorithm needs to be written
		Vertex[] vertex = new Vertex[g.numNodes + 1];

		/*
		 * Set all vertices with distance to infinity and set index field of
		 * each vertex
		 */
		for (Vertex vert : g.verts) {
			if (vert != null) {
				//initialize all vertices to infinity.
				vert.isInfinity = true;
				vert.seen=false;
				vertex[count] = vert;
				vertex[count].index = count;
				++count;
			}
		}
		/* Set 1st vertex with distanceto 0 */
		src.distance = 0;

		/*
		 * Create Indexed heap passing vertex array and vertex object which
		 * implements the compare function
		 */
		
		IndexedHeap<Vertex> indexedVertex = new IndexedHeap<Vertex>(vertex, new Vertex(0));

		
		while (!indexedVertex.isSizeEmpty()) {
			Vertex u = indexedVertex.remove();	
			u.seen = true;
			u.isInfinity=false;
		    wmst = wmst + u.distance;
			for (Edge e : u.Adj) {
				Vertex v = e.otherEnd(u);
				if (!v.seen && ((v.isInfinity)||(v.distance > e.Weight))) {
					if(v.isInfinity){
						v.isInfinity =false;
					}
					v.distance = e.Weight;
					v.parent = u;
					indexedVertex.decreaseKey(v);
				}
			}
		}
		return wmst;
	}

   
}
/**
 * Sample input:
------------
7 12
1 2 2
1 4 1
1 3 1
3 4 2
3 6 5
6 7 1
7 5 1
5 2 10
4 5 7
4 7 4
4 6 8
4 2 3
Sample output:
--------------
Weight of MST using indexed priority queue=10
Time for Prime MST using Indexed priority queue=5
*/