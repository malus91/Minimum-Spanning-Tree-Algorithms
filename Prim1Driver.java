import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/**
 * The level 1 driver class.
 * @author 
 *     Group -G12
 *     Anirudh Kuttiyil Valsalan
 *     Malini Kottarappatt Bhaskaran
 *     Neha Nirmala Srinivas
 *     Saumya Ann George
 */
public class Prim1Driver {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = null;
		File file = null;
		try {
			if (args.length > 0) {
				file = new File(args[0]);

				in = new Scanner(file);
			}

			else {
				System.out.println("Enter File Path");
				Scanner inFile = new Scanner(System.in);
				file = new File(inFile.next());
				inFile.close();
				in = new Scanner(file);
			}

			Graph g = Graph.readGraph(in, false);
			long totalLength = 0;
			PrimBasedMST primBasedMST = new PrimBasedMST();
			totalLength = primBasedMST.primMST(g);
			System.out.println("total length is " + totalLength);
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
