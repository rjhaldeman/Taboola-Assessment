package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CyclicSerializer {
	
		Node root;
	
		/*Below are the functions for the 2nd stage of the problem to serialize and
		* deserialize a cyclic graph.
		*
		* I went about this by adding an ID string to the Node class.
		* This was a fun and tricky problem to tackle. I went with one of my first solutions, being to add a String ID to each Node and store this
		* ID along with the Node's int value in the serialization String.
		*/
		
		/* This will serialize a "Binary Tree" that is cyclic.
		 * 
		 * @param root			root is the root Node of the Tree
		 * @return serialize2	This String will be the serialized tree
		 */
		public String serialize2(Node root) {
			if (root == null) {
	            return null;
	        }
			
	        Stack<Node> stack = new Stack<>();
	        
	        stack.push(root);
	 
	        List<String> returnString = new ArrayList<>();
	        
	        while (!stack.isEmpty()) {
	            Node cc = stack.pop();
	             
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
		//static into to keep track of Node values.
		static int cc;
		
		/* This will start the deserialization process for a cyclic binary tree. 
		 * 
		 * @param str				String to be deserialized.
		 * @return deserialize2		root Node of tree
		 */
		public Node deserialize2(String str) {
			if (str == null)
	            return null;
	        cc = 0;
	        String[] arr = str.split(",");
	        return deserializer2(arr);
		}
		
		/* This recursive function does the actual heavy lifting for the deserialization process.
		 * The function calls itself recurssively in a pr-eorder traversal fashion.
		 * 
		 * The main difference is that the ID string of each Node is stored in the String and when I rebuild the tree it will be by constructing
		 * new nodes with value and ID parameters.
		 * 
		 * The significance of the ID string is that if the tree is cyclic I will stop appening Nodes once a Node is adding into the tree for it's 2ND time.
		 * So if a leaf node points to the root for example, the entire tree will be constructed with the leaf Node having a child Node of the root but that root's child nodes will not be added.
		 *
		 * 
		 * @param arr				arr is a String array of Node values taken from the original String. 
		 * @return deserializer2	This is the Node of the tree deserialized from the tree.
		 * 
		 */
		public Node deserializer2(String[] arr) {
			if(cc > arr.length-1) {
				return null;
			}
			else{
				if (arr[cc].equals("@"))
	            return null;
	        
	        Node root = new Node(Integer.parseInt(arr[cc].substring(2)),arr[cc].substring(0, 2));
	        cc++;
	        root.left = deserializer2(arr);
	        cc++;
	        root.right = deserializer2(arr);
	        return root;
			}
		}
		
		
		
		//ArrayList serving as a dictionary to help with printing the tree for checking purposes.
		ArrayList<Node> dict = new ArrayList<Node>();

		//Similary Pre-order printing function however, once a Node is printed for a 2nd time, the process will stop printing it's children because this means a cycle was found in the tree.
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
