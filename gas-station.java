class Solution {
 public int canCompleteCircuit(int[] gas, int[] cost) {
        int availableGas = 0;
        int totalGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            availableGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (availableGas < 0) {
                availableGas = 0;
                index = i + 1;
            }
        }
        if (totalGas < 0) {
            return -1;   
        }
        return index;
    }
}