class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char currentVal = board[i][j];

                // Skip empty cells
                if(currentVal ==  '.'){
                    continue;
                }

                // Convert char '1'-'9' to index 0-8
                int num = currentVal - '1';

                // Calculate the 3x3 box index (0 to 8)
                int boxIndex = (i/3) * 3 + (j/3);

                // Check if the number already exists in the current row,
                // or box
                if(rows[i][num] || cols[j][num] || boxes[boxIndex][num]){
                    return false;
                }
                // Mark the number as seen
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}
