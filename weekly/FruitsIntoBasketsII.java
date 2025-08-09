 class FruitsIntoBasketsII {
    // problem number 3477  on leetcode
    // from weekly contests

    public int numOfUnplacedFruits(int[] nums, int[] baskets) {
      int count = 0;
      for(int i = 0; i < nums.length; i++){
        for(int j = 0; j < nums.length; j++){
            if(nums[i] <= baskets[j]){
                count++;
                baskets[j] = -1;
                break;
            }
        }
      }   
      return nums.length - count;
    } 
}
