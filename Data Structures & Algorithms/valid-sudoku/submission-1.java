class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> blocks = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') continue;
                if (rows.computeIfAbsent(i, k -> new HashSet<Character>()).contains(board[i][j])) return false;
                if (cols.computeIfAbsent(j, k -> new HashSet<Character>()).contains(board[i][j])) return false;
                String key = i/3 + "," + j/3;
                if (blocks.computeIfAbsent(key, k -> new HashSet<Character>()).contains(board[i][j])) return false;
            
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                blocks.get(key).add(board[i][j]);
            }
        }
        return true;
    }

}
