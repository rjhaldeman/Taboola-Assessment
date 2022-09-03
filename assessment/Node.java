package assessment;

public class Node {

	Node left;
	Node right;
	int num;
	
	//Modification to support cyclic graphs
	String id = "";
	

public Node(int i) {
	
	num = i;
	
	}
//Constructor to support Cyclic graphs
public Node(int i, String ID) {
		
		num = i;
		id = ID;
		
		}

}