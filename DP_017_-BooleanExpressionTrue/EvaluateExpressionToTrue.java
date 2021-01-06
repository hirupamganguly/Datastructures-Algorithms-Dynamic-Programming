import java.util.Scanner;

class EvaluateExpressionToTrue{
    // Bottom up Memorized Recursive Solution:-
    public static int evalBoolExToTrue(char[] s,int[][][] matrix3D, int i, int j, boolean isTrue){
        //Base CASE-
        if(i>j) return 0; 
        if(i==j){ // for single letter String
            if(isTrue==true)
                return s[i]=='T'? 1 : 0; // if s[i] == T then return 1 else return 0.
            else return s[i]=='F'? 1: 0; // if s[i] == F then return 1 else return 0.
        }
        // checking matrix
       if( matrix3D[i][j][isTrue==true? 1:0]>0) return matrix3D[i][j][isTrue==true? 1:0] ;
       // if the value of cell is greater than 0 then return the value present on the cell, Else do recursion
        //Recursion-
        int ans=0;
    //      T & F ^ T | T
    //        k ->k-> k ---  So k start from i+1 and goes up to j-1. k always point to the operator.


        for(int k=i+1; k<= j-1; k=k+2){
            int lt=evalBoolExToTrue(s, matrix3D, i, k-1, true);
            int rt=evalBoolExToTrue(s, matrix3D, k+1,j, true);
            int lf=evalBoolExToTrue(s, matrix3D, i, k-1, false);
            int rf=evalBoolExToTrue(s, matrix3D, k+1,j, false);
             // calculating-
        if(s[k]=='^'){
            if(isTrue){
                ans+=(lt*rf+lf*rt);// when XOR return TRUE value
            }
            else ans+=(lt*rt+lf*rf);// when XOR return FALSE value
        }
        else if(s[k]=='|'){
            if(isTrue){
                ans+=(lf*rt+lt*rf+lt*rt);// when OR return TRUE value
            }else ans+=(lf*rf);// when OR return FALSE value
        }
        else{
            if(isTrue){
                ans+=(lt*rt);// when AND return TRUE value
            }else ans+=(lf*rf+lf*rt+lt*rf);// when AND return FALSE value
        }
        }
       matrix3D[i][j][isTrue==true? 1:0]=ans; // Storing the result on matrix
    //    if(matrix3D[0][s.length-1][isTrue==true? 1:0]>0) PrintTheMatrix(matrix3D); // If we want to print the matrix
       return matrix3D[i][j][isTrue==true? 1:0]; 

//              T|T&F^T--->
    //    0  0  0  0  0  1  0  0  1  1  0  0  0  4
    //    0  0  0  0  0  0  0  0  0  0  0  0  0  0
    //    0  0  0  0  0  0  0  0  1  0  0  0  0  2
    //    0  0  0  0  0  0  0  0  0  0  0  0  0  0
    //    0  0  0  0  0  0  0  0  0  0  0  0  0  1
    //    0  0  0  0  0  0  0  0  0  0  0  0  0  0
    //    0  0  0  0  0  0  0  0  0  0  0  0  0  0

    //          T^F&T--->
    // 0  0  0  0  0  1  0  0  0  2
    // 0  0  0  0  0  0  0  0  0  0
    // 0  0  0  0  0  0  0  0  1  0
    // 0  0  0  0  0  0  0  0  0  0
    // 0  0  0  0  0  0  0  0  0  0
    }
    // public static void PrintTheMatrix(int[][][] matrix3D){
    //     System.out.println("-----------------------");
    //     for (int[][] array2D: matrix3D) {
    //         for (int[] array1D: array2D) {
    //             for(int item: array1D) {
    //                 System.out.print("  "+item);
    //             }
    //         }
    //         System.out.println("");
    //     }
    //     System.out.println("-----------------------");
    // }
    public static int evaluateExpressionToTrueSolver(char[] s, int i, int j, boolean isTrue){
        int[][][] matrix3D=new int[s.length][s.length][2];// Initialized the DP Matrix
        return evalBoolExToTrue(s,matrix3D,0,s.length-1,true);// return the answer
    }
    public static void main(String[] args) {
        String s= "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T";  //"T|T&F^T";
        char[] c= s.toCharArray(); // covert strting to Char Array.
        System.out.println(evaluateExpressionToTrueSolver(c,0,c.length-1,true)); // callinf the Solver 
    }
}