
class SolutionITR {
    public String intToRoman(int num) {

        if(num>3999) return sol(num);

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String ns = String.valueOf(num);

        int n = ns.length();
        int i = n-1;
        while(i>=0){
            if(temp.length() !=0){
                temp.setCharAt(0,'0');
            }
            temp.insert(0,ns.charAt(i));
            //temp.reverse();
            int val = Integer.parseInt(temp.toString());
            StringBuilder builder = new StringBuilder();
            if(val<10) {
                if (val < 4) {
                    switch (val) {
                        case 1:
                            builder.append("I");
                            break;
                        case 2:
                            builder.append("II");
                            break;
                        case 3:
                            builder.append("111");
                    }
                }else if(val == 4){
                    builder.append("IV");
                }else{
                    if(val == 9){
                        builder.append("IX");
                    }else{
                        builder.append("V");
                        int k = val-5;
                        for(int m = 0;m<k;m++){
                            builder.append("I");
                        }
                    }
                }
            }else if(val<100){
                if (val < 40) {
                    switch (val) {
                        case 10:
                            builder.append("X");
                            break;
                        case 20:
                            builder.append("XX");
                            break;
                        case 30:
                            builder.append("XXX");
                    }
                }else if(val == 40){
                    builder.append("XL");
                }else{
                    if(val == 90){
                        builder.append("XC");
                    }else{
                        builder.append("L");
                        int k = (val-50)/10;
                        for(int m = 0;m<k;m++){
                            builder.append("X");
                        }
                    }
                }
            }else if(val<1000){
                if (val < 400) {
                    switch (val) {
                        case 100:
                            builder.append("C");
                            break;
                        case 200:
                            builder.append("CC");
                            break;
                        case 300:
                            builder.append("CCC");
                    }
                }else if(val == 400){
                    builder.append("CD");
                }else{
                    if(val == 900){
                        builder.append("CM");
                    }else{
                        builder.append("D");
                        int k = (val-500)/100;
                        for(int m = 0;m<k;m++){
                            builder.append("C");
                        }
                    }
                }

            }else {
                if (val < 4000) {
                    switch (val) {
                        case 1000:
                            builder.append("M");
                            break;
                        case 2000:
                            builder.append("MM");
                            break;
                        case 3000:
                            builder.append("MMM");
                    }
                }
            }
            result.insert(0,builder);
            i--;
        }
        return result.toString();
    }

    private String sol(int num){
        /**Handle case even input greater than 3999 */
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                res.append("M");
                num -= 1000;
            }
            else if (1000 > num && num >= 900) {
                res.append("CM");
                num -= 900;
            }
            else if (num >= 500) {
                res.append("D");
                num -= 500;
            }
            else if (500 > num && num >= 400) {
                res.append("CD");
                num -= 400;
            }
            else if (num >= 100) {
                res.append("C");
                num -= 100;
            }
            else if (100 > num && num >= 90) {
                res.append("XC");
                num -= 90;
            }
            else if (num >= 50) {
                res.append("L");
                num -= 50;
            }
            else if (50 > num && num >= 40) {
                res.append("XL");
                num -= 40;
            }
            else if (num >= 10) {
                res.append("X");
                num -= 10;
            }
            else if (10 > num && num >= 9) {
                res.append("IX");
                num -= 9;
            }
            else if (num >= 5) {
                res.append("V");
                num -= 5;
            }
            else if (5 > num && num >= 4) {
                res.append("IV");
                num -= 4;
            }
            else if (num >= 1) {
                res.append("I");
                num -= 1;
            }
        }
        return res.toString();
    }
}

public class IntegerToRoman {

    public static void main(String[] args) {
        SolutionITR sr = new SolutionITR();
        System.out.println(System.currentTimeMillis());
        System.out.println(sr.intToRoman(3749));
        System.out.println(System.currentTimeMillis());
        //System.out.println(sr.intToRoman(58));
       // System.out.println(sr.intToRoman(311));
      //  System.out.println(sr.intToRoman(1994));

        System.out.println(System.currentTimeMillis());
        System.out.println(sr.intToRoman(5987));
        System.out.println(System.currentTimeMillis());


    }
}
