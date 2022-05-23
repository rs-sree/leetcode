class Solution {
public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length, res =0;
        int[][] mat = new int[n][3];
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            mat[i][0]=startTime[i];
            mat[i][1]=endTime[i];
            mat[i][2]=profit[i];
        }
        
        Arrays.sort(mat,(a,b)->{
		//If two jobs have same starting time, then choose job that ends before.
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        for(int i=n-1;i>=0;i--){
            int j = ceil(mat,mat[i][1],i+1,n-1);
			/*
			Choose best option between 
			1.Exclude current job and looking for max profit from next index OR
			2.Include current job and add max profit from the first interval that 
			doesnot overlap with current ending interval.
			*/
            dp[i] = Math.max( (i+1 <n ? dp[i+1] : 0) ,mat[i][2]+ ((j==-1)?0:dp[j]));
            res=Math.max(res,dp[i]);
        }
        
        return res;
    }
    
    private int ceil(int[][] mat, int val,int start, int end){
        if(start>end || val> mat[end][0]) return -1;
        if(start==end) return (val<=mat[start][0])?start:-1;
        int mid;
        while(start<=end){
            mid= start+ (end-start)/2;
            if(val==mat[mid][0]) return mid;
            else if(val>mat[mid][0]) start= mid+1;
            else end=mid-1;
        }
        return start;
    }
}