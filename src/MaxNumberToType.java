
class SolutionMaxWordType {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int chrs[] = new int[26];
        for(char ch : brokenLetters.toCharArray()){
            chrs[ch-'a']++;
        }
        boolean canType = true;
        int ans = 0;
        for(char ch : text.toCharArray()){
            if(ch == ' '){
                if(canType){
                    ans++;
                }else{
                    canType = true;
                }
            }else{
                if(chrs[ch-'a'] != 0) {
                    canType = false;
                }
            }
        }
        if(canType) ans++;
        return ans;
    }
}
public class MaxNumberToType {
    public static void main(String[] args) {
        SolutionMaxWordType smw = new SolutionMaxWordType();
        int st = smw.canBeTypedWords("hello world","ad");
        System.out.println(st);
        System.out.println(smw.canBeTypedWords("leet code","e"));
    }
}
