package assessment;

//Interface to be implemented from the prompt.
public interface TreeSerializer {

	String serialize(Node root);
	
	Node deserialize(String str);
	
}


