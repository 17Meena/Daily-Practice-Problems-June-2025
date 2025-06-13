class Solution {
    public boolean isValid(int[] nums, int mid, int p){
        int n = nums.length;

        int i = 0;
        int cnt = 0;

        while(i < n-1){
            if(nums[i+1] - nums[i] <= mid){
                cnt++;
                i += 2;
            }
            else{
                i++;
            }
        }

        return cnt >= p;
    }
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;

        Arrays.sort(nums);

        int l = 0;
        int r = nums[n-1]-nums[0];

        int result = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(isValid(nums,mid,p)){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return result;

    }
}
