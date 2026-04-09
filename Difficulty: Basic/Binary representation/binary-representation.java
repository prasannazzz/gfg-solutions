class Solution {
    static String getBinaryRep(int n) {
        String ans = "";
        for(int i=31; i>=0; i--){
            // If i'th bit is set 
            if((n& (1<< i)) != 0){
                ans+='1';
            }else{
               ans += '0'; 
            } 
        }
        
        return ans;
    }
}