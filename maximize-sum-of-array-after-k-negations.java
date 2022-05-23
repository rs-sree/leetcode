class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        int sum = 0;
        int length = arr.length;
        while (k > 0) {
            Arrays.sort(arr);
            arr[0] = -arr[0];
            k--;
        }
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }
}