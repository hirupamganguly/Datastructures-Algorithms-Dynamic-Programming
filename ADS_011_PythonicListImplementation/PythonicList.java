class Entry<T>{T mygen;Entry(T item){this.mygen=item;}public String toString(){return ""+mygen;}}
class PytList<T>{
    Entry[] ar;
    int capacity;
    public int top;
    int front;
    public PytList(int capacity){
        this.capacity=capacity;
        ar=new Entry[capacity];
        top =-1;
        front=0;
    }
    public void push(T item){
        Entry<T> entry= new Entry<T>(item);
        if(top==capacity) return;
        top=(top+1)%capacity;
        ar[top]=entry;
    }
    public Entry pop(){ // Stack pop
        if(top<0) return null;
        Entry temp=ar[top];
        ar[top]=null;
        top=(top-1)%capacity;
        return temp;
    }
    public Entry pop(int first){ // Queue pop
        if(top<0) return null;
        Entry temp=ar[front];
        ar[front]=null;
        front=(front+1)%capacity;
        return temp;
    }
}
class PythonicList{
    public static void main(String[] args) {
        PytList lst= new PytList(12);
        lst.push("rupam");
        lst.push("ganguly");
        lst.push("instagram");
        lst.push("facebook");
        lst.push("Are all waste of time");
        lst.pop();
        lst.pop(0);
    }
}