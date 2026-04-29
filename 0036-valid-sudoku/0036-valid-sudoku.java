import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                
                // ✅ Check Row
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                
                // ✅ Check Column
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
                
                // ✅ Check 3x3 Box
                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;
                
                if (board[r][c] != '.') {
                    if (box.contains(board[r][c])) return false;
                    box.add(board[r][c]);
                }
            }
        }
        
        return true;
    }
}