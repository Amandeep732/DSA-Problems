/**
 * @param {string} num
 * @return {string}
 * problem number = 2264 on leetcode 
 * topic = string
 * from weekly contests
 */


var largestGoodInteger = function(num) {
    let ans = '';

    for(let i = 0; i < num.length; i++){

        if(num[i] === num[i+1] && num[i+1] === num[i+2]){
            const curr = num[i] + num[i] + num[i];
            if(ans < curr){
                ans = curr;
            } 
            i+2;
        }
    }
    return ans;
};