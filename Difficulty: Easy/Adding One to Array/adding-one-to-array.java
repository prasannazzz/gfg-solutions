// User function Template for Java

class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            if(arr[i] == 9){
                arr[i] = 0;
            }
            else{
                arr[i]++;
                break;
            }
        }
        Vector<Integer> ans = new Vector<>();
        if(arr[0] == 0){
            ans.add(1);
        }
        for(int num : arr){
            ans.add(num);
        }
        return ans;
    }
}