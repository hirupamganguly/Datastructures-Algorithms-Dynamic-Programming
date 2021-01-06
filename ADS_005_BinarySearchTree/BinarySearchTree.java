/*  Binary Tree is a tree which have maximum 2 children of each Node.
    Binary Search Tree is a Special Tree of Binary tree in which Nodes are arranged in a Specific manner.
    Only smaller valued item will present in Left Subtree, of Parent Node.
    Only Greater valued item will present in Right Subtree, of Parent Node.
*/
public class BinarySearchTree {
    Node root;// this variable always pointing Root of the Tree. First Node
    
    public void ins(Person item){
        // This method is use to Insert Item at appropriate position

        Node node= new Node();
        node.data=item;
        if(root==null){
            // If tree is empty then First inserted Node will be Root
            root=node;
        }
        else{
            // if tree is not Empty, then
            Node n =root;// Create n variable which Initially point to Root
            Node parent;
            while(true){
                parent=n;// Every time Loop runs, parent is contain the current n Node
                if(n.data.roll>item.roll){
                    //if n is greater then item, then
                    n=n.left;// goes Left Node of n
                    if(n==null){// if n is empty then 
                        parent.left=node;// make left Node of Parent to "node"
                        return;// and Terminate The Loop
                    }
                }else{
                    // if n is lesser than item, then
                    n=n.right;// goes Right Node of n
                    if(n==null){// if n is empty then 
                        parent.right=node;// make right Node of Parent to "node"
                        return;// and Terminate The Loop
                    }
                }
                // If Both "if(n==null)" condition get false, then Loop never Terminated
                // And acoording to IF-ELSE condition we goes either LEFT or RIGHT of ROOT Node one by one..
               
            }
        }
    }

//     public Node del(int key) {
//         // when root is null or root is the node we want to delete just call deleteNode() methd its return null 

//         if (root==null || root.data.roll==key) return deleteNode(root);
//         // create a variable which points root and help to find the deletedNode via while loop
//         Node p=root;
        
//         while (true) { // search the node
//         if (key>p.data.roll) {
//             // if delnode is greater than p
//             if (p.right==null || p.right.data.roll==key) {
//                 // p does not have right child or right child of p is delnode
//                 p.right=deleteNode(p.right);// just call deleteNode() and store the output on right of PARENT OR P
//                 // HERE P IS ACT AS PARENT OF DELNODE
//                 break;
//             }
//             p=p.right;
//         }
//         else {
//             if (p.left==null || p.left.data.roll==key) {
//               // p does not have LEFT child or left child of p is delnode
//                 p.left=deleteNode(p.left);// just call deleteNode() and store the output on left of PARENT OR P
//                 // HERE P IS ACT AS PARENT OF DELNODE
//                 break;
//             }
//             p=p.left;
//         }
//     }
//         return root;
//     }
        
//     private Node deleteNode(Node no) {
//         if (no==null) return null;// when we get no as null
//         if (no.right==null) return no.left;// no does not have right childtree then just return its left childtree
//         Node x=no.right; // root.right should be the new node in place of delNode
//         while (x.left!=null) x=x.left; // find the left-most node// Successor
//         x.left=no.left;// left child of no or delNode put onto successor's left
//         return no.right;// return no.right means return delNode's right subtree which is pit on parents of delNode's Right or Left child
//     }
        
 
    public void del(int roll){
        // This method is use for Deleting item

        if(root==null){
            System.out.println("EMPTY");
        }
        else{
            Node n=root;// Create n variable which Initially point to Root
            boolean leftchild=false;
            Node parent=null;
            while(n.data.roll !=roll){
                parent=n;// Every time Loop runs, parent is contain the current n Node
                if(n.data.roll>roll){
                    //if n is greater then item, then
                    leftchild=true;
                    n=n.left;// goes Left Node of n
                }else{
                    leftchild=false;
                    n=n.right;// goes Right Node of n
                }
                if(n==null){
                    // if n is empty then 
                    return;//Terminate The Loop
                }
            }
        //---------------------------------------------------------------------------------------
            // if the node has no child

            if(n.left==null && n.right==null){
                if(n==root){
                    // and if we want to delete the root node
                    // Here the Size of tree is Only 1    / Only One Node is present In whole tree..
                    root=null;// then just make null to root Node.
                }
                else{
                    // If tree has Size more than 1
                    if(leftchild==true){
                        // and if the node is Left Child of its Parent, then make null of "Left child of parent"
                        parent.left=null;
                    }else{
                        // and if the node is Right Child of its Parent, then make null of "Right child of parent"
                        parent.right=null;
                    }
                }
                
            }
        //----------------------------------------------------------------------------------------------
            //When Node has One Child

                // Only has Left Child
                else if(n.right==null){
                    
                    if(n==root){// if root has only Left child
                        // make that child to root
                        root=root.left;
                    }
                    else{// if node is Not Root
                        if(leftchild==true){// if the node is Left child of its Parent
                            parent.left=n.left;// make node's left child to parent left child
                        }
                        else{// if the node is Right child of its Parent
                            parent.right=n.left;// make node's left child to parent right child
                        }
                    }
                }
                // Only has Right Child
                else if(n.left==null){
                    
                    if(n==root){// if root has only Right child
                        // make that child to root
                        root=root.right;
                    }
                    else{// if node is Not Root
                        if(leftchild==true){// if the node is Right child of its Parent
                            parent.left=n.right;// make node's right child to parent left child
                        }
                        else{// if the node is Right child of its Parent
                            parent.right=n.right;// make node's right child to parent right child
                        }
                    }
                }
        //-------------------------------------------------------------------------------------------
            // When node has Both Child---COMPLICATED

            else if(n.left!=null && n.right!=null){
                Node successor=getSuccessor(n);// calling getSuccessor() method, then Store the Retured output 
                //on successor Node typed Variable
                if(n==root){
                    root=successor;// if root has Both the child, make the successor as Root
                }
                else{
                    // if node is not Root Node
                    if(leftchild==true){
                        // if node is Left child of its Parent
                        parent.left=successor;// make successor as its Parent.left
                    }else{
                         // if node is Right child of its Parent
                        parent.right=successor;// make successor as its Parent.right
                    }
                }
                successor.left=n.left;// Make Left SubTree of n as Left Subtree of succesor
            System.out.println("done");
            } 
        }
        
    }
    public Node getSuccessor(Node d){
        Node successor=null;
        Node sucParent=null;
        Node n1=d.right;// Create n1 variable which Initially point to right child of d Node.
        while(n1!=null){
            //  until n1 is null, do-
            sucParent=successor;// each time Loop run, parent of successor make successor
            //  sucParent just contain the parent of -next Small element of Node d present on tree
            //  sucParent just contain the parent of -next Small element of Node d present on tree
            successor=n1;// n1 node is going to be the next successor
            n1=n1.left;// left subtree of n1 node became new n1
            //  we goes leftest Node of -righ child of -Parent of d.
            //  When Loop terminates we get the -next Small element of Node d present on tree
        }
        
        if(successor!=d){
            //  if successor is not the d Node, then
            sucParent.left=successor.right;// right subtree will became the left subtree of Parent of successor
            successor.right=d.right;// right subtree of d became the right subtree of successor Node..
        }
        return successor;
    }

    // public void show(Node n){
    //     Node ni=n;
    //     System.out.println(ni.data);
    //     if(ni.left!=null){
    //         show(ni.left);
    //     }
    //     if(ni.right!=null){
    //         show(ni.right);
    //     }
    // }
    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.data + " -->"); 
    }
}
