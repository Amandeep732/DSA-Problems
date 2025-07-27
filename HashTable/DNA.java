class solution {


      // problem number 187 on leetcode
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        StringBuilder str = new StringBuilder();
        HashSet<String> seen = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            str.append(s.charAt(right));

            if (str.length() > 10) {
                str.deleteCharAt(0);
            }

            if(str.length() == 10){
                if(set.contains(str.toString()) && !seen.contains(str.toString())){
                    seen.add(str.toString());
                    ans.add(str.toString());
                }else{
                    set.add(str.toString());
                }
            }
        }
        return ans;
    }
}