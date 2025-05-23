import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionSS3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String l = sentence1.length() > sentence2.length() ? sentence1 : sentence2;
        String s = sentence1.length() < sentence2.length() ? sentence1 : sentence2;
        if(sentence1.length()<sentence2.length()){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
//        String[] s1 = sentence1.split(" ");
//        String[] s2 = sentence2.split(" ");
        if(sentence1.length() == sentence2.length()){
            System.out.println(sentence1.equals(sentence2));
            return sentence1.equals(sentence2);
        }
        if(l.indexOf(s + " ") == 0) {
            System.out.println("true");
            return true;
        }

        if(l.lastIndexOf(" " + s) == l.length() - s.length() - 1) {
            System.out.println("true");
            return true;
        }
        List<String> s1 = Arrays.asList(l.split(" "));
        List<String> s2 = Arrays.asList(s.split(" "));
        int n1 = s1.size(),n2 = s2.size();
        int prefixIndex = 0;
        StringBuilder prefix1 = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        int suffixIndex1 = n1;
        int suffixIndex2 = n2-1;

        while(prefixIndex<s1.size() && prefixIndex<s2.size()){
            if(!s1.get(prefixIndex).equals(s2.get(prefixIndex))){
               break;
            }
            prefix1.append(s1.get(prefixIndex));
            prefix1.append(" ");
            prefixIndex++;
        }
        for(int i = n2-1;i>=0;i--){
       // while(suffixIndex1>=0 && suffixIndex1>prefixIndex-1 && suffixIndex2>=0 && suffixIndex2>prefixIndex-1){
            if(s1.get(suffixIndex2).equals(s2.get(i))){
                suffix.append(s1.get(suffixIndex1));
                suffixIndex2--;
                suffixIndex1 = i;
            }else {
                break;
            }
        }
        return suffixIndex1<=prefixIndex;
/*
        if(prefix1.isEmpty()){
            System.out.println("false");
            return false;
        }

        if(suffix.isEmpty()){

            if((n1==1 || n2==1)){
                System.out.println("true");
                return true;
            }else {
                System.out.println(s1.get(n1-1).equals(s2.get(n2-1)));
                return s1.get(n1-1).equals(s2.get(n2-1));
            }
        }
        List<String> added = new ArrayList<>(s1.size());
        StringBuilder tempStr = new StringBuilder();
        for(int i =0;i<s2.size();i++){
            added.add(s2.get(i));
        }
        for(int i = prefixIndex;i<=suffixIndex1;i++){
            tempStr.append(s1.get(i));
            tempStr.append(" ");

            added.add(i,s1.get(i));
        }

        String comp = String.join(" ",added);
        System.out.println(l.equals(comp));
        return true;

*/
        /*
        if(s1.length<s2.length){
            String[] temp = s1;
            s1 =s2;
            s2 = temp;
        }
        int n1 = s1.length,n2=s2.length;
        int start = 0,end = 0;
        while(start<n2 && s1[start].equals(s2[start])){
            start++;
        }

        while(end<n2 && s1[n1-end-1].equals(s2[n2-end-1])){
            end++;
        }

        return start+end>=n2;

         */
    }

    private void swap(List<String> sentence,int start,int end){
        while(start<end){
            String temp = sentence.get(start);
            sentence.set(start,sentence.get(end));
            sentence.set(end,temp);
            start++;
            end--;
        }
    }
}
public class SentenceSimilarityIII {
    public static void main(String[] args) {
        SolutionSS3 ss = new SolutionSS3();
       /* ss.areSentencesSimilar("My name is Haley","My Haley");
        ss.areSentencesSimilar("of","A lot of words");
        ss.areSentencesSimilar("Eating right now","Eating carrot");
        ss.areSentencesSimilar("Eating right now","Eating");
        ss.areSentencesSimilar("A","a A b A");
        ss.areSentencesSimilar("My Haley","My name is Haley");
        ss.areSentencesSimilar("Haley","My name is Haley");
        ss.areSentencesSimilar("Haley and","My name is Haley");
        ss.areSentencesSimilar("is Haley","My name is Haley");
        ss.areSentencesSimilar("Are You Okay","are you okay");*/
        ss.areSentencesSimilar("A B C D B B","A B B");
    }
}
