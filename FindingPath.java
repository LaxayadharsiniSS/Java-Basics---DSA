import java.util.*;

class Node{
    int val;
    Node left, right=null;
    Node(int value){
        this.val=value;
    }
}
class FindingPath{

    static Stack<Node> stk; //stk is to store the nodes as we traverse from root to the destination node
    static boolean isFound; //maintain this variable to track if the node is found or not

    static void DFS(Node node, Node dest){
        if(node == dest) isFound=true;
        if(node!=null){
            if(node.left!=null && !isFound) 
            {
                stk.push(node.left);
                DFS(node.left, dest);
            }
            // impose isFound condition here as well to stop the right search if the destination node is found (because recursion ended at line 21 will resume here instead the main if block)
            if(node.right!=null && !isFound)
            {
                stk.push(node.right);
                DFS(node.right, dest);
            }
            //at this point of time, any node that has either left or right child / or no child would have been explored....................
            // when child node is reached and the destination node is not still found, pop the child node from stk to follow a different path
            //when any node that has either left or right child or both is explored and the destination node is not still found, pop their child
            if(!isFound){
                stk.pop();
            }
            //3rd & 4th if blocks are independent and can be executed in either orders.
        }
    }

    static void print(Node root){ //print method to print the tree in an inOrder traversal
        if(root!=null){
            System.out.println(root.val);
            print(root.left);
            print(root.right);
        }
    }

    public static void main(String args[]){

        Node root = new Node(2);
        Node temp = root;
        temp.left = new Node(4);
        temp.right = new Node(3);
        Node temp1 = temp.left; //4
        Node temp2 = temp.right; //3
        temp1.left = new Node(1);
        temp1.right = new Node(5);
        temp2.left = new Node(7);
        temp2.right = new Node(6);
        Node temp3 = temp1.left; //1
        Node temp4 = temp1.right; //5
        Node temp5 = temp2.left; //7
        Node temp6 = temp2.right; //6
        temp3.left = new Node(8);
        temp3.right = new Node(9);
        temp4.left = new Node(10);
        temp4.right = new Node(11);
        //print(root);
        
        stk = new Stack<>();
        stk.push(root);
        DFS(root, temp2.left);
        String pathToSrc = "";
        while(stk.size()!=1){ //we don't want to print root node twice in the output and hence the last node in stack (i.e, the root node) is not appended in string
            pathToSrc = pathToSrc+" "+stk.pop().val; //since we go towards root - we merge in the same order we have in stack
        }      

        isFound=false;
        stk = new Stack<>();
        stk.push(root);
        DFS(root, temp3.right);
        String pathToDest ="";
        while(!stk.isEmpty()){
            pathToDest = stk.pop().val +" "+pathToDest;
        }
        System.out.println(pathToSrc+", "+pathToDest);
    }
}


/*

Find path from root to a child node in the following binary tree:
                2
        4               3
    1       5       7      6
8     9 10    11  

Approach:
Use DFS to traverse in depth

Time Complexity: O(V+E) where V-> number of vertices, E-> number of edges
Space Complexity: O(V) where V is the number of vertices in the tree
*/