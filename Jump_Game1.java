/*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
*/



class Solution {
    public boolean canJump(int[] nums) {

      // Some test case fail with 2D memoizaation can be done with 1D
    //   if(nums.length==1){
    //     return true;
    //   }
    //   int n = nums.length;
    //     boolean[][]dp = new boolean[n][n];
    //      return memo(dp,nums,0,n-1);
    // }
    // public boolean memo(boolean[][]dp,int[]nums,int start, int last){
    //       if(start>last){
    //         return true;
    //       }
    //       if(nums[start]==0){
    //         return false;
    //       }
    //       if(dp[start][last]){
    //          return dp[start][last];
    //       }
    //       if(start+nums[start]>=last){
    //         dp[start][last]= true;
    //       }else{
    //         boolean option1 = memo(dp,nums,start+1,last);
    //         dp[start][last]= option1;
    //       }
    //       return dp[start][last];

       int n = nums.length;
       Boolean[]dp = new Boolean[n];
       return memo(dp,nums,0);
     
    }
    public boolean memo(Boolean[]dp, int[]nums,int start){
         if(start>=nums.length-1){
          return true;
         }
         if(nums[start]==0){
          return false;
         }
         if(dp[start]!=null){
            return dp[start];
         }
         int maxjump=nums[start];
          for(int j=1;j<=maxjump;j++){
            if(memo(dp,nums,start+j)){
             return  dp[start]=true;
            }
          }
          return dp[start]=false;
    }
}
