import java.util.ArrayList;

public class Graph {
	
	private Vertex[] points;
	private String[] labels;
	private int pCount;


	public Graph(String[] inLabels, int[][] matrix) {
		//creates an array of vertices 
		points = new Vertex[inLabels.length];
		///populates the array with data from the matrix
		for (int i = 0; i < points.length; i++)
		{
			points[i] = new Vertex(matrix[i], i);
		}
		labels = inLabels;
		pCount = labels.length;
		
	}
	
	//method to run kruskal algorthm
	public void kruskal()
	{
         //creates an array list for edges and forest
	 ArrayList<Edge> forest = new ArrayList<Edge>();
	 ArrayList<Edge> edges = new ArrayList<Edge>();
         
	/*progress is used to make sure no duplicate edges are added, used as an offset so the program knows to reduce
        the points it chooses from.*/
        int progress = 0;
        
		for (int j = 0; j < points.length; j++)
		{
			int[] cands = points[j].getNeighbors();
			for (int i = 0; i < cands.length - progress; i++)
			{
				////makes sure edge is not itself or infinity
				if (cands[i + progress] != 0 && cands[i + progress] != 1000)
				{
					edges.add(new Edge(cands[i + progress], points[i + progress], points[j]));
				}
			}
			progress++;
		}
		
		int size = edges.size();
		Edge min = edges.get(1);
		
                //do while loop to visit edges
		do {
			
			//find smallest edge
			if (!edges.isEmpty())
			{	
				min = edges.get(0);   //start with first edge for comparison sake
			}
			int pos;
			for (int i = 0; i < edges.size(); i++)
			{
				if (edges.get(i).getWeight() < min.getWeight()) 
				{
					min = edges.get(i);
					pos = i;
				}
			}
			
			//visit points of biggest edge
			
			min.visit();
			
			//remove biggest edge
			edges.remove(min);
			forest.add(min);
			
			
			
		} while(forest.size() < size); 	//runs until all sided are visited
                
                //prints path
		for (int i = 0; i < forest.size(); i++)
			{
				System.out.print(labels[forest.get(i).getPoints()[0]]);
				System.out.print(labels[forest.get(i).getPoints()[1]] + " ");
				
			}
			System.out.println("");
                        System.out.println("");
	}
	
	public void reset()
	{
		for (Vertex i: points)
		{
			i.reset();
		}
	}
	
        
        //method to run PrimJarnik algorthm
	public void prim()
	{
		ArrayList<Edge> path = new ArrayList<Edge>();	
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		//start at the first vertex
		int[] cands = points[0].getNeighbors();  //cands = the adjacent verticies 
		
		
		
		//initialize list of edges
		for(int i = 0; i < pCount; i++)
		{       
                        //makes sure edge is not itself or infinity
			if (cands[i] !=0 && cands[i] != 1000)
			{
				edges.add(new Edge(cands[i], points[0], points[i])); //add all edges stemming from the first vertex to the list
			}
		}
		
		//do while loop to visit edges
		do {
			
			//find smallest edge
			
			Edge min = edges.get(0);   //start with first edge for comparison sake
			Vertex curr;
			for (int i = 0; i < edges.size(); i++)
			{
				if (edges.get(i).getWeight() < min.getWeight())
				{
					min = edges.get(i);
				}
			}
			
			//visit points of smallest edge
			min.visit();
			
			//remove smallest edge
			edges.remove(min);
			path.add(min);
			
			//add the new edges
			curr = points[min.getPoints()[1]]; //vertex is set up (origin, destination) (x,y) 
			cands = curr.getNeighbors(); //cands now becomes the nighbors of the most recently visited vertex
			for(int i = 0; i < pCount; i++)
			{
				if (cands[i] !=0 && !(points[i].isVisited()) && cands[i] != 1000)
				{
					edges.add(new Edge(cands[i], curr, points[i])); //add any vertex in that has weight and that has not been visited yet.
				}
			}
			
			
			
		} while(!mstCheck());
                
                
                    //prints path
                    for (int i = 0; i < path.size(); i++)
			{
			 System.out.print(labels[path.get(i).getPoints()[0]]);
			 System.out.print(labels[path.get(i).getPoints()[1]] + " ");
				
			}
			 System.out.println();
                         System.out.println("");
		
    }
	
	//check if all the points have been visited
	public boolean mstCheck()
	{
		
		int visited = 0;
		for (Vertex point: points)
		{
			if (point.isVisited())
			{
				visited++;
			}
		}
		

		
		
		if (visited==pCount) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//method to run Floyd Walshall
	 public void floydWash(int[][] matrix){
		    

	        int V=points.length;
	        int path[][] = new int[V][V];
	        int i, j, k;
	 
	        //Initialize the path to be the same as matrix
	        for (i = 0; i < V; i++)
	            for (j = 0; j < V; j++)
	                path[i][j] = matrix[i][j];
	 
	        
	        for (k = 0; k < V; k++)
	        {
	            
	           
	            for (i = 0; i < V; i++)
	            {
	                
	                
	                for (j = 0; j < V; j++)
	                {
	                    //If it is the shortest path then add it to the path answer
	                    if (path[i][j] > path[i][k] + path[k][j])
	                        path[i][j] = path[i][k] + path[k][j];
	                    
	                }
	            }
	            // Print the Matrix each step of the way
	            printMatrix(path);
	            System.out.println("");
	        }
	         }

         //method to print matrix
	 public void printMatrix(int[][] matrix)
	 {
		 for (int i = 0; i < pCount; i++)
		 {
			 
			 for (int j = 0; j < pCount; j++)
			 {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.println();
		 }
	 }
}
