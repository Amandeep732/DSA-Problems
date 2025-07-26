package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
public class Longest_Repeating_Character_Replacement{
      public int characterReplacement(String s, int k) {
      Map<Character, Integer> map = new HashMap<>();
      int ans =0;
      int maxCount = 0;
      int left = 0;

      for(int r = 0; r < s.length(); r++){
        char ch = s.charAt(r);
        map.put(ch, map.getOrDefault(ch, 0)+1);
        maxCount = Math.max(maxCount, map.get(ch));

        if(r - left + 1 - maxCount > k){
          char leftchar = s.charAt(left);
          map.put(leftchar, map.get(leftchar)-1);
          left++;
        }
        ans = Math.max(ans, r - left + 1);
      } 
      return ans;
    }
}
