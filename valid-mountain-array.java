class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 0;
        while (i <= arr.length - 2 && arr[i + 1] > arr[i]) i++;
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        while (i <= arr.length - 2 && arr[i + 1] < arr[i]) i++;
        
        return i == arr.length - 1;
    }
}