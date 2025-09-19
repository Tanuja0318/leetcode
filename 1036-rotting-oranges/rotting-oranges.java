class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int time=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)
                    q.offer(new int[]{i, j});
            }
        }
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        while(q.size()>0 && fresh>0){
            int size=q.size();
            time++;
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                int x=curr[0],y=curr[1];
                for (int[] dir : directions) { 
                    int newx = x + dir[0];
                    int newy = y + dir[1];
                    if(newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]==1){
                        grid[newx][newy]=2;
                        fresh--;
                        q.offer(new int[]{newx,newy});
                    }
                }
            }
        }
        return fresh==0 ? time:-1;
    }
}