package Bi-weekly;


   /// question number 3634 on leetcode
   /// Bi-weekly contest
   /// Topic : Sliding window 
public class Solution {
    public int minRemoval(int[] nums, int k) {
      Arrays.sort(nums);
        int left = 0;
        int maxLen = 1;

        for (int right = 0; right < nums.length; right++) {
            // shrink window until it becomes valid
            while (nums[right] > (long) k * nums[left]) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return nums.length - maxLen;
    }
} {
    
}
