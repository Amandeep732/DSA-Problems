/**
 * @param {number} n
 * @return {string}
 * problem number 38 on leetcode
 * level medium
 * topics = String, recursion
 */
var countAndSay = function(n) {

     function rec(n, index, ans) {
     if(index === n){
        return ans;
     }
     let str = '';
     let count = 1;
     for(let i = 0; i < ans.length; i++){
         if(i+1 < ans.length && ans[i] === ans[i+1]){
           count++;
         }else{
            str += count.toString() + ans[i];
            count = 1;
         } 
     }
    return rec(n, index+1, str);
   }

  return rec(n, 1, '1');
   
};