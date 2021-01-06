class BinaryHeap{
    int d=2;// udes in kthchild function
    int heapSize;// track the curent size of the heap
    int[] heap;// int type array
    public BinaryHeap(int capacity){
        heapSize=0;// initially heap is empty so heapSize is 0
        heap=new int[capacity+1];//creating the array with capacity
        for(int i=0;i<capacity+1;i++){
            heap[i]=-1;// intialized all elements to -1 of array
        }
    }
    int parent(int i){
        return (i-1)/2;// return the parent of specified index
    }
    int kthChild(int i,int k){
        return i*d+k;// return the child of specified index, if k=1 return leftchild,
        // k=2 return rightchild
    }
    String ins(int item){
        if(heapSize==heap.length) return "FULL [--NOT_INSERTED--]";// if heap array is full
        heap[heapSize++]=item;// assign the item to array wirh the help of heapSize
        //in post increment at first item is assign then incremented
        int newNode=heapSize-1;//creating a new variable newnode which contains index of curently inserted element
        int temp=heap[newNode];//temp variable contains the element which is curently inserted
        while(newNode>0 && temp<heap[parent(newNode)]){ 
            //untill newly added item is greater than parent of newnode variable loop:-
            heap[newNode]=heap[parent(newNode)];// parent of newnode index is assigned to at array of index newnode
            newNode=parent(newNode);// newnode index is assigned to parent of newnode index
            // basically swapping paren to its child untill 
            //temp which is newly added item get its correct position -// parent is leeser than child
        }
        heap[newNode]=temp;// at correct position insert newly added item.
        return "DONE";
    }
    int minChild(int ind){
        int leftChild=kthChild(ind, 1);// left child index of ind
        int k=2;
        int rightChild=kthChild(ind, k);// rightchild index of ind
        //----------------------------------------------------------------------
        // while(k<=2 && rightChild< heapSize){
        //     if(heap[rightChild]<heap[leftChild]) leftChild=rightChild;
        //     rightChild=kthChild(ind, k++);
        // }
        //----------------------------------------------------------------------
        if(rightChild<heapSize){
            // if rightchild index is not greater than heapsize
            if(heap[leftChild]>heap[rightChild]) leftChild=rightChild;// compare left and right child items 
            // which is lesser just return the index of that child
        }    
        return leftChild;
    }
    String del(int index){
        if(heapSize==0) return "EMPTY";// if heap is empty
        heap[index]=heap[heapSize-1];// at specified index just put the last element of heap
        heap[heapSize-1]=-1;// make the last element to -1
        heapSize--;// decrement the size
        int child;
        int temp1=heap[index];// create temp1 variable which contain the puted item
        while(kthChild(index, 1)< heapSize){
            //untill left child of index is greater than heapsize loop-
            child=minChild(index);//index of min child- of index
            if (heap[child]< temp1) heap[index]=heap[child];// if the min child element is lesser than temp1 which contain the puted item
            //at index assign the min child element
            else break;
            index=child;// update index to minchild index. continue the loop
        }
        heap[index]=temp1;// at last when we found correct position for temp1, just insert temp1 to that index
        if(kthChild(index, 1)>heapSize){ 
        int temp2=heap[index];
        while(index>0 && heap[index]<heap[parent(index)]){
            // for extra protection :) i know it is not require though.
            // it almost never runs actually :) it just up_heapify process which is used on ins function
            heap[index]=heap[parent(index)];
            index=parent(index);
        }
        heap[index]=temp2;
        }
        return "Deleted";
    }
    void show(){
        System.out.println("MinHeap:---");
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i]+" ----> ");
        }
        System.out.println("");
    }
}