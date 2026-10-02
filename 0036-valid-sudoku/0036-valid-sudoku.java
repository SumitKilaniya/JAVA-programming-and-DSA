class Solution {
    public boolean isValidSudoku(char[][] boards) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxs = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (boards[i][j] == '.') continue;

                int val = boards[i][j] - '1';
                int ra = 3 * (i / 3) + (j / 3);

                if (rows[i][val] == 1 || cols[j][val] == 1 || boxs[ra][val] == 1) return false;

                rows[i][val] = 1;
                cols[j][val] = 1;
                boxs[ra][val] = 1;
            }
        }
        return true;
    }
}