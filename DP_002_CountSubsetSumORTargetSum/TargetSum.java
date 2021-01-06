class TargetSum{
    public static int countSubsetSum(int arr[], int s) {
        int n = arr.length;
        if(arr.length==0) return 0; // Another edge case is no item present in the array
        int[][] matrix = new int[n + 1][s + 1];
        matrix[0][0]=1;
        
        for (int i = 1; i <n+1; i++) {
            matrix[i][0] = 1;
            for (int j = 0; j <s+1; j++) {
                if (arr[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - arr[i - 1]] + matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[n][s];
    }
    public static int Targetsum(int[] ar, int TargetSum) {
        // Target Sum problem is same as count subsets with a given difference problem
        // Now count subsets with a given difference problem is solved by
        // just passing (difference+TotalSum)/2 as a sum of Count subset sum prolem.
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }
        int newSum = (TargetSum + sum) / 2;
        // now here two edgeCases can arrise
        // 1 is-> ar=[1] sum=2, means totalSum<targetSum so we have to return 0 in this case
        // 2 is-> if TotalSum+TargetSum is odd number then there is no subset present 
        if(sum<TargetSum || (sum+TargetSum)%2!=0) return 0;
        return countSubsetSum(ar, newSum);
    }

    public static void main(String[] args) {
        int[] ar = { 1,2,2,3};
        int Targetsum =0;
        int result = Targetsum(ar, Targetsum);
        System.out.println(result); // output is 2
    }
}
