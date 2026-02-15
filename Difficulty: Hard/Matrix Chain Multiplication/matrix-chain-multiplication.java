class Solution {
     static int[][] t = new int[101][101];
    static int matrixMultiplication(int arr[]) {
        // Initialize memo table with -1 ONLY once
        for (int i = 0; i < 101; i++) {
            Arrays.fill(t[i], -1);
        }
       return solveMem(arr,1,arr.length-1);
    }
    static int solveRec(int[] arr, int i, int j){
        // 1110 /1111
        // Time limit exceeded
        if(i>=j) return 0;
        int mn = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempans= solveRec(arr,i,k)+solveRec(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(tempans<mn) mn=tempans;
        }
        return mn;  
    }
    static int solveMem(int[] arr, int i, int j){
        // 1110 /1111
        // Time limit exceeded
        if(i>=j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int mn = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempans= solveMem(arr,i,k)+solveMem(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(tempans<mn) mn=tempans;
        }
        return t[i][j]= mn;  
    }
}