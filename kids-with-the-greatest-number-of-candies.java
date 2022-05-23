class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i = 1; i<candies.length; i++) {
            if(candies[i] > max ) {
                max = candies[i];
            }
        }
        //Loop through each elem to set output[i] to true or false, depending on the sum of candies[i] and extraCandies
        List<Boolean> output = new ArrayList();
        for(int i =0; i<candies.length; i++){
            if(extraCandies>=max-candies[i]){
                output.add(true);
            }
            else{
                output.add(false);
            }
        }
        //finally, return the output list
        return output;
    }
}