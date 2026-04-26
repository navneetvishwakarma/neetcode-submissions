class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        
        List<List<Character>> blocks = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            blocks.add(new ArrayList<Character>());
        }
        for(int i = 0; i < board.length; i++) {
            
            char[] row = board[i];
            if (!isValidSet(row)) return false;
            
            char[] column = new char[len];
            for(int j = 0; j < board.length; j++) {
                column[j] = board[j][i];

                // populate blocks
                int blockIndex = (3 * (i/3)) + (j/3);
                List<Character> block = blocks.get(blockIndex);
                block.add(board[i][j]);
            }
            if (!isValidSet(column)) return false;
        }

        for (List<Character> block : blocks) {
            char[] set = new char[block.size()];
            for(int i = 0; i < block.size(); i++) {
                set[i] = block.get(i);
            }
            if (!isValidSet(set)) return false;
        }
        return true;
    }

    private boolean isValidSet(char[] set) {
        int[] found = new int[set.length];
        for(int i = 0; i < set.length; i++) {
            if (set[i] != '.') {
                int index = Character.getNumericValue(set[i]) - 1;
                if (found[index] > 0) return false;
                found[index] = 1;
            }
        }
        return true;
    }
}
