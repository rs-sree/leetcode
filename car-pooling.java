class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pos = new int[1001];

     int max = 0;

     for(int[] a : trips) {

       pos[a[1]] = pos[a[1]] + a[0];

       pos[a[2]] = pos[a[2]] - a[0];

       max = Math.max(max, a[2]);

     }

     int curr = 0;

     for(int j = 0; j <= max; j++) {

       curr = curr + pos[j];

       if(curr > capacity) {

         return false;

       }

     }

     return true;
    }
}