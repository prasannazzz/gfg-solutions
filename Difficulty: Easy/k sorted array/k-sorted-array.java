import java.util.*;
class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(sorted[i], i);
        }
        for (int i = 0; i < n; i++) {
            int sortedIndex = pos.get(arr[i]);
            if (Math.abs(i - sortedIndex) > k) {
                return "No";
            }
        }
        return "Yes";
    }
}