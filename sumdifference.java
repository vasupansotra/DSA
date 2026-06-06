class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int[] ans = new int[nums.length];

        for(int j = 1; j < nums.length; j++) {
            rightSum += nums[j];
        }

        for(int i=0; i<nums.length; i++){
            if(i > 0 && i < nums.length - 1){
                leftSum = leftSum + nums[i-1];
                ans[i] = Math.abs(leftSum - rightSum);
                rightSum = rightSum - nums[i+1]; // Prepare rightSum for the next index
            }
            else if(i < nums.length-1){
                ans[i] = Math.abs(leftSum - rightSum);
                rightSum = rightSum - nums[i+1]; // Prepare rightSum for the next index
            }
            else{
                if(i > 0) leftSum = leftSum + nums[i-1];
                // For the last index, rightSum is always 0
                rightSum = 0; 
                ans[i] = Math.abs(leftSum - rightSum);
            }
        } 
        return ans;
    }
}