import java.util.HashMap;

class SolutionCBS {
    public long beautifulSubstrings(String s, int k) {
        long count = 0;
//        int n = s.length();
        /*
        for(int start = 0;start<n;start++){
            int vowels = 0,constants = 0;
            for(int end = start;end<n;end++){
                char ch = s.charAt(end);
                if(isVowel(ch)){
                    vowels++;
                }else{
                    constants++;
                }

                if(vowels == constants){
                    long product = vowels*constants;
                    if(product%k == 0){
                        count++;
                    }
                }

                if(Math.abs(vowels-constants) > (n-end-1)){
                    break;
                }
            }
        }
    */
        /**
         *          int vowels = 0;
         *         long count = 0;
         *         int keyHash;
         *         for (keyHash = 1; keyHash * keyHash % (k * 4) > 0; ++keyHash);
         *         for(int i = 0;i<keyHash;i++){
         *              map.put(i,new HashMap<>());
         *         }
         *         Map<Integer, HashMap<Integer,Integer>> prefixMap = new HashMap<>();
         *         prefixMap.put("0#0", 1); // base prefix
         *
         *         for (char ch : s.toCharArray()) {
         *             if (isVowel(ch)) vowels++;
         *             else vowels--;
         *
         *
         *             int vowelMod = ((vowels % k) + k) % k;  // safe modulo
         *
         *             String key = balance + "#" + vowelMod;
         *
         *             count += prefixMap.getOrDefault(key, 0);
         *             prefixMap.put(key, prefixMap.getOrDefault(key, 0) + 1);
         *         }
         *
         *         return count;
         */

/*
        int n = s.length(), v = 0, l;

        for (l = 1; l * l % (k * 4) > 0; ++l);
        System.out.println(l);

        HashMap<Integer, Integer>[] seen = new HashMap[l];

        for (int i = 0; i < l; i++) {
            seen[i] = new HashMap<>();
        }
        seen[l - 1].put(0, 1);

        for (int i = 0; i < n; i++) {
            v+= isVowel(s.charAt(i)) ? 1: -1;
            int c = seen[i % l].getOrDefault(v, 0);
            count += c;
            seen[i % l].put(v, c + 1);
        }
        return count;
 */
        int vowels = 0;
        int n = s.length();
        int keyHash;
        for (keyHash = 1; keyHash * keyHash % (k * 4) > 0; ++keyHash);
        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0;i<keyHash;i++){
            map.put(i,new HashMap<>());
        }

        map.get(keyHash-1).put(0,1); // base prefix

        for (int i = 0;i<n;i++) {
            if (isVowel(s.charAt(i))) vowels++;
            else vowels--;



            int c = map.get(i%keyHash).getOrDefault(vowels, 0);
            count += c;
            map.get(i%keyHash).put(vowels,c+1);
        }

        return count;
    }

    private boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}
public class CountBeautifulStrings {
    public static void main(String[] args) {
        SolutionCBS cbs = new SolutionCBS();
        System.out.println(cbs.beautifulSubstrings("baeyh",2));
    }
}
