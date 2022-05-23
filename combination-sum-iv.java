class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp [] = new int [target + 1];
        dp [0] = 1;
        for (int tar = 1; tar < target + 1; tar++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums [i] <= tar)
                    dp [tar] += dp [tar - nums [i]];
            }
        }
        return dp [target];
    }
}