class Solution{
    public static int findMinSpead(int[] piles, int h){
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while(left < right){
            int middle = left + (right - left)/2;
            if(canFinish(piles, middle, h)){
                right = middle;
            }else{
                left = middle+1;
            }
        }
        return left;
    }
    public static boolean canFinish(int[] piles, int speed, int h){
        int hours = 0;
        for(int pile: piles){
            hours += Math.ceil((double)pile / speed);
        }
        return hours <= h;
    }
    public static void main(String[] args) {
        System.out.println(findMinSpead(new int[]{3,6,7,11}, 8));                    //4
        System.out.println(findMinSpead(new int[]{30,11,23,4,20}, 5));               //30
        System.out.println(findMinSpead(new int[]{30,11,23,4,20}, 6));               //23
    }
}