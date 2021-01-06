class MinSSDifference{
    public static boolean[][] subsetSum(int[] ar, int sum){
        //this subset sum is modification of subset sum problem
        // it just return the whole matrix instead of last cell
        int n = ar.length;
        boolean matrix[][] = new boolean[n+1][sum+1];
        matrix[0][0]=true;
        for(int i=1;i<=n;i++){
            matrix[i][0]=true;
            for(int j=1;j<=sum;j++){
                if(ar[i-1]<=j){
                    matrix[i][j]=matrix[i-1][j] ||matrix[i-1][j-ar[i-1]];
                }
                else matrix[i][j]=matrix[i-1][j];
            }
        }
        return matrix;// this is the only Modification
    }
    public static int minSSDiff(int arr[], int S) {
        if(arr.length==0) return 0; // Another edge case is no item present in the array
        boolean[][] matrix;//=new boolean[arr.length+1][S+1];
        int sum = 0;
        for(int i=0;i<arr.length;i++) sum+=arr[i];
        // now here two edgeCases can arrise
        // 1 is-> ar=[1] sum=2, means totalSum<targetSum so we have to return 0 in this case
        // 2 is-> if TotalSum+TargetSum is odd number then there is no subset present 
        if(sum<S || (sum+S)%2!=0) return 0;
        matrix = subsetSum(arr, S);
        int diff = Integer.MAX_VALUE;
        //
        for (int x = sum / 2; x >= 0; x--) {
            if(matrix[arr.length][x]){
                diff = sum - 2 * x;
                break;// the closest True value of the range from sum/2 to 0 is giving us the
                // min diifference.
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7 };
        int sum = 10;
        
        int result=minSSDiff(arr, sum);
        System.out.println(result);
    }
}