package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Serializer implements TreeSerializer{

	
	Node root;

	
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

	static int c;
	public Node deserialize(String str) {
		if (str == null)
            return null;
        c = 0;
        String[] arr = str.split(",");
        return deserializer(arr);
	}
	
	public Node deserializer(String[] arr) {
		if (arr[c].equals("@"))
            return null;
        // create node with this item and recur for children
        Node root = new Node(Integer.parseInt(arr[c]));
        c++;
        root.left = deserializer(arr);
        c++;
        root.right = deserializer(arr);
        return root;
	}
	
	
	
	
	public void preorder(Node root) {
		// TODO Auto-generated method stub
		
	        if (root != null) {
	        	System.out.print(root.num + " ");
	        	preorder(root.left);
	            
	        	preorder(root.right);
	        }
	    
	}
	

	
	
	
}