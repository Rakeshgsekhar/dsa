class SolutionVGAB {
    public boolean doesAliceWin(String s) {
        /*String vowels = "aeiou";
        int vowelCount = 0;
        for(int i = 0;i<s.length();i++){
            if(vowels.contains(String.valueOf(s.charAt(i)))){
                vowelCount++;
            }
        }
        return vowelCount!=0;*/
        /*for (int i=0;i<s.length();i++)
        {
            switch (s.charAt(i))
            {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
            }
        }
        return false;*/
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }
}
public class VowelsGamesAliceAndBob {
}
