class Solution {
    public int[] largestSubarray(int[] nums, int k) {
       int maxIndex = 0;
       for(int i = 0; i <= nums.length-k; i++)
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        
        return Arrays.copyOfRange(nums, maxIndex, maxIndex+k);
        
    }
}