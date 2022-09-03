package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CyclicSerializer {
	
		Node root;
	
		//Below are the functions for the 2nd stage of the problem to serialize and
		//deserialize a cyclic graph.
		//I went about this by adding an ID string to the Node class.
		public String serialize2(Node root) {
			if (root == null) {
	            return null;
	        }
			
	        Stack<Node> stack = new Stack<>();
	        
	        stack.push(root);
	 
	        List<String> returnString = new ArrayList<>();
	        
	        while (!stack.isEmpty()) {
	            Node cc = stack.pop();
	            // 
	            if (cc == null) {
	                returnString.add("@");
	            }
	            else {
	                // Else, store current node and recur for
	                // its children
	            	if(returnString.contains(cc.id+cc.num)) {
		            	returnString.add("" + cc.id+ cc.num);		

	            	}
	            	else {
	            		returnString.add("" + cc.id+ cc.num);
		            	stack.push(cc.right);
		                stack.push(cc.left);
	            	}
	            	
	            	

	                
	            }
	        }
	        return String.join(",", returnString);
		}

		static int cc;
		public Node deserialize2(String str) {
			if (str == null)
	            return null;
	        cc = 0;
	        String[] arr = str.split(",");
	        return deserializer2(arr);
		}
		
		public Node deserializer2(String[] arr) {
			if(cc > arr.length-1) {
				return null;
			}
			else{
				if (arr[cc].equals("@"))
	            return null;
	        // create node with this item and recur for children
	        Node root = new Node(Integer.parseInt(arr[cc].substring(2)),arr[cc].substring(0, 2));
	        cc++;
	        root.left = deserializer2(arr);
	        cc++;
	        root.right = deserializer2(arr);
	        return root;
			}
		}
		
		
		
		public void inorder(Node root) {
			// TODO Auto-generated method stub
			
		        if (root != null) {
		            inorder(root.left);
		            System.out.print(root.num + " ");
		            inorder(root.right);
		        }
		    
		}
		
		ArrayList<Node> dict = new ArrayList<Node>();

		public void preorder(Node root, ArrayList<Node> n) {
			// TODO Auto-generated method stub
			
				
		        if (root != null) {
		        	if(n.contains(root)) {
		        	System.out.print(root.num + " ");
		        	n.add(root);}
		        	else {
			        System.out.print(root.num + " ");
			        n.add(root);
		        	preorder(root.left, n);
		        	preorder(root.right, n);
		        	 }

		        }
		    
		}

}
