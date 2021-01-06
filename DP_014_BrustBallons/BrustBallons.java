class Solution {
    public static int maxOf(int a, int b){
        if(a>b) return a;
        else return b;
    }
    public static int mcm(int[][] matrix, int[] nums, int i,int j){
        if(i>j) return 0;
        if(matrix[i][j]>0) return matrix[i][j];
        int ans=0;
        for(int k=i+1;k<j;k++){
            int temp=mcm(matrix,nums,i,k)+mcm(matrix,nums,k,j)+(nums[i]*nums[k]*nums[j]);
            ans=maxOf(ans, temp);
        }
        matrix[i][j]=ans;
        return ans;
    }
    public static int maxCoins(int[] nums) {
        int [] newNUMS= new int[nums.length+2];
        int n=1;
        for(int i: nums){
            if(i>0) 
                newNUMS[n++]=i;
        }
        newNUMS[0]=newNUMS[n++]=1;
        int[][] matrix=new int[n][n];
        return mcm(matrix,newNUMS,0,n-1);
    }
    public static void main(String[] args) {
        int[] nums={5,4,3,6};
        System.out.println( maxCoins(nums));
    }
    
}