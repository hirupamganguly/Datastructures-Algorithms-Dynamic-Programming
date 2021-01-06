class MyQueue{
    Node[] q;
    int capacity;
    int size;
    int f;
    int r;
    public MyQueue(int capacity){
        this.capacity=capacity;
        size=0;
        q=new Node[capacity];
        f=-1;
        r=-1;
    }
    public void enQ(Node item){       
       if(size!=capacity){
           r++;
            q[r]=item;
        if(f==-1){
            f=0;
        }
        size++;
    } 
    }
    public Node deQ(){
        Node temp=q[f];

        if(size!=0){
            for(int i=0; i<r;i++){
            q[i]=q[i+1];
        }
        r--;
        size--;}
        return temp;
    }
}