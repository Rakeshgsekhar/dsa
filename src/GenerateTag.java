class SolutionGNT {
    public String generateTag(String caption) {
        StringBuilder ans = new StringBuilder(100);
        String[] strings  = caption.trim().split("\\s");
        ans.append("#");
        String first = strings[0];
        ans.append(first.toLowerCase());

        for(int i = 1;i<strings.length;i++){
            System.out.println(strings[i]+"::"+strings[i].length());
            if(!strings[i].equals(" ") && !strings[i].isBlank() && !strings[i].isEmpty() && strings[i].length()>0 )
                ans.append(strings[i].substring(0,1).toUpperCase()).append(strings[i].substring(1,strings[i].length()).toLowerCase());
        }
        System.out.println(ans.substring(0,101).length());
        return ans.toString().substring(0,100);
    }
}
public class GenerateTag {
    public static void main(String[] args) {
        SolutionGNT gt = new SolutionGNT();
        gt.generateTag("FkVsgzfhQxPYKr WtaCvDuHQeo roeVHIoPorZuIuMDxhYVs jlfCrXCDqBVjgmzxxmZOpUpCc  eHMpZrNxilBPngylMcS"
        );
    }
}
