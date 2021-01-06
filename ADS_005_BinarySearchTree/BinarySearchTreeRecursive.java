class BinarySearchTreeRecursive {

    class Person{ // We want to store Person's data at Binary search tree..
        String name; // Person data contains name, gender and id.
        String gender;
        int id;
        public Person(String name,String gender,int id){
            this.name=name;
            this.gender=gender;
            this.id=id;
        }
        public String toString(){ // instead of hashedvalue it gives string representation of Person's object
            return ""+this.id+this.name;
        }
    }
    class Node{
        Person data;
        Node left;
        Node right;
        public Node(String name, String gender, int id){
            this.data=new Person(name,gender,id);// Anonymous Object creation of Person, to store in a Node 
        }
        public String toString(){ return ""+this.data;}
    }
    Node root=null;
    int size=0;
    public BinarySearchTreeRecursive(){ // constructor of Bst which make root to Null, every time we create new Object.
    root=null;
    }
    //The worst case time complexity of search and insert operations is
        // O(h) where h is height of Binary Search Tree.
    Node addnodeRecursively(Node root, Node node){ 
        // base condition of Recursive Problem->    if(root==null) return node;
                // (as it is recursive function- here root variable contains actually curent node each time..) 
                //when root is empty then just add node ar root.
        if(root==null) return node;
        // when new node is lesser than root -> go to left subtree of root and again 
        //start the function by making - left child of root ->as root 
        // restore Point(Previous Execution State) stored at callstack.. it restored again when 
        // newly function call finshed..
        if(node.data.id<root.data.id)root.left=addnodeRecursively(root.left, node);

        // when new node is greater than root -> go to right subtree of root and again 
        //start the function by making - right child of root ->as root
        // restore Point(Previous Execution State) stored at callstack.. it restored again when 
        // newly function call finshed..
        else if(node.data.id>root.data.id)root.right=addnodeRecursively(root.right, node);

        else return root;// value already present.
        return root; //retuen root, 
    }
    public void addNode(String name, String gender, int id){
        Node node = new Node(name, gender, id);// create new Node.
        root=addnodeRecursively(root, node);// root became newly returned root by the function addnodeRecursively,
                                                // Old root garbage collected.
        size++;// increment the size
    }
    boolean searchnodeRecursively(Node root, int id){
        if(root == null){return false;} // base case of recursive problem.
        if(id==root.data.id) return true; // we find the match so return true

        // else recursively call for left subtree and right subtree, by checking the id is smaller og greater than root
        //(as it is recursive function- here root variable contains actually curent node each time..) 
          // when id is lesser than root -> go to left subtree of root and again 
        //start the function by making - left child of root ->as root 
         // when id is greater than root -> go to right subtree of root and again 
        //start the function by making - right child of root ->as root 
        return id < root.data.id? searchnodeRecursively(root.left,id):searchnodeRecursively(root.right,id);
    }
    public boolean searchNode(int id){
        return searchnodeRecursively(root, id);
    }
    Person inOrderSuccessor(Node root){ 
        // here we get input root as -> root.right, means we just have to find
        // the smallest of root.right, because that will be the in-Order Successor
        Person minv= root.data;// we create a Person type variable to store the data to root.right as it gives as input.
        while(root.left!=null){ // till (curent node)root.right has left child loop executes.
            minv=root.left.data; //and here in the loop, we assign the data of Person typed -> in the minv variable
            root=root.left; // just incrementing towards left...
        }
        return minv;// the left most item of inputed-root.right is returned.
    }
    public Node deletenodeRecursively(Node root, int key){
        if(root==null) return root; // base case of recursive Problem.
        if(key<root.data.id) root.left=deletenodeRecursively(root.left, key);// find the element at left subtree
        else if(key>root.data.id) root.right=deletenodeRecursively(root.right, key);// find the element at right subtree
        //when found then:-
        else{
            if(root.left==null) return root.right;// if it has only right child then replaced it with right child.
            // here also No child case get handeled as we replacing with right child instead of checking right child present or not, so if right child is not present then instead of right child- it is replaced by null.


            else if(root.right==null) return root.left;// if it has only left child then replaced it with left child.


            //if it has both child then replaced it with in order successor. then delete that inorder successor as
            // it is still prsent at his position. 
            //Now the twist is as it is inorder successor so it can have right child or no chils, as it is left most of root.right.
            // Now again we call delete function by passing the inorder successor's id. 
            root.data=inOrderSuccessor(root.right);// here root.data changed to in-Order Successor of root(curent node).
            root.right=deletenodeRecursively(root.right, root.data.id);
        }
        return root;
    }
    public void deleteNode(int id){
        root=deletenodeRecursively(root, id);
    }
    public void findSmallest(){
        Node n= root;
        while(n.left!=null)n=n.left;
        System.out.println("Smallest item present : "+n.data);
    }
    public void findLargest(){
        Node n= root;
        while(n.right!=null)n=n.right;
        System.out.println("Largest item present : "+n.data);
    }
//BFS and DFS
     //Pythonic List // this is work as STACK as well as QUEUE
class Entry<T>{T mygen;Entry(T item){this.mygen=item;}
public String toString(){return ""+mygen;}}
class PytList<T>{
Entry[] ar;
int capacity;
public int top;
int front;
public int size;
public PytList(int capacity){
    this.capacity=capacity;
    ar=new Entry[capacity];
    top =-1;
    front=0;
    size=0;
}
public void push(T item){
    Entry<T> entry= new Entry<T>(item);
    if(top==capacity) return;
    top=(top+1)%capacity;
    ar[top]=entry;
    size++;
}
public Entry pop(){ // Stack pop
    if(top<0) return null;
    Entry temp=ar[top];
    ar[top]=null;
    top=(top-1)%capacity;
    size--;
    return temp;
}
public Entry pop(int first){ // Queue pop
    if(top<0) return null;
    Entry temp=ar[front];
    ar[front]=null;
    front=(front+1)%capacity;
    size--;
    return temp;
}
}
    public void bfs(){
        System.out.println("BFS:->");
        if(root==null) return;
        PytList Q=new PytList<Node>(size);
        Q.push(root);
        while(Q.size!=0){
            Entry<Node> ent= Q.pop(0);
            Node n=ent.mygen;
            System.out.print("  "+n.data.id+" - "+n.data.name+""+n.data.gender+"-->");
            if(n.left!=null) Q.push(n.left);
            if(n.right!=null) Q.push(n.right);
        }
        System.out.println();
    }
    public void dfs(){
        System.out.println("DFS:->");
        if(root==null) return;
        PytList St=new PytList<Node>(size);
        St.push(root);
        while(St.size!=0){
            Entry<Node> ent= St.pop();
            Node n=ent.mygen;
            System.out.print("  "+n.data.id+" -"+n.data.name+""+n.data.gender+"-->");
            if(n.left!=null) St.push(n.left);
            if(n.right!=null) St.push(n.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BinarySearchTreeRecursive obj= new BinarySearchTreeRecursive();
        System.out.println();
        obj.addNode("R", "M", 56);
        obj.addNode("u", "F", 12);
        obj.addNode("p", "F", 11);
        obj.addNode("a", "M", 45);
        obj.addNode("M", "M", 90);
        obj.addNode("G", "M", 67);
        obj.addNode("a", "f", 3);
        obj.addNode("n", "m", 98);
        obj.addNode("g", "F", 43);
        obj.addNode("dev", "m", 100);
        obj.bfs();
        obj.deleteNode(3);// delete leaf node
        obj.bfs();
        obj.deleteNode(12);// delete parent of both child
        obj.bfs();
        obj.deleteNode(98);// delete parent of one child
        obj.bfs(); 
        System.out.println( obj.searchNode(45)+"    Item is Present");
        obj.findSmallest();
        obj.findLargest();
        obj.bfs();
        obj.dfs();
    }
}
