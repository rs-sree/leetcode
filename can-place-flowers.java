class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        
        int index = 0;
        while(index < flowerbed.length) {
            if(flowerbed[index] == 0) {
                if(index + 1 < flowerbed.length) {
                    if(flowerbed[index + 1] == 0) {
                        n--;
                        index += 2;
                    } else {
                        index += 3;
                    }
                } else {
                    //edge
                    n--;
                    break;
                }
            } else {
                index += 2;
            }
            
            if(n == 0)
                return true;
            
        }
        
        return n == 0;
        
        
    }
}