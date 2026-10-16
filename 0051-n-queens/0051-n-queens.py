class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        ans = []
        board = [["."] * n for _ in range(n)]
        cols = set()    # Tracks occupied columns
        diag = set()    # Tracks occupied row - col diagonals
        anti = set()    # Tracks occupied row + col diagonals

        def dfs(row):
            if row == n:
                temp = []
                for r in board:
                    temp.append("".join(r))
                ans.append(temp)
                return

            for col in range(n):
                if (col in cols or row - col in diag or row + col in anti):
                    continue

                board[row][col] = "Q"
                cols.add(col)
                diag.add(row - col)
                anti.add(row + col)

                dfs(row + 1)

                board[row][col] = "."
                cols.remove(col)
                diag.remove(row - col)
                anti.remove(row + col)

        dfs(0)
        return ans