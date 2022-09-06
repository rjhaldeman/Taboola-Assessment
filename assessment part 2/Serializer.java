package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Serializer implements TreeSerializer{

	
	Node root;

	/* Standard function to serialize a Binary Tree. I use a stack of Nodes and a List of Strings to store and keep data.
	 * 
	 * 
	 * @param root			This is the starting root Node from the tree that I traverse. 
	 * @return serialize	The serialize String is going to the be a String of Node Values from the tree in a pre-order traversal 	fashion.
	 * 						This string can be deserialized later.
	 */
	public String serialize(Node root) {
		if (root == null) {
            return null;
        }
		
        Stack<Node> stack = new Stack<>();
        
        stack.push(root);
 
        List<String> returnString = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            Node c = stack.pop();
            // 
            if (c == null) {
                returnString.add("@");
            }
            else {
                // Else, store current node and recur for
                // its children
                returnString.add("" + c.num);
                stack.push(c.right);
                stack.push(c.left);

            }
        }
        return String.join(",", returnString);
	}
	//Static int to hold the value of the current Node.
	static int c;
	
	/*	This function will take the serialized String and return a root Node to the Binary Tree.
	 * 	@param			str is the String to be deserialized.
	 *  @return			deserialize is the Node that will be returned that serves as the tree root. 
	 */
	public Node deserialize(String str) {
		if (str == null)
            return null;
        c = 0;
        String[] arr = str.split(",");
        return deserializer(arr);
	}
	
	/* This recursive function does the actual heavy lifting for the deserialization process.
	 * The function calls itself recurssively in a pr-eorder traversal fashion.
	 * 
	 * @param arr				arr is a String array of Node values taken from the original String. 
	 * @return deserializer		This is the Node of the tree deserialized from the tree.
	 * 
	 */
	public Node deserializer(String[] arr) {
		if (arr[c].equals("@"))
            return null;
        // create node with this int value and recurs for children
        Node root = new Node(Integer.parseInt(arr[c]));
        c++;
        root.left = deserializer(arr);
        c++;
        root.right = deserializer(arr);
        return root;
	}
	
	
	
	//Simple traversal function to check
	public void preorder(Node root) {
		// TODO Auto-generated method stub
		
	        if (root != null) {
	        	System.out.print(root.num + " ");
	        	preorder(root.left);
	            
	        	preorder(root.right);
	        }
	    
	}
	

	
	
	
}