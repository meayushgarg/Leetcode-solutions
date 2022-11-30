// 1st approach using array

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), count = 0, si = 0, ei = 0, max = 0;
        int []freq = new int[128];

        while(ei < n){
            if(freq[s.charAt(ei++)]++ == 1){
                count++;
            }

            while(count == 1){
                if(freq[s.charAt(si++)]-- > 1){
                    count--;
                }
            }

            max = Math.max(max,ei-si);
        }

        return max;
    }
}

// 2nd approach using hashmap

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), si = 0, ei = 0, count = 0, max = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(ei < n){
            char ch = s.charAt(ei);

            if(map.getOrDefault(ch,0) == 1){
                count++;
            }

            map.put(ch,map.getOrDefault(ch,0) + 1);
            ei++;

            while(count == 1){
                char ch2 = s.charAt(si);
                if(map.get(ch2) > 1){
                    count--;
                }

                map.put(ch2,map.get(ch2) - 1);
                si++;
            }

            max = Math.max(max,ei-si);
        }

        return max;
    }
}
