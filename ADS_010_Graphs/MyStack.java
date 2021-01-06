public class MyStack {
    Node [] st;
    int size=0;
    int top=-1;
    int capacity;
    public MyStack(int capacity){
        this.capacity=capacity;
        st=new Node[capacity];
    }
    public void ins(Node item){
        top++;
        st[top]=item;
        size++;
    }
    public Node pop(){
        Node temp= st[top];
        st[top]=null;
        top--;
        size--;
        return temp;
    }
}