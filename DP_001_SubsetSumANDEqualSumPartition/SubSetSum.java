public class SubSetSum {
    public static boolean solutionSubsetSum(int arr[], int targetSum, int n){
        // Here we does not need Validation array
        // we just want to show subset sum is possible or not so output will be Boolean type
        boolean matrix[][]=new boolean[n+1][targetSum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=targetSum;j++){
                //when array is empty then Sum is not possible
            // when Targetsum is 0 then, array elemnts does not matter, as Targetsum=0 is always- return True
                if(i==0) matrix[i][j]=false;
                else if(j==0) matrix[i][j]=true;

                //  choice Diagram:
                //                                       Item
                //                                     /     \
                //                                    /       \
                //                arr[item]<=targetSum       arr[item]>targetSum
                //                         /   \                   n-1 
                //                        /     \
                //                 INCLUDE       EXCLUDE
                //                     /            \
                //                    /              \
                //     targetSum-arr[item]           n-1
                //         n-1

                else if(arr[i-1]<=j){ //arr[item]<=targetSum
                    // here we does not need maxOf instrad of we need to performe OR operation as we use Boolean Matrix
                    matrix[i][j]=  matrix[i-1][j] ||   matrix[i-1][j-arr[i-1]];
                            // OR of      EXCLUDE             INCLUDE
                }
                else{ //arr[item]>targetSum
                    matrix[i][j]=matrix[i-1][j];
                }
                
            }
        }
        // System.out.println(matrix[n][targetSum]); 
        return matrix[n][targetSum];
    }
    public static boolean equalSumPartiotion(int[] ar,int n){
         // EQUAL SUM PARTITION:--
        // when sum of all items will be even then only Equal Sum possible otherwise just retuen False
        int sum=0;
        for( int i=0;i<ar.length;i++){
            sum+=ar[i];
        }
        if(sum%2==0){// Now if it is even then check for the subset:
            //we have to find just 1 subset which have sum = targetSum/2, 
            // Remaining items of the array will be the other subset.
            // sum of both the subset = Equal_targetSum
            boolean result= solutionSubsetSum(ar,sum/2,n);
            return result;
        }
        else return false;
        


    }
    public static void main(String[] args) {
        int[] ar={1, 2, 3, 7};
        int targetSum=9;
        int n=ar.length;
        System.out.println("SUBSET SUM OUTPUT-> "+solutionSubsetSum(ar,targetSum,n));
        System.out.println("EQUAL SUM PARTITION->"+ equalSumPartiotion(ar,n));
       
    }
}