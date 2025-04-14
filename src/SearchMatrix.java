public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;

        for(int i = 0 ; i<row;i++){
            if(matrix[i][0] == target || matrix[i][col-1]==target) return true;
            else if(target>matrix[i][0] && target<matrix[i][col-1]){
                int left = 0;
                int right = col-1;
                while(left<=right){
                    int mid = (right+left)/2;
                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] < target) left = mid+1;
                    else right = mid-1;
                }
                return false;
            }
        }
        return false;
    }
}
