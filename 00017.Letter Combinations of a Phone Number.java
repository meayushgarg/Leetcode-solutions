class Solution {

    public List<String> letterCombinations_(String digit, String []keys, int idx){
        if(idx == digit.length()){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> recAns = letterCombinations_(digit,keys,idx + 1);
        List<String> myAns = new ArrayList<>();

        String currKey = keys[digit.charAt(idx) - '0'];

        for(int i=0; i<currKey.length(); i++){
            char ch = currKey.charAt(i);
            for(String r: recAns){
                myAns.add(ch + r);
            }
        }

        return myAns;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        String []keys = {".", ",,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return letterCombinations_(digits,keys,0);
    }
}
