
public class HashTable {
    Node[] ar;
    int capacity;
    public HashTable(int capacity){
        this.capacity=capacity;
        ar=new Node[capacity];

    }HashFunction hf=new HashFunction();
    public void put(Person item){
        Node node= new Node();
        node.data=item;
        int index= hf.getHashedValue(item.name);
        if(ar[index]==null){
            ar[index]=node;
        }
        else{
            node.next=ar[index].next;
            ar[index].next=node;
        }
    }
    public Node get(Person item){
        int index= hf.getHashedValue(item.name);
        Node n=ar[index];
        Node temp=null;
        while(n!=null){
            if(n.data==item){
                temp=n;
                break; 
            }
            n=n.next;
        }
        if(temp!=null){
            System.out.println(temp.data+"GET");

        }else{
            System.out.println("not found");
        }
        return temp;
    }
    public Node remove(Person item) {
        int index=hf.getHashedValue(item.name);
        if(ar[index]==null){
            System.out.println("Not Present");

            return null;
        }
        Node n=ar[index];
        
        if(n.data==item && n.next==null){
            ar[index]=null;
            System.out.println(n.data +" DELETED");

            return null;
        }
        else if(n.data==item && n.next!=null){
            ar[index]=n.next;
        }
        else {
            Node temp=n;
        Node parent=n;
        while(n.data!=item){
            parent=n;
            n=n.next;
        }
        parent.next=n.next;    
    }
        System.out.println(n.data+"--deleted");
        return null;   
    }
    public void show(){
        for(int i=0;i<ar.length;i++){
            if(ar[i]!=null){
                System.out.print("At Index   "+i+"   values are ");
                Node n=ar[i];
                while(n!=null){
                    System.out.print(n.data+ " --->");
                    n=n.next;
                }
                System.out.println("");
            }
            
        }
    }
}