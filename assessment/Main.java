package assessment;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Serializer tree = new Serializer();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(4);
        tree.root.right.right = new Node(28);
 
        //initial view
        System.out.println("First Preorder Traversal of the tree constructed from serialized String:");
        tree.preorder(tree.root);
        
        
        String serialized = tree.serialize(tree.root);
        System.out.println("\nSerialized view of the tree:");
        System.out.println(serialized);
        System.out.println();
 
       
        
        
        Node r = tree.deserialize(serialized);
       
        System.out.println("Preorder Traversal of the tree constructed from serialized String:");
        tree.preorder(r);
           
            
            
            
//            
//        String[] test = new String[]{"aa1","ab1","ac3"};
//        for(int i = 0; i < test.length; i++) {
//        
//        	System.out.println(test[i]);
//        	System.out.println(test[i].substring(2));
//        
//        }
        
        
        
        
        
        CyclicSerializer cyclictree = new CyclicSerializer();
        cyclictree.root = new Node(1,"aa");
        cyclictree.root.left = new Node(2,"ab");
        cyclictree.root.right = new Node(3,"af");
        cyclictree.root.left.left = new Node(4,"ac");
        cyclictree.root.left.left.left = new Node(5,"ad");
        cyclictree.root.left.left.right = new Node(6,"ae");
        cyclictree.root.right.left = new Node(7,"ag");
        cyclictree.root.right.left.left = cyclictree.root;
 
        //initial view
        System.out.println("\n\n\nCYCLIC First Preorder Traversal of the tree constructed from serialized String:");
        ArrayList<Node> n = new ArrayList<Node>();
        cyclictree.preorder(cyclictree.root,n);
        
        
        String serialized2 = cyclictree.serialize2(cyclictree.root);
        System.out.println("\nSerialized view of the tree:");
        System.out.println(serialized2);
        System.out.println();
 
       
        
        
        Node cr = cyclictree.deserialize2(serialized2);
       
        System.out.println("Preorder Traversal of the tree constructed from serialized String:");
        cyclictree.preorder(cr,cyclictree.dict);
//        
//        
            
            
        
		
	}

	

}
