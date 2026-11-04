import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        // Convert time into minutes
        List<Integer> minutes = new ArrayList<>();

        for (String time : timePoints) {
            String[] parts = time.split(":");

            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            minutes.add(hour * 60 + minute);
        }

        // Sort the time points
        Collections.sort(minutes);

        int minDiff = 1440;

        // Compare adjacent time points
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(
                minDiff,
                minutes.get(i) - minutes.get(i - 1)
            );
        }

        // Compare last and first (circular difference)
        int circularDiff = 1440
                - minutes.get(minutes.size() - 1)
                + minutes.get(0);

        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}
