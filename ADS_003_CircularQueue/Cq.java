class Cq{
    // Circular queue is same as queue with Single modification
    // Last item will point to the First item
    // we want to store items of Person data type
    Person [] cq; //Declare cq array of person data type
    int capacity;// Total holding capacity of the array cq
    int size;// Size variable shows the current size of the array .. Size variable updated each time when we perform insertion and deletion
    int f;// Front is pointing to the OLDEST element present in the cq
    int r;// Rear is pointing to the YOUNGEST element present in the cq
    public Cq(int capacity){
        this.capacity=capacity;
        cq = new Person[capacity];// cq is created with specified capacity of Person data type
        size=0;// Initially cq is empty so size is 0
        f=-1; // Initially Front is pointing to INVALID index-1 of the cq
        r=-1;// Initially Rear is pointing to INVALID index-1 of the cq

    }
    public void enQ(Person item){

        if(size==capacity){
            // when cq is full then no more insertion
            System.out.println("FULL");
        }
        else{
            if(r==f-1 && size==0){
                f=-1;
                r=-1;
            }
            // this enQ method is perfrome Insertion
            // As Rare is pointing Youngest So we use Rare for Insertion
            // As initially rare pointing to Invalid index so first
            
            r=(r+1)%capacity;   // this r++ is performed every time when enQ is called
            // so When item is inserted r++ do the job is, pointing r to next empty cell for item insertion
            cq[r]=item;// here we just insert item at cq[r] position...
            size++; //Size variable updated each time when we perform insertion and deletion
            // NOW THE TWIST IS Front variable still it pointing to INVALID index
            // So when cq is not empty then Front must pointing to OLDEST/
            /// Now when first insertion done on empty cq FRONT AND RARE both Pointing to the Same Item
            // AS when singel item present it is the YOUNGEST as well AS OLDEST
            if(f==-1){
                f++;// this do the job,, when enQ called it checked if f==-1, means if f is still pointing to -1
                // then f++ , now f will point 0 th index of the cq..
            }
        }
        
    }
    public void deQ(){
        if(size==0){
            // when cq is empty then deletion is  not possible
            System.out.println("EMPTY");
        }else{
            // this deQ method performe deleting of oldest item present
        // Now Front is pointing to the OLDEST element present in the cq
        // So we use front to delete 
        // What we do is just make q[front] to null;
        cq[f]=null;
        f=(f+1)%capacity;   // it then point to the next OLDEST item
        // THATS HOW THINGS WORK of THE Q
        // NOW AS IT IS CIRCULAR so WHEN CQ array is emty againg by deleting one by ine item 
       //  FRONT AND RARE both point to the -1 index again
         size--;//Size variable updated each time when we perform insertion and deletion
        }
        
    }
}
// NOW EACH TIME WHEN F AND R REACH TO CAPACITY WE WANT TO MAKE IT AGAIN O
// THE CODE FOR DOING THIS
// F=(F+1)%CAPACITY; R=(R+1)%CAPACITY;
// so when it reach capacity its automatically goes to 0 again