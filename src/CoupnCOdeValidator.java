import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SolutionCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> validCoupons = new ArrayList<>();
        Map<String,List<String>> map = new LinkedHashMap<>();
        buildMap(map);
        for(int i = 0;i<businessLine.length;i++){
            if(isValidCode(code[i]) && isActive[i]) {
               if(map.containsKey(businessLine[i])) map.get(businessLine[i]).add(code[i]);
            }
        }

        for(Map.Entry<String,List<String>> vl : map.entrySet()){
            Collections.sort(vl.getValue());
            validCoupons.addAll(vl.getValue());
        }
        return validCoupons;
    }
    private void buildMap(Map<String,List<String>> map){
        map.put("electronics",new ArrayList<>());
        map.put("grocery",new ArrayList<>());
        map.put("pharmacy",new ArrayList<>());
        map.put("restaurant",new ArrayList<>());
    }

    private boolean isValidCode(String code){
        String regex = "^[a-zA-Z0-9_]+$";
        return code.matches(regex);
    }
}
public class CoupnCOdeValidator {
    public static void main(String[] args) {
        SolutionCodeValidator sd = new SolutionCodeValidator();
        sd.validateCoupons(new String[]{"tGNnvQNbDx","l9sCJYBdtt","We0rOzWCZ1","GyFpNFw0ER","56irw4f6Kh"},new String[]{"electronics","grocery","pharmacy","pharmacy","pharmacy"},new boolean[]{false,false,true,true,true});
    }
}
