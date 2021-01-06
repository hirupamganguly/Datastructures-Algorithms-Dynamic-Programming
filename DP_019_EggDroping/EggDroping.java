class EggDroping{
    public static int solver(int[][] matrix,int K, int N){
          if(N<=1||K==1)  return N;
          if(matrix[K][N]!=0) return matrix[K][N];
          matrix[K][N] = solver(matrix,K-1, N-1)+solver(matrix,K, N-1)+1;
          return matrix[K][N];
      }
      public int superEggDrop(int K, int N) {
          int[][] matrix= new int[K+1][N+1];
          int steps=0;
          while(solver(matrix,K, steps)<N) steps++;
          return steps;
      }
}