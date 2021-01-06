
public class DoublyLinkedList {
Node head;// initialize head which is pointing the first node of our linked list
int size=0;// initially the list is empty so size is 0

// creating add method to adding item in our list
// item is Person type
// this method add item on the specified index
    public void insAt(int index, Person item){
    if(index<=size){
        Node node = new Node();
        node.data=item;
        // when user press wrong index, means when user press index greater than the present size then else block execute
        // and we print use the appropriate index.. let size is 2, and user give index as 4, then else block execute
        if(index==0){
            
            // when user want to add item at 0th index, mean first cell, then
            // now ther is two condition can present .
            //when head is emty, means list is empty, then
            if(head==null){
                head=node;// make the node HEAD
                size++;// increase the size variable
            }else{
                // another condition is, when haed is not empty then 
                head.prev=node;
                node.next=head;
                head=node;
                size++;
            }

        }else{
            //Now, when index not 0, means user doesnot give 0 as index,
            // then we need a Node type variable n
            Node n=head;// which contains HEAD, means the whole list.
            // we loop through from head to index-1, means from head to 'previous cell of the index'..
            for(int i=0;i<index-1;i++){
                n=n.next;// here we just make n as its own next node until index-1.
            }
            // now what if, size=1, means only head is present
            // then n.next is null
            //and if n.next is null then n.next.prev give us error
            // so we use if condition
            if(n.next!=null){
            node.next=n.next;
            n.next.prev=node;
        }
            node.prev=n;
            n.next=node;
            size++;
        }

    }else{
        System.err.println("use index "+size+" as index");
        // here size give us next empty cell, where user can add item..
    }
}
    public void del(int index){
    if(index<size){
        // if given index is greater then the current list size, then execute else block
        // now if given index is 0
        if(index==0){
            // now here two condition can present
            // 1 is when size=1, means only 1 element present in the list, then
            if(size==1){
                head=null;// we delete head node
                size--;// updating the size variable
            }else{
                // 2 condition is when list has more than 1 element, then
                head=head.next;
                head.prev=null;
                size--;

            }
        }else{
            // now when given index is not 0, then
            Node n=head;
            Node temp;// its a temporary Node type variable
            // which contains the indexed node..
            for(int i=0; i<index-1;i++){
                n=n.next;
            }// here n is starting from head and after looping
            // its now here Previous node of indexed Node
            // now we use our temp to point n.next Node which is basically indexed node
            temp=n.next;
            // now what if temp.next is empty, means we want to delete the last cell.
            if(temp.next==null){
                n.next=null;
                size--;
            }
            else{
                n.next=temp.next;
                temp.next.prev=n;
                size--;
            }
        }
    }
    else{
        System.out.println("Please Give Us Appropriate Index , currently the List is "+size+ " Long");
    }
}

    public void show(){
        // here we want to print the whole list, from head to last element
        // do again we need n..
        Node n=head;
        while(n.next!=null){
            // until the last element comming as n , its looping
            // but when last elemnent come its break the loop, wiyhout printing the last element

            // its do the job but i want more verbose,,,, ha ha ha


            if(n.prev!=null){System.out.println("Prev of "+n.data+" is: "+n.prev.data);}
            else{System.out.println("Prev of "+n.data+"is NULL");}

            System.out.println("DATA is: "+n.data);

            if(n.next!=null){System.out.println("Next of "+n.data+" is: "+n.next.data);}
            else{System.out.println("Next of "+n.data+"is NULL");}
            
            n=n.next;// here we just make n as its own next node
        }
        // for printing the last element...
        if(n.prev!=null){System.out.println("Prev of "+n.data+" is: "+n.prev.data);}
             else{System.out.println("Prev of "+n.data+"is NULL");}

            System.out.println("DATA is: "+n.data);

            if(n.next!=null){System.out.println("Next of "+n.data+" is: "+n.next.data);}
            else{System.out.println("Next of "+n.data+"is NULL");}
            System.out.println("-------------$$$$$$$$$$$$----------------");
    }

}