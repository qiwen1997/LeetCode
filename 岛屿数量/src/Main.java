/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/**
 * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
 * 在深度优先搜索过程中，每个访问过的结点被标记为 0。
 * 计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/dao-yu-shu-liang-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {

    public void dfs(char[][] grid,int r,int c){
        int nr=grid.length;
        int nc=grid[0].length;
        if(r>(nr-1)||c>(nc-1)||r<0||c<0||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public int numIslands(char[][] grid) {

        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    sum++;
                    dfs(grid,i,j);
                }
            }
        }
        return sum;

    }
}