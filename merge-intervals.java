// class Solution {
// //     public int[][] merge(int[][] intervals) {
// //         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
// //         LinkedList<int[]> merged = new LinkedList<>();
// //         for(int[] interval : intervals) {
// //             if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
// //                 merged.add(interval);
// //             } else {
// //                 merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
// //             }
// //         }
// //         return merged.toArray(new int[merged.size()][]);
        
// //     }
//     public int[][] merge(int[][] intervals) {
//     //the special situation
//     if (intervals.length == 1) {
//       return intervals;
//     }
//     //override the sort function
//     Arrays.sort(intervals, new Comparator<int[]>() {
//       @Override
//       public int compare(int[] o1, int[] o2) {
//         return o1[0] - o2[0];
//       }
//     });
//     //because we don't know how long the result will be,so we use arraylist
//     ArrayList<int[]> list = new ArrayList<>();
//     //set a slow pointer
//     int[] current_interval = intervals[0];
//     //and add it at first,if don't add it,we will miss the first of the result array
//     list.add(current_interval);
//     //traverse the array
//     for (int[] interval : intervals) {
//       //because we don't need to judge the current[0],we just need to judge the current[1],so we
//       // don't need this step
//       //int current_begin = current_interval[0];
//       int current_end = current_interval[1];
//       //the faster pointer
//       int next_begin = interval[0];
//       int next_end = interval[1];
//       //merge the two arrays to be a new result array
//       if (current_end >= next_begin) {
//         current_interval[1] = Math.max(current_end, next_end);
//       } else {
//         //we just need to update the two pointers
//         current_interval = interval;
//         list.add(current_interval);
//       }
//     }
//     return list.toArray(new int[list.size()][]);
//   }
// }


class Solution {
    public int[][] merge(int[][] intervals) {
        // corner case
        if(intervals == null) {
            return new int[0][];
        }
        
        // construct tree
        TreeNode root = null;
        for(int[] interval : intervals) {
            root = add(root, interval);
        }
        
        // build merge
        List<int[]> res = merge(root);
        return list2Arr(res);
    }
    
    private int[][] list2Arr(List<int[]> list) {
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private List<int[]> merge(TreeNode root) {
        // base case
        if(root == null) {
            return new ArrayList<>();
        }
        List<int[]> left = merge(root.left);
        List<int[]> right = merge(root.right);
        List<int[]> res = new ArrayList<>();
        
        for(int[] interval : left) {
            if(interval[1] < root.leftBound) {
                res.add(interval);
            } else {
                update(root, interval);
            }
        }
        
        for(int[] interval : right) {
            if(interval[0] > root.rightBound) {
                res.add(interval);
            } else {
                update(root, interval);
            }
        }
        
        res.add(new int[]{root.leftBound, root.rightBound});
        return res;
        
    }
    
    private TreeNode add(TreeNode root, int[] interval) {
        // base case
        if(root == null) {
            return new TreeNode(interval[0], interval[1]);
        }
        
        if(interval[1] < root.leftBound) {
            root.left = add(root.left, interval);
        } else if(interval[0] > root.rightBound) {
            root.right = add(root.right, interval);
        } else {
            update(root, interval);
        }
        return root;
    }
    
    
    
    private void update(TreeNode root, int[] interval) {
        root.leftBound = Math.min(root.leftBound, interval[0]);
        root.rightBound = Math.max(root.rightBound, interval[1]);
    }
}

// 1. sort
// 2. tree to store intervals

// interval[1] < leftBound: add to left subtree
// interval[0] > rightBound: add to right subtree
// else update current root


class TreeNode {
    public int leftBound;
    public int rightBound;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int leftBound, int rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }
}