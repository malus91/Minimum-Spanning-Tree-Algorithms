

/**
 * Disjoint set class, using union by rank and path compression.
 * @author 
 *     Group -G12
 *     Anirudh Kuttiyil Valsalan
 *     Malini Kottarappatt Bhaskaran
 *     Neha Nirmala Srinivas
 *     Saumya Ann George
 * Ref:http://www.cs.berkeley.edu/~jrs/61bs02/hw/hw9/set/DisjointSets.java 
 *
 */
public class DisjointSets {
	private int[] sets;
	/**
	 * create the disjoint sets object.
	 * 
	 * @param numElements
	 *       
	 */
	public DisjointSets(int numElements) {
		sets = new int[numElements + 1];
		//initialize every element to -1
		for (int i = 1; i < sets.length; i++)
			sets[i] = -1;
	}

	/**
	 * create union of two disjoint sets.
	 * 
	 * @param set1Root
	 *            the root of set 1.
	 * @param set2Root
	 *            the root of set 2.
	 */
	public void union(int set1Root, int set2Root) {
		if (sets[set2Root] < sets[set1Root]) // root2 is deeper than root1
			sets[set1Root] = set2Root; // Make root2 new root
		else {
			if (sets[set1Root] == sets[set2Root])
				sets[set1Root]--; // Update height if same
			sets[set2Root] = set1Root; // Make root1 new root
		}
	}

	/**
	 * Method to perform pathCompression.
	 * 
	 * @param element
	 *            the element being searched for.
	 * @return
	 *        the set containing element
	 */
	public int find(int element) {
		if (sets[element] < 0)
			return element;
		else
			return sets[element] = find(sets[element]);
	}

	

}