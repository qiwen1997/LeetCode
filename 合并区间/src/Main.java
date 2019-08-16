import java.util.Arrays;
import java.util.Comparator;

/**
 *给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {


    }
}

/**
 * 按照左端点大小排序，能合并的就前面往后面合，前面合完的变-1
 * 统计合并次数，最后申请合适大小数组，把不是-1的放进去
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        int length=intervals.length;
        if(length<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int count=0;
        for(int i=0;i<length-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]&&
            intervals[i][0]<=intervals[i+1][0]){
                count++;
                intervals[i+1][0]=Math.min(intervals[i][0],intervals[i+1][0]);
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
                intervals[i][0]=-1;
                intervals[i][1]=-1;
            }
        }
        int[][] ret=new int[length-count][2];

        int j=0;
        for(int i=0;i<length;i++){
            if(intervals[i][0]!=-1){
                ret[j][0]=intervals[i][0];
                ret[j][1]=intervals[i][1];
                j++;
            }
        }
        return ret;

    }
}