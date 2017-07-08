package DiGraph_A5;

public class Edge {

	protected String dLabel;
	protected long weight;
	protected long idNum;
	
	
	public Edge(String theDLabel, long theWeight, long theIdNum){
		dLabel = theDLabel;
		weight = theWeight;
		idNum = theIdNum;
	}
}