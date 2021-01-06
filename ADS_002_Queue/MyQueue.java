class MyQueue{
    // queue is a datastructue which basically is an array which has single rule to follw
    // Delete OLDEST element present in the array
    // Now we want to store items of Person Data type
    Person[] q;// Declare the array q of Person datatype
    int capacity;// total holding capacity of the q array
    int size;// Size variable keep track of the current size of the array q, its updated its value when insertion and deletion happens
    int f;// Front variable point to the OLDEST element present in the q
    int r;// REAR variable point to the YOUNGEST element present in the q

    public MyQueue(int capacity){
        this.capacity=capacity;
        size=0;// initially q is empty so size is 0
        q=new Person[capacity];// creating q of Person datatype with specified capacity
        f=-1;// Initially front is pointing to invalid index -1 of the q
        r=-1;// Initially rear is pointing to invalid index -1 of the q
    }
    public void enQ(Person item){
        // this method is for inserting items
        // rear will  point to the YOUNGEST element present in the q
        // so we use rear variable for insertion purpose
       if(size!=capacity){// if q is not full then
           r++;// makes rear to point always the index where we want to insert item
        q[r]=item;// now item is inserted to the q[r] position
        //NOW freont is still pointing to -1
        // but Front variable point to the OLDEST element present in the q
        // Oldeses is always can present on 0th index;
        if(f==-1){
            f=0;// now its pointing to o th index
        }
        size++;
    } 

    }
    public void deQ(){
        // this method is use for deleting the oldest ...
        // now the oldest is pointed by front
        // so we use front for deletion purpose..
        // HERE WE JUST REPLACE THE 
        if(size!=0){// if q is not empty then
            for(int i=0; i<r;i++){
            q[i]=q[i+1];// q[i+1] is copied to q[i]
        }
        r--;// make the reare pointing to its previous , so next time last item can be replaced with New item when enQ happen
        size--;}
        
    }
}