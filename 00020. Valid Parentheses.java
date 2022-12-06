// 1st approach

class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        LinkedList<Character> st = new LinkedList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.addLast(ch);
            }else{
                if(st.size() == 0 || map.get(ch) != st.getLast()){
                    return false;
                }else{
                    st.removeLast();
                }
            }
        }

        return st.size() == 0;
    }
}

// 2nd 

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> st = new LinkedList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                st.addLast(ch);
            }else if(ch == ')'){
                if(st.size() == 0 || st.getLast()!='('){
                    return false;
                }else{
                    st.removeLast();
                }
            }else if(ch == ']'){
                if(st.size() == 0 || st.getLast()!='['){
                    return false;
                }else{
                    st.removeLast();
                }
            }else if(ch == '}'){
                if(st.size() == 0 || st.getLast()!='{'){
                    return false;
                }else{
                    st.removeLast();
                }
            }
        }

        return st.size() == 0;
    }
}
