package task3;
import java.util.*;

/*
A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
to the root node inclusively.
A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

Please implement this method to
return the largest root-to-leaf sum in the tree.
*/

public class BetterProgrammerTask {

	public static void main(String[] args) { }
	
	// Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
    	
    	  if (root == null){
              return 0;
         }
         
         if (hasChildren(root) == false){
              return root.getValue();
         }

         List<Node> nodes = root.getChildren();
         Iterator<Node> iter = nodes.iterator();
         
         int max = 0;
         while (iter.hasNext()){
         
              Node node = iter.next();
              if (hasChildren(node) == false){
                   int rootValue = root.getValue();
                   int nodeValue = node.getValue();
                   int sum = rootValue + nodeValue;
                   if (sum > max){
                        max = sum;
                   }
              }
              
              if (hasChildren (node) == true){
                   int nodeSum = getLargestRootToLeafSum(root);
                   int sum = nodeSum + root.getValue();
                   if (sum > max){
                        max = sum;
                   }
              }  
         }
         return max;
    }
    
    public static boolean hasChildren(Node root){
        
        List<Node> nodes = root.getChildren();
        if (nodes == null){
             return false;
        }
        return true;
   }
}
