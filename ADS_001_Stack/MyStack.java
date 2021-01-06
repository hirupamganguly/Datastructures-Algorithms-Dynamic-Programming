public class MyStack {
    Person arr[];
    int top;
    int capacity;
    public MyStack(int capacity){
        this.capacity=capacity;
        arr = new Person[capacity];
        top=-1;
    }
    public void push(Person item){
        if(top==capacity-1){
            return;
        }
        top++;
        arr[top]=item;
    }
    public void pop(){
        if(top==-1){
            return;
        }
        arr[top]=null;
        top--;
    }
    public void show(){
        for(int i=0; i<=top; i++){
            System.out.println(arr[i]);
            
        }
        System.out.println("--------------------############");
    }
}
