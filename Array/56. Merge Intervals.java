**********************************Optimal Solution***************************************

class Solution {
    public int[][] merge(int[][] intervals) {
        //Brute Force Approach
        List<int[]> res=new ArrayList<int[]>();

        if(intervals.length==0 || intervals==null) return res.toArray(new int[0][0]);

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int[] i: intervals)
        {
            if(i[0]<=end)
            {
                end=Math.max(end,i[1]);
            }
            else{

                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }

        res.add(new int[]{start,end});
        return res.toArray(new int[0][0]);

    }
}

Time Complexity: O(NlogN) + O(N). O(NlogN) for sorting and O(N) for traversing through the array.

Space Complexity: O(N) to return the answer of the merged intervals.