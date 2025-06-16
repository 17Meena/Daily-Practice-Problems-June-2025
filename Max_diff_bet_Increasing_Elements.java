class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDiff = -1;

        for(int i=1; i<nums.length; i++){
            maxDiff = Math.max(nums[i] - min, maxDiff);
            min = Math.min(min, nums[i]);
        }

        if(maxDiff <= 0) return -1;
        return maxDiff;
    }
}