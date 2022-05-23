class Solution {
    public int maxDistToClosest(int[] seats) {
        int count1 = 0;
        int count2 = 0;
        int i = 0, j = seats.length-1;
        while(seats[i] == 0){
            count1++;
            i++;
        }
        while(seats[j] == 0){
            count2++;
            j--;
        }
        int countmid = 0, countmax = 0;
        for(int k = i+1; k <= j; k++){
            if(seats[k] == 0){
                countmid++;
            }else{
                countmax = Math.max(countmax, countmid);
                countmid = 0;
            }
        }
        return Math.max(Math.max(count1, count2), (countmax+1)/2);
    }

}