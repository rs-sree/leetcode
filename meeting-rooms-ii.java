class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i]=intervals[i][1];
        }
        
        Arrays.sort(end, new Comparator<Integer> () {
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        Arrays.sort(start, new Comparator<Integer> () {
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        int start_pointer=0, end_pointer = 0;
        int usedRooms = 0;
        while (start_pointer < intervals.length) {
            if(start[start_pointer] >= end[end_pointer]) {
                usedRooms -= 1;
                end_pointer += 1;
            }
            usedRooms += 1;
            start_pointer += 1;
        }
        return usedRooms;
    }
}