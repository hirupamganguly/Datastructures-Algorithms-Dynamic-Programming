class MatrixChainMultiplication{
    // public static int minOf(int a, int b){
    //     if(a>b) return b;
    //     else return a;
    // }
    public static int mcm(int[] nums, Integer[][] matrix, int i ,int j){
        if(i>=j) return 0;
        if(matrix[i][j]!=null) return matrix[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp= mcm(nums, matrix, i, k) + mcm(nums, matrix, k+1, j)+ nums[i-1]*nums[k]*nums[j];
            if(temp<ans) ans=temp;
            matrix[i][j]=ans;
        }
        return ans;
    }
    private static int mcmSolver(int[] nums) {
        // int[][] matrix= new int[nums.length+1][nums.length+1];
        // for(int i=0;i<nums.length+1;i++){
        //     for(int j=0; j<nums.length+1;j++){
        //         matrix[i][j]=-1;
        //     }
        // }
        //If i create Integer typed Matrix then i did not have to use -1 initializtion steps.... which takes O(n^2) time.
        Integer[][] matrix= new Integer[nums.length][nums.length];
        // it already initialized with NULL instead of 0.

        return mcm(nums, matrix,1,nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(mcmSolver(nums));
    } 
}