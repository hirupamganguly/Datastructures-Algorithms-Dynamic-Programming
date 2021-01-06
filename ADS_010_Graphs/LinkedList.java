public class LinkedList {
    public Node head;
    public void add(Person item){
        // Always add Vertex at 1 index
        Node node=new Node();
        node.data=item;
        if(head==null){
            head=node;
        }else{
            if(head.next!=null){
                node.next=head.next;
            }
            head.next=node;
        }
    }
    
}