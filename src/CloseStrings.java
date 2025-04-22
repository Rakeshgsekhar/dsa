import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        int[] word1Freq = new int[27];
        int[] word2Freq = new int[27];

        for(char c : word1.toCharArray()){
            word1Freq[c-'a']++;
        }
        for(char c : word2.toCharArray()){
            word2Freq[c-'a']++;
        }

        return op1(word1Freq,word2Freq)&&op2(word1Freq,word2Freq);

    }
    public boolean op1(int[] word1Freq, int[] word2Freq){
        for(int i = 0;i<=26;i++){
            if((word1Freq[i]==0 && word2Freq[i] != 0) || (word2Freq[i]==0 && word1Freq[i] != 0)) return false;
        }
        return true;
    }

    public boolean op2(int[] word1Freq, int[] word2Freq){
        Arrays.sort(word1Freq);
        Arrays.sort(word2Freq);

        for(int i = 0;i<=26;i++){
            if(word1Freq[i]!=word2Freq[i]) return false;
        }
        return true;
    }
}
