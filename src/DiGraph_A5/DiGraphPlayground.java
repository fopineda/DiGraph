package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
//	  testAddNode();
//    testAddEdges();
//    testDelNodes();
//	  testDelEdges();
    }
  
    public static void exTest(){
      // addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel)
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(0, "f", "s", 0, null);
      d.addEdge(1, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
      d.topoSort();
      //printTOPO(d.topoSort());
      
    }
    
    
    public static void testAddNode(){
    	DiGraph d = new DiGraph();
    	System.out.println(d.addNode(1,"f"));
    	System.out.println(d.addNode(1, "e"));
    	
//    	addNode(1, f)
//    	addNode(1, e) == False
    }
    
    public static void testAddEdges(){
    	DiGraph d = new DiGraph();
    	System.out.println(d.addNode(1, "f"));
    	System.out.println(d.addNode(3, "s"));
    	System.out.println(d.addNode(7, "t"));
//    	System.out.println(d.addNode(6, "si"));

    	System.out.println(d.addEdge(0, "w", "s", 0, null));
//    	System.out.println(d.addEdge(1, "f", "t", 0, null));

//    	addNode(1, f)
//    	addNode(3, s)
//    	addNode(7, t)
//    	addEdge(0, w, s, 0, null) == False
    }
    
    
    public static void testDelNodes(){
    	DiGraph d = new DiGraph();
    	System.out.println(d.delNode("f"));
    	System.out.println(d.addNode(1,"f"));
    	System.out.println(d.delNode("f"));
    	System.out.println(d.addNode(3,"f"));
    	System.out.println(d.delNode("f"));
//    	d.delNode("f");
//    	d.addNode(1,"f");
//    	d.delNode("f");
//    	d.addNode(3,"f");
//    	d.delNode("f");
    }
    
    public static void testDelEdges(){
    	DiGraph d = new DiGraph();
    	System.out.println(d.delEdge("f","s"));
    	System.out.println(d.addNode(1,"f"));
    	System.out.println(d.addNode(3,"s"));
    	
    	System.out.println(d.addEdge(0,"f","s",0,null));
    	System.out.println(d.delEdge("f","s"));
    	System.out.println(d.delEdge("f","s"));
    	System.out.println(d.addEdge(0,"f","s",0,null));
    	//System.out.println(d.delEdge("f","s"));
    	
    	System.out.println(d.myMap.get("f").getInDegree());
    	System.out.println(d.myMap.get("f").getOutDegree());

    	
//    	delEdge(f, s)==false
//    	addNode(1,f)
//    	addNode(3, s)
//    	addEdge(0, f, s, 0, null)
//    	delEdge(f,s)==true
//    	delEdge(f,s)==false
//    	addEdge(0, f, s, 0, null)==true
//    	delEdge(f,s)==true
    	
    }
    
    
    
    
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}