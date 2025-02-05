package SildingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramSubArray {
        public static void main(String[] args) {
            int result = findAnagram("aabaababa", "aaba");
            System.out.println(result);
        }

        public static int findAnagram(String s, String ptr){
            int count = 0;
            int i = 0;
            int j = 0;

            HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();

            for (int a = 0; a < ptr.length(); a++){
                if(mapper.containsKey(ptr.charAt(a))){
                    mapper.put(ptr.charAt(a), mapper.get(ptr.charAt(a)) + 1);
                }
                else{
                    mapper.put(ptr.charAt(a), 1);
                }
            }

            int lengthOfMapper = mapper.size();

            while(j < s.length()){
                char endChar = s.charAt(j);

                if(mapper.containsKey(endChar)){
                    mapper.put(endChar, mapper.get(endChar) - 1);
                    if(mapper.get(endChar) == 0) lengthOfMapper--;
                }

                if(j - i + 1 == ptr.length()){
                    if(lengthOfMapper == 0) count++;

                    char startChar = s.charAt(i);

                    if(mapper.containsKey(startChar)){
                        mapper.put(startChar, mapper.get(startChar) + 1);
                        if(mapper.get(startChar) == 1) lengthOfMapper++;
                    }
                    i++;
                }
                j++;
            }

            System.out.print("waiting for output");
            return count;

        }



}
