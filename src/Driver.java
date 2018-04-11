import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Author: Connor Ludwig, Kendell Prather
*Date:4/10/18
*Overview: Graphing algorithm's using weights and labels read in from an adjacency matrix
*Special Instructions: We used the number "1000" to represent infinity
*/


public class Driver {
	public static void main(String[] args)throws FileNotFoundException
	{
            //all used to read in file and created matrix of labels and weights
		int[][] matrix = null;
		String[] labels = null;
                int count = 0;
                String csvFile = "matrix.txt";
                BufferedReader br = null;
                String line = "";
                String cvsSplitBy = ",";
		
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            labels = line.split(cvsSplitBy); // use comma as separator
            matrix = new int[labels.length][labels.length];
            while((line = br.readLine()) != null){
                String[] tmpMatrix = null;
                tmpMatrix = new String[labels.length];
                tmpMatrix = line.split(cvsSplitBy);
                for(int i = 0; i < labels.length; i++){
                 matrix[count][i] = Integer.parseInt(tmpMatrix[i]);
                }
                count++; //count is used to keep track of x value when populating matrix
            }
            

            
        //catches file not found exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		//creates graph object
		Graph graph = new Graph(labels, matrix);
		
                //calls all algorithms
		System.out.println("Prim's: ");
		graph.prim();
		graph.reset();
		
		System.out.println("Kruskal's:");
		graph.kruskal();
		graph.reset();
		
		System.out.println("Floyd Warshall");
                graph.floydWash(matrix);
                graph.reset();

		
	}
	
}