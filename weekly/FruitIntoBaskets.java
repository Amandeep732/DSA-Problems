package weekly;

import java.util.HashMap;
import java.util.Map;

    //   problem number = 904 on leetcode
    //   topics = sliding window, hashmap Array
    //   from weekly contest 102 on leetcode

public class FruitIntoBaskets {
public int totalFruit(int[] nums) {
       int ans = 0;
       int left = 0;
       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < nums.length; i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0) +1);

            while(map.size() > 2){
                map.put(nums[left], map.get(nums[left]) - 1); 
                if (map.get(nums[left]) == 0) { // agar count 0 ho gaya to hi entry hatao
                      map.remove(nums[left]);
                 }
                left++;
            }
           ans = Math.max(ans, i - left +1);
       }
       return ans;
    }
    
}
