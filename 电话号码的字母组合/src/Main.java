import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.letterCombinations("23").toString());
    }

}
class Solution {

    String[] zimu={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    StringBuffer stringBuffer=new StringBuffer();

    public List<String> letterCombinations(String digits) {

        List<String> answer=new ArrayList<>();
        if(digits.length()==0){
            return answer;
        }
        //List<String> answer=new ArrayList<>();
        zuhe(digits,0,answer);
        return answer;
    }

    public void zuhe(String digits,int n,List<String> answer){
        if(n==digits.length()){
            answer.add(stringBuffer.toString());
            return;
        }
        for(int i=0;i<zimu[digits.charAt(n)-'0'].length();i++){
            stringBuffer.append(zimu[digits.charAt(n)-'0'].charAt(i));
            zuhe(digits,n+1,answer);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
}
