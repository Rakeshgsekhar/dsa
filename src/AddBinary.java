class SolutionAB {
    public String addBinary(String a, String b) {
        /*int ib = b.length()-1;
        int ia = a.length()-1;
        char carryOver = 0;
        StringBuilder sum = new StringBuilder();
        while(ib>=0 && ia>=0){
            if(a.charAt(ia) == '0' && b.charAt(ib) == '0'){
                if(carryOver == '1'){
                    sum.append('1');
                }else{
                    sum.append('0');
                }
                carryOver = '0';
            }else if(a.charAt(ia) == '1' && b.charAt(ib) == '1'){
                if(carryOver == '1'){
                    sum.append('1');
                }else{
                    sum.append('0');
                }
                carryOver = '1';
            }else{
                if(carryOver == '1'){
                    sum.append('0');
                    carryOver = '1';
                }else{
                    sum.append('1');
                }
            }
            ib--;
            ia--;
        }

        while(ia>=0){
            if(a.charAt(ia) == '0'){
                if(carryOver == '1'){
                    sum.append('1');
                }else{
                    sum.append('0');
                }
                carryOver = '0';
            }else if(a.charAt(ia) == '1' ){
                if(carryOver == '1'){
                    sum.append('0');
                    carryOver = '1';
                }else{
                    sum.append('1');
                    carryOver = '0';
                }
            }
            ia--;
        }

        while(ib>=0 ){
            if( b.charAt(ib) == '0'){
                if(carryOver == '1'){
                    sum.append('1');
                }else{
                    sum.append('0');
                }
                carryOver = '0';
            }else if(b.charAt(ib) == '1'){
                if(carryOver == '1'){
                    sum.append('0');
                    carryOver = '1';
                }else{
                    sum.append('1');
                    carryOver = '0';
                }
            }
            ib--;
        }
        if(carryOver == '1'){
            sum.append(carryOver);
        }

        return sum.reverse().toString();

         */
        if (a.length() > b.length())
            return addBinary(b, a);
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int k = b.length();
        int sum = 0;
        int carry = 0;

        while (j >= 0) {
            int ch_a = i >= 0 ? a.charAt(i--) - '0' : 0;
            int ch_b = b.charAt(j) - '0';

            sum = ch_a + ch_b + carry;
            int res = sum % 2;
            carry = sum / 2;
            result.append((char) (res + '0'));
            j--;

        }
        if (carry == 1)
            result.append('1');

        return result.reverse().toString();
    }
}
public class AddBinary {
    public static void main(String[] args) {
        SolutionAB ab = new SolutionAB();
        System.out.println(ab.addBinary("11","1"));
        System.out.println(ab.addBinary("1010","1011"));
    }
}
