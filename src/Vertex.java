
public class Vertex {
	
	private boolean visitStat;
	private int[] neighbors;
	private int pos;
	
        //vertex constructor
	public Vertex(int[] inNeighbors, int inPos)
	{
		visitStat = false;
		this.neighbors = inNeighbors;
		this.pos = inPos;
		
	}
	
	public int[] getNeighbors()
	{
		return neighbors; //retuns vertex neighbors
	}
	
	public int[] visit()
	{
		visitStat = true; //changes visit status of a vertext to true
		return neighbors;
	}

	public boolean isVisited()
	{
		return visitStat; //checks if a vertex has been visited
	}
	
	public void reset()
	{
		visitStat=false; //resets matrix to be used again on another algorithm
	}
	
	public int getPos()
	{
		return pos; //returns position
	}
}
