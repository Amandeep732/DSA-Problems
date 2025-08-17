/**
 * @param {number} num
 * @return {number}
 * level easy 
 * topic = math, greedy contests
 */
var maximum69Number  = function(num) {
   let ans = num;
   let nums = num.toString().split('');
   let i = 0;
   while(nums.length > i){
    const store = nums[i];
    if(nums[i] === 9){
        nums[i] = 6;
        const fake = Number(nums.join(''));
        ans = Math.max(fake, ans);
    }else{
        nums[i] = 9;
        const fake = nums.join('');
        ans = Math.max(fake, ans); 
    }
    nums[i] = store;
    i++;
   } 
   return ans;
};