public class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int maxSoFar=nums[0];
        int start=0,end=0;
        for(int i=1;i<nums.length;i++){
            if(maxSoFar<0) {maxSoFar=nums[i]; start=i;}
            else{ maxSoFar+=nums[i]; }
            if(maxSoFar>max) {max=maxSoFar; end=i;}
        }
       // System.out.println(start+" "+end);
        return max;
    }
}