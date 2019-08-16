import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/**
 * Java递归回溯
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        addElement(candidates, list, sum, target,0);
        return res;

    }

    private void addElement(int[] candidates, List<Integer> list, int sum, int target,int index) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++
        ) {
            List<Integer> t_list = new ArrayList<>(list);
            t_list.add(candidates[i]);
            addElement(candidates, t_list, sum + candidates[i], target,i);
        }

    }
}
