class Solution {

    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        int start = max(arr);   // FIX 1
        int end = sum(arr);
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, n, k, mid)) {   // FIX 3
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];   // FIX 2
        }
        return s;
    }

    int max(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
        }
        return m;
    }

    boolean isValid(int[] arr, int n, int k, int max) {
        int student = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > max) {
                student++;
                sum = arr[i];

                if (student > k) {
                    return false;
                }
            }
        }
        return true;
    }
}