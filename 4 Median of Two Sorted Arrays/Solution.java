class Solution{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        
        int start = 0;
        int end = x;
        
        while(start <= end){
            int xPart = (start+end)/2;
            int yPart = (x+y+1)/2 - xPart;

            int xLeft = (xPart == 0) ? Integer.MIN_VALUE : nums1[xPart-1];
            int xRight = (xPart == x) ? Integer.MAX_VALUE : nums1[xPart];
            
            int yLeft = (yPart == 0) ? Integer.MIN_VALUE : nums2[yPart-1];
            int yRight = (yPart == y) ? Integer.MAX_VALUE : nums2[yPart];
            
            if(xLeft <= yRight && yLeft <= xRight){
                if((x+y+1)%2 == 0){                     //odd order
                    return Math.max(xLeft, yLeft);
                }else{
                    return ((double)Math.max(xLeft, yLeft) + Math.min(xRight, yRight))/2;
                }
            }else if(xLeft > yRight){
                end = xPart-1;
            }else{
                 start = xPart+1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));                 //2.00000
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));              //2.50000
    }
}