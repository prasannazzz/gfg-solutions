class Solution {
    boolean isPalindrome(String s) {
        // code here
        int i=0;
        int n=s.length();
        while(i<=n/2){
            if(s.charAt(i)==s.charAt(n-i-1)){
                i++;
                continue;
            }else{
                return false;
            }
        }
        return true;
        
    }
}