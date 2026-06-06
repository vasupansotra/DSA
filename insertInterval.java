import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        int[][] newIntervalsList = new int[n + 1][2];
        
        // Purane saare intervals naye array me copy karo
        for (int i = 0; i < n; i++) {
            newIntervalsList[i] = intervals[i];
        }
        // Aakhri spot par naya interval daal do
        newIntervalsList[n] = newInterval;

        Arrays.sort(newIntervalsList,(a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        
        int start = newIntervalsList[0][0];
        int end = newIntervalsList[0][1];

        for (int i = 1; i < newIntervalsList.length; i++) {
            if (newIntervalsList[i][0] <= end) {
                // Overlap hai toh kheench kar end bada karo
                end = Math.max(end, newIntervalsList[i][1]);
            } else {
                // Gap hai toh purana result me save karo
                result.add(new int[]{start, end});
                start = newIntervalsList[i][0];
                end = newIntervalsList[i][1];
            }
        }
        // Aakhri bacha hua interval add karo
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}