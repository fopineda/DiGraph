package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Vertex {

	protected String vertexLabel;
	protected long idNum;
	protected Map <String, Edge> edges;
	protected int inDegree = 0;
	protected int outDegree = 0;
	
	public Vertex (String myVLabel, long newIdNum){
		vertexLabel = myVLabel;
		idNum = newIdNum;
		edges = new HashMap<String, Edge>();
	}
	
	public long getIdNum(){
		return idNum;
	}
	
	public int getInDegree(){
		return inDegree;
	}
	
	public int getOutDegree(){
		return outDegree;
	}
	

	
	
}
