package SildingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {

    public static void main(String[] args){
        System.out.println(longestSubstringWithDistinctCharacters("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs"));
    }

    public static int longestSubstringWithDistinctCharacters(String s) {

        int maxString = 0, start = 0, end = 0;
        Map<Character, Integer> mapper = new HashMap<>();


        //initialize the distinct characters in a map
        for(int i = 0; i< s.length(); i++){
            mapper.put( s.charAt(i),mapper.getOrDefault(s.charAt(i), 0));
        }

        while(end < s.length()){

            //run to remove the already existed character from the subArray
            while(mapper.get(s.charAt(end)) == 1){
                    mapper.put(s.charAt(start),0);
                    start++;
            }

            //calculate the maximum length of subarray present for distinct characters
            maxString = Math.max(maxString, end - start + 1);

            //change the value to 1 that is true once it occured in subArray
            mapper.put(s.charAt(end), 1);

            end++;
        }

        return  maxString;

    }
}
