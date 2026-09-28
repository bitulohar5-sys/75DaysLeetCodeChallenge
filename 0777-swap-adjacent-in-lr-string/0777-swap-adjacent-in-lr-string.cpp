class Solution {
public:
    bool canTransform(string start, string end) {
        
        int n = start.length();

        int i = 0;
        int j = 0;

        while (i < n || j < n) {

            // Skip X in start
            while (i < n && start[i] == 'X') {
                i++;
            }

            // Skip X in end
            while (j < n && end[j] == 'X') {
                j++;
            }

            // Both strings finished
            if (i == n && j == n) {
                return true;
            }

            // Only one finished
            if (i == n || j == n) {
                return false;
            }

            // The non-X characters must be the same
            if (start[i] != end[j]) {
                return false;
            }

            // L can only move LEFT
            if (start[i] == 'L' && i < j) {
                return false;
            }

            // R can only move RIGHT
            if (start[i] == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
};