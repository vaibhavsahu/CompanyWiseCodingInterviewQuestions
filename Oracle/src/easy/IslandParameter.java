package easy;
//https://leetcode.com/problems/island-perimeter/
public class IslandParameter {
    public int islandPerimeter(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int parameter = 0;
        for(var i = 0; i < grid.length; i++){
            for(var j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    parameter += helper(grid, visited, i, j);
                }
            }
        }
        return parameter;
    }

    public int helper(int [][] grid, boolean [][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        }

        if(visited[i][j]) return 0;

        visited[i][j] = true;

        int edgeCount = 0;

        edgeCount += helper(grid, visited, i+1, j);
        edgeCount += helper(grid, visited, i-1, j);
        edgeCount += helper(grid, visited, i, j+1);
        edgeCount += helper(grid, visited, i, j-1);

        return edgeCount;
    }
}
