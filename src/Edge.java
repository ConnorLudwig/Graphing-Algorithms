
public class Edge {

	private Vertex x; //new vertex object
	private Vertex y;
	private int weight;
	
	
	//edge constructor
	public Edge(int inWeight, Vertex inX, Vertex inY)
	{
		this.x = inX;
		this.y = inY;
		this.weight = inWeight;
	}
	
	public int getWeight()
	{
		return weight; //returns weight of an edge
	}
	
	public void visit()
	{
		x.visit(); //visit x
		y.visit(); //visit y
	}
	
	public int[] getPoints()
	{
		int[] points = {x.getPos(), y.getPos()};
		return points; //returns points
	}
}
