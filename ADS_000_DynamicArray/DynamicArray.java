class DynamicArray{
    /**Dynamic array is - An array which can grow at runtime when array is full, shrink at runtime when aray is half full.
     * It bassicall contains extend() method which decides when to GROW
     * and, reduce() methos which decides when to SHRINK.
     * these two method makes a normal array to dynamic array
     *  */ 

     int [] ar; // the array
     int size;// size of the array
     int top;// it pointed to the next empty cell of the array
     
    public DynamicArray(){
        // CONSTRUCTOR
        ar=new int [1];// Initially the ar has size 1, It update its size at runtime when items are inserted
        size=1;// initially size is 1
        top=0; // top initially pointing the 0th index, as ar is empty initially.
    }
    public void extend(){
        int temp[]=null;// creating Temporary array
        if(top==size){
            // when  array is full, In other Words- top and size both have same value, then-
            temp=new int[size*2];// create temmp array with Double size the previous size was
            // just copy all elements from ar array to temp array
            for(int i=0;i<size;i++){
                temp[i]=ar[i];// all elements of ar array are copied to temp array.
            }
            // then make temp as ar
            ar=temp;// the real temp will garbage collected
            size=size*2;// update the size.. double the size

        }
    }
    public void add(int item){
        extend();// calling extend method to decide when to double the size of the ar array.
        ar[top]=item;// in the ar array item will added at where top pointing.
        top++;// then after adding top will pointing to the next cell, which is empty at this time.
    }
    public void addAt(int index, int item){
        //adding at specified index
        extend();// calling extend method to decide when to double the size.
        if(size==1){
            ar[top]=item;
            top++;
        }
        else
        {for(int i=top-1;i>=index;i--){
            // Shift elements 
            ar[i+1]=ar[i];// ar[i] will placed at ar[i+1]
        }
        ar[index]=item;
        top++;
    }
    }

    public void reduce(){
        int temp[];
        if(top==size/2){
            // when the array is half fill, then
            temp=new int [size/2];
            for(int i=0;i<top;i++){
                temp[i]=ar[i];//all elements of ar array are copied to temp array.
            }
             // then make temp as ar
            ar=temp;// the real temp will garbage collected
            size=size/2;// update the size.. half the size
        }
    }
    public void remove(){
        // remove the element which is pointed bt top
        if(top>0){
            reduce();// calling reduce method to decide when shrink the array..
            // array is not empty, then
            ar[top-1]=0;// make the last element 0
            top--;// reduce the top pointer, which now will point the deleteted index
        }
        else{
            System.out.println("    Empty ");
        }
    }
    public void removeAt(int index){
        if(top>0){
            // remove the element which is specified by index
        reduce();// calling reduce method to decide when shrink the array..
        for(int i=index;i<top-1;i++){
            // Shift elements 
            ar[i]=ar[i+1];// ar[i+1] will places at ar[i]
        }
        ar[top-1]=0;
        top--;
        }
        else{
            System.out.println("    EMPTY");
        }
        
    }
   void show(){
        if(top>0){
            for(int i=0;i<top;i++){
                System.out.print(ar[i]+"  ");
            }
            System.out.println("");
        }
        else{
            System.out.println("Nothing to show");
        }
       
    }
}
