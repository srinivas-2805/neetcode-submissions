class Solution {

    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public void islandsAndTreasure(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        
        while (!queue.isEmpty()) {

            int[] treasure = queue.poll();

            int row = treasure[0];
            int col = treasure[1];

            
            for (int i = 0; i < 4; i++) {

                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == INF) {
                    grid[newRow][newCol] = grid[row][col] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}