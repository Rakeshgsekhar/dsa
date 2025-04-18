public class MergeStringAlternatively {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqr"));
        System.out.println(mergeAlternately("ab","pqrs"));
        System.out.println(mergeAlternately("abcdef",""));

    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int l1 = word1.length(),l2 = word2.length();
        if(l1 == 0) return word2;
        if(l2 == 0) return word1;
        int it1 = 0,it2 =0;
        while(it1<l1 && it2<l2){
            result.append(word1.charAt(it1));
            result.append(word2.charAt(it2));
            it1++;
            it2++;
        }
        while(it1<l1){
            result.append(word1.charAt(it1));
            it1++;
        }
        while(it2<l1){
            result.append(word2.charAt(it2));
            it2++;
        }
        return result.toString();
    }
}
