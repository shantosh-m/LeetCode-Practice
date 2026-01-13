class Solution{
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n -1;
        while(left <= right){
            int middle = (left + right)/2;
            int midValue = matrix[middle/n][middle%n];
            if(midValue == target){
                return true;
            }else if(midValue < target){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));           //true
        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));          //false
    }
}