// class Solution {
    
//     static int[][] t = new int[1001][1001];
//     static boolean[][] pal = new boolean[1001][1001];
//     static int palPartition(String s) {
//          int n=s.length();
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(t[i], -1);
//             Arrays.fill(pal[i], false);   // 🔹 IMPORTANT reset
//         }
//         // Precompute palindrome table
//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = i; j < n; j++) {

//                 if (s.charAt(i) == s.charAt(j)) {
//                     if (j - i <= 2) pal[i][j] = true;
//                     else pal[i][j] = pal[i + 1][j - 1];
//                 }
//             }
//         }
       
//         return solveMem2(s,0,n-1);
//     }
//     static int solveRec(String s, int i, int j){
//         if(i>=j) return 0;
//         if(isPalindrome(s,i,j)== true) return 0; //base case
//         int mn = Integer.MAX_VALUE;
//         for(int k=i; k<=j-1; k++){
//             int tempans= solveRec(s,i,k)+solveRec(s,k+1,j)+1;
//             if(tempans<mn) mn=tempans;
//         }
//         return mn;  
//     }
//     // O(n^3)
//     static int solveMem(String s, int i, int j){
//         if(i>=j) return 0;
//         if(isPalindrome(s,i,j)== true) return 0; //base case
//         if(t[i][j]!=-1) return t[i][j];
//         int mn = Integer.MAX_VALUE;
//         for(int k=i; k<=j-1; k++){
//             // int tempans= solveMem(s,i,k)+solveMem(s,k+1,j)+1;
//             int left = (t[i][k] != -1) ? t[i][k] : solveMem(s, i, k);
//             int right = (t[k + 1][j] != -1) ? t[k + 1][j] : solveMem(s, k + 1, j);
//             int tempans = left + right + 1;
//             if(tempans<mn) mn=tempans;
//         }
//         return t[i][j]= mn;  
//     }
//      static int solveMem2(String s, int i, int j){
//         if(i>=j||pal[i][j]) return 0;  // O(1) instead of O(n)
//         if(t[i][j]!=-1) return t[i][j];
//         int mn = Integer.MAX_VALUE;
//         for(int k=i; k<=j-1; k++){
//             // int tempans= solveMem(s,i,k)+solveMem(s,k+1,j)+1;
//             int left = (t[i][k] != -1) ? t[i][k] : solveMem2(s, i, k);
//             int right = (t[k + 1][j] != -1) ? t[k + 1][j] : solveMem2(s, k + 1, j);
//             int tempans = left + right + 1;
//             if(tempans<mn) mn=tempans;
//         }
//         return t[i][j]= mn;  
//     }
//      static boolean isPalindrome(String s, int i, int j){
//         char[]arr=s.toCharArray();
//         if(i>=j) return true;
//         while(i<j){
//             if(arr[i]!=arr[j]){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }


class Solution {

    static int[][] t = new int[1001][1001];
    static boolean[][] pal = new boolean[1001][1001];

    static int palPartition(String s) {

        int n = s.length();

        // reset memo only for needed size
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
            Arrays.fill(pal[i], false);   // 🔹 IMPORTANT reset
        }

        // Precompute palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) pal[i][j] = true;
                    else pal[i][j] = pal[i + 1][j - 1];
                }
            }
        }

        return solveMem2(s, 0, n - 1);
    }

    static int solveMem2(String s, int i, int j) {

    if (i >= j || pal[i][j]) return 0;

    if (t[i][j] != -1) return t[i][j];

    int mn = Integer.MAX_VALUE;

    // Only try valid palindrome cuts
    for (int k = i; k < j; k++) {

        if (!pal[i][k]) continue;   // ← KEY OPTIMIZATION

        int right = (t[k + 1][j] != -1) ? t[k + 1][j] : solveMem2(s, k + 1, j);

        mn = Math.min(mn, 1 + right);
    }

    return t[i][j] = mn;
}

}
