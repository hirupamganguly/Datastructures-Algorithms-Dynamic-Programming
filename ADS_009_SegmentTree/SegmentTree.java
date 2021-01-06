class SegmentTree{
    static int[] segmentTreeArray;
    /**
     * Segement tree is Full Binary tree, The array element present on the Leaf nodes
     * It just segement the problem or devide the problem into smaller part- then Recursively/Iteratively solve the problem. As it is recursive Problem So we need Base Cases to get then Answer or in other words to terminate the Recursion.
     * 
     *             {1   2   5   6   7   9}
     *                      / 30  \
     *                  8 /        \ 22
     *                   /          \
     *         {1   2   5}         {6   7   9}
     *           3 /     \ 5         13 /   \ 9
     *            /       \            /     \
     *         {1   2}   {5}       {6   7}  {9}
     *         1 / \ 2             6 / \ 7
     *          /   \               /   \
     *         {1} {2}             {6} {7}
     */
    public static int constructSegmentTree(int[] ar, int SIndex, int left, int right) {
        if(left==right){ // when there is single element(length of the segment is 1) 
            //then return the element as output and store it on segement tree (Segemnt tree represented by the array) 
            //the Index will be left or right child index passed by the function call itself.
            //as left is equal to right so we can take either of them
            return segmentTreeArray[SIndex]=ar[left];
        }
        // if more to devide(not singel element) then just devide the array to half, then recur
        // here the index of the segement tree array is updated by child index on each recusion call. 
        int mid=(left + (right - left) / 2);
        segmentTreeArray[SIndex]=constructSegmentTree(ar, 2*SIndex+1, left, mid)+constructSegmentTree(ar,2*SIndex+2,mid+1, right);
        return segmentTreeArray[SIndex];
    }
    /**     Segment Tree with Array Index: ------------------
     * 
     *                          30          0   INDEX
     *                     /           \    
     *                    / 1           \  2  INDEX
     *                  8               22
     *                 / \             /  \
     *                / 3 \ 4       5 /    \ 6  INDEX
     *               3     5*        13     9*
     *              / \             / \
     *           7 /   \ 8      11 /   \  12  INDEX
     *            1*    2*        6*    7*
     */
    public static int runQuery(int[] ar, int index1, int index2){
        int ql=index1;
        int qr=index2;
        int left=0;
        int right= ar.length-1;
        return queryRun(ar, 0, left, right, ql, qr);
    }
    /**
     *4 CSESE of Complete Overlap:-
     * 
     *     ql[**********************]qr                                  ql[**********************]qr
     *   left[*******************************]right           left[*******************************]right
     * 
     *            ql[*******************]qr                     ql[*******************************]qr
     *   left[*******************************]right           left[*******************************]right
     */
    /**
    * 2 CSESE of NO Overlap:-

     *                                      ql[**********]qr                                    
     *    left[************************]right
     * 
     * 
     *   ql[**********]qr 
     *                  left[************************]right
     */
    /*
    * 2 CSESE of Partial Overlap:-

     *        ql[**************]qr                                                   ql[**************]qr  
     *               left[************************]right        left[************************]right
     */

    public static int queryRun(int[] ar, int SIndex, int left, int right, int ql, int qr){
        /**
         *                    0  1   2  3  4   5  6  7  8  9 10  11  12  13 ...
         * segmentTreeArray={30, 8, 22, 3, 5, 13, 9, 1, 2, 0, 0,  6,  7,  0, 0, 0}
         * --------------------------------------------------------------------------
         *                             ql<=left    qr>=right    Decision
         * ---------------------------------------------------------------------------
         * for->> left=0 right=1 -->   2<=0         4>=1        No Overlap
         * for->> left=2 right=2 -->   2<=2         4>=2        Complete Overlap
         * for->> left=3 right=5 -->   2<=3         4>=5        Partial Overlap
         * for->> left=3 right=4 -->   2<=3         4>=4        Complete Overlap
         * ---------------------------------------------------------------------------
         */
        if(ql<=left && qr>=right) return segmentTreeArray[SIndex]; // Complete Overlap
        if(right<ql || left >qr) return 0; // No Overlap
        // Partial Overlap
        int mid=(left + (right - left) / 2);
        return queryRun(ar, 2*SIndex+1, left, mid, ql,qr) + queryRun(ar, 2*SIndex+2, mid+1, right, ql,qr);
    }
    public static void update(int[] ar, int SIndex, int left, int right, int index, int value) {

        if(index<left || index > right) return; // No overlap
        if(ar[index]>value){
            segmentTreeArray[SIndex]-=Math.abs(ar[index]-value); // just substract the difference 
        }
        else{
            segmentTreeArray[SIndex]+=Math.abs(ar[index]-value); // just add the difference 
        }
        if(left!=right){
            int mid=(left + (right - left) / 2);
                update(ar, 2*SIndex+1, left, mid, index, value);
                update(ar, 2*SIndex+2, mid+1, right, index, value);
        }    
        ar[index]=value; 
    }
    public static void main(String[] args) {
        int[] ar={7,2,7,2,0};
        if(ar.length==0) return; // EDGE CASE
        int left= 0;
        int right=ar.length-1;
        int sizeOfSegementArray= 4*right+2;
        segmentTreeArray=new int[sizeOfSegementArray];
        constructSegmentTree(ar,0,left,right);
        update(ar, 0, left, right, 4, 6);
        update(ar, 0, left, right, 0, 2);
        update(ar, 0, left, right, 0, 9);
        System.out.println(runQuery(ar, 4, 4));
        update(ar, 0, left, right, 3, 8);
        System.out.println(runQuery(ar, 0, 4));
        update(ar, 0, left, right, 4, 1);
        System.out.println(runQuery(ar, 0, 3));
        System.out.println(runQuery(ar, 0, 4));
        update(ar, 0, left, right, 0, 4);
        for(int i=0;i<segmentTreeArray.length;i++){
            System.out.print(segmentTreeArray[i]+" ");
        }   
    }
}