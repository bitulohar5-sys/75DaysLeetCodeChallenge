import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        long totalArea = 0;

        Set<String> set = new HashSet<>();

        for (int[] r : rectangles) {

            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            totalArea += (long) (x2 - x1) * (y2 - y1);

            String[] corners = {
                x1 + "," + y1,
                x1 + "," + y2,
                x2 + "," + y1,
                x2 + "," + y2
            };

            for (String corner : corners) {
                if (!set.add(corner)) {
                    set.remove(corner);
                }
            }
        }

        long expectedArea =
            (long) (maxX - minX) * (maxY - minY);

        if (totalArea != expectedArea) {
            return false;
        }

        Set<String> expectedCorners = new HashSet<>();

        expectedCorners.add(minX + "," + minY);
        expectedCorners.add(minX + "," + maxY);
        expectedCorners.add(maxX + "," + minY);
        expectedCorners.add(maxX + "," + maxY);

        return set.equals(expectedCorners);
    }
}