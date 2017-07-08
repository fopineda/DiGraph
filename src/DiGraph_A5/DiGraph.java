package DiGraph_A5;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class DiGraph implements DiGraph_Interface {

 
	public Map<String, Vertex> myMap = new HashMap<String, Vertex>(); // name -> node
	public Set<Long> nodeIds = new HashSet<Long>();       
	public Set<Long> edgeIds = new HashSet<Long>();
	Stack<String> box;

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }
  
  
  // not unique == inside in the list/set/map already

  
 // [DONE] 
@Override
public boolean addNode(long idNum, String label) {   // adding a node to the HashMap
	// Label is mapped to nodes
	Vertex tempVertex = new Vertex(label, idNum);
	if ((idNum < 0) || (nodeIds.contains(idNum)) || (label == null)){  // node number is less zero OR is not unique
		return false;
	}
	else{
		if (myMap.containsKey(label)){    // label is not unique
			return false;
		}
		else{
			myMap.put(label, tempVertex);
			nodeIds.add(idNum);
			return true;
		}
	}
}


// [DONE]
@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// don't do nothing with eLabel and weight for now
	if ((sLabel == null) || (dLabel == null)){
		return false;
	}
	if ((idNum < 0) || (edgeIds.contains(idNum))){ // edge number is less zero OR is not unique
		return false;
	}
	if ((myMap.containsKey(sLabel)) && (myMap.containsKey(dLabel))){   // they do have nodes in he map
		if (!( myMap.get(sLabel).edges.containsKey(dLabel) )){   // if no edge is there	
			myMap.get(sLabel).edges.put(dLabel, new Edge(dLabel, weight, idNum));
			edgeIds.add(idNum);
			// for toposort purposes
			myMap.get(sLabel).outDegree++;
			myMap.get(dLabel).inDegree++;
			return true;
		}
		else{
			return false;
		}
	}
	else{
		return false;
	}	
}

// [DONE]
@Override
public boolean delNode(String label) {  // removing node with the edges in and out of it
	if (myMap.containsKey(label)){ // node exits
		nodeIds.remove(myMap.get(label).idNum);  // delete nodeID
		myMap.get(label).edges.clear();      // delete edges
		myMap.remove(label);    // delete actual node
		return true;
	}
	else{   // node does not exist
		return false;
	}
}

// [DONE]
@Override
public boolean delEdge(String sLabel, String dLabel) {
	if (myMap.containsKey(sLabel) == true){
		if ((myMap.get(sLabel).edges.containsKey(dLabel))){   // there is an edge
			edgeIds.remove(myMap.get(sLabel).edges.get(dLabel).idNum);  // delete edge id
			myMap.get(sLabel).edges.remove(dLabel);    // delete actual edge
			// for toposort purposes
			myMap.get(sLabel).outDegree--;
			myMap.get(dLabel).inDegree--;
			return true;
		}
		else{
			return false;
		}
	}
	else{
		return false;
	}	
}

// [DONE]
@Override
public long numNodes() {
	return nodeIds.size();
}

// [DONE]
@Override
public long numEdges() {
	return edgeIds.size();
}

// [DONE]
@Override
public String[] topoSort() {
	box = new Stack<String>();
	int counter = 0;
	String[] myArray = new String[(int)this.numNodes()];
	
	// pushing the nodes with indegree of 0 into the stack
	for (String s : myMap.keySet()){
		if (myMap.get(s).getInDegree() == 0){
			box.push(s);
		}
	}
	
	while( !(box.isEmpty()) ){
		// delete/pop the first node with indegree of zero
		String temp = box.pop();
		myArray[counter] = temp;
		counter++;
			
		// going through the nodes to decrement the indegrees (also push those nodes that have indegree of 0)
		for (String w : myMap.get(temp).edges.keySet()){
			if (myMap.get(w).getInDegree() == 0){
				box.push(w);
			}
			else{
				myMap.get(w).inDegree--;
				if (myMap.get(w).getInDegree() == 0){
					box.push(w);
				}
			}
		}
	}
	if (counter != ((int)(this.numNodes()))){
		return null;
	}
	return myArray;
	

}
  
  
}
