public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        // for(char c : letters){
        //     if(c>target) return c;
        // }
        // return letters[0];
        return binarySearch(letters,target);
    }

    public char binarySearch(char[]letters,char target){
        int left = 0;
        int right = letters.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(letters[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return letters[left%letters.length];
    }
}
