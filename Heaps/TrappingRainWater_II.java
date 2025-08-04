class Solution {
        static class Cell {

        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }


    // level = hard
    // problem number = 407 on leetcode
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2) return 0; // water trap hi nahi ho sakta

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add boundary cells to heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up
        int trappedWater = 0;

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            for (int[] dir : dirs) {
                int ni = cell.row + dir[0];
                int nj = cell.col + dir[1];

                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    int neighborHeight = heightMap[ni][nj];
                    trappedWater += Math.max(0, cell.height - neighborHeight);

                    // Push updated neighbor into heap with max height (fence effect)
                    minHeap.offer(new Cell(ni, nj, Math.max(cell.height, neighborHeight)));
                }
            }
        }

        return trappedWater;
    }
}