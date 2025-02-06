package SildingWindow;

import java.util.HashMap;
import java.util.Map;

public class FindLongestUniqueCharacterSubArray {

    public static void main (String[] args) {
        int result = findLongestUniqueCharacterSubArray("joizyglhbetjlvglzvvktxqsslufceppzpgogrifbeyuiblmgcqtkhhbimxigczvbtvrtsperlhunsyywgnttbwjgunjwjtqzqvrdumddtzaffcmjlakmfappoqqkvmfnevaabqxtzslodalgvtwvbsknohmjcumrrqktskvidbizexkprdonsjkbcoeplcafdalmvfaswnjkiqcwowhykczbdkankmkrrwsmcomaubfelnljztemcbmmoptndjodpqnikglvraezkvfxcphvgdgkouirhidbdtesjogrilbxhgtqprexyxptbqdxnwsuddzoiuumlbbgmhuzbgaslssvtexzlipsqfrfvxbkxmazocqvtaguvxmoqvhkfklucswkizrpatpakmuswqdsmxtnuujewtwtrnofowrgmxegwkxokotqhfodaegkmopjpdvpxzjrunwfqeldjhajnjzaargszgxakniopptsoakustvpbtocrovfceofpbeddqeidyvosbwbspesilldkdvocbfrbzthbgsnzaabjfbeanwoicritttjvkromyiodiazfgzktgkeqjmojamqrdusaibheiivnvmokacqudrcairqtisixcjxjsdubgusrcpleludvkjiabbeukbeadqruccuhwcrgosagtuyjfhnaniapxkrqdbmdsbxrzriyszsoguditxxpvdopzktljyrdzxunnybfzfqoezhizbustnwlpqypfqtgxapvwrcybnsjfrsdhyafsdglucczqtoazaycxybnlratmdqphtdwqsddhkrhvbgsytp",10);
        System.out.println(result);
    }

    public static int findLongestUniqueCharacterSubArray(String text, int k){// k is a no of unique character should be present in sub array
          int start = 0 ,end = 0;
          //return 0 if no sub array with k unique character exist
          int maxLength = -1;

          Map<Character, Integer> mapper = new HashMap();

          while(end < text.length()){
                //calc
              if (mapper.containsKey(text.charAt(end))) mapper.put(text.charAt(end), mapper.get(text.charAt(end)) + 1);
              else mapper.put(text.charAt(end),1);

              //result
              if(mapper.size() == k){
                  maxLength = Math.max(maxLength, end + 1 - start);
              }

              //remove extra characters from mapper
              if(mapper.size() > k){
                  while(mapper.size() > k){
                        mapper.put(text.charAt(start), mapper.get(text.charAt(start)) - 1);

                        if(mapper.get(text.charAt(start)) == 0) mapper.remove(text.charAt(start));
                        start++;
                  }

              }

              end++;
          }
        return maxLength;
    }



}
