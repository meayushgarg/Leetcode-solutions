class Solution {

    public String convert(String str){
        int si = 0;
        StringBuilder sb = new StringBuilder();

        while(si < str.length()){
            int count = 1, ni = si + 1;
            char ch = str.charAt(si);

            while(ni < str.length() && str.charAt(ni) == str.charAt(si)){
                ni++;
                count++;
            }

            si = ni;
            sb.append(count + "").append(ch);
        }

        return sb.toString();
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        String recAns = countAndSay(n-1);
        return convert(recAns);
    }
}
