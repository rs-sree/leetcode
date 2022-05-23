class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums) {
            String num = Integer.toString(n);
            if(num.length() % 2==0) {
                count++;
            }
        }
        return count;
    }
}