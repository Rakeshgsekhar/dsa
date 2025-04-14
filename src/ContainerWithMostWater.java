public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(left<right){
            int minHeight = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,minHeight*(right-left));
            if(left<right && height[left]<= minHeight) left++;
            else right--;
        }
        return maxArea;

    }
}
