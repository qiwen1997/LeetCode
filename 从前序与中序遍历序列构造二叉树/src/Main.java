import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
 }

/**
 * 如上文所提到的，先序遍历的顺序是 Root -> Left -> Right，这就能方便的从根开始构造一棵树。
 *
 * 首先，preorder 中的第一个元素一定是树的根，这个根又将 inorder 序列分成了左右两棵子树。现在我们只需要将先序遍历的数组中删除根元素，然后重复上面的过程处理左右两棵子树
 *
 */
class Solution {

   int pre_ind=0;
   int[] preorder;
   int[] inorder;
   Map<Integer,Integer> map=new HashMap<>();

   public TreeNode build(int left,int right){

     if(left==right){
       return null;
     }
     TreeNode root=new TreeNode(preorder[pre_ind]);
     int index=map.get(preorder[pre_ind]);
     pre_ind++;
     root.left=build(left,index);
     root.right=build(index+1,right);
     return root;
   }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

     this.preorder=preorder;
     this.inorder=inorder;
     int index=0;
     for(Integer i:inorder){
       map.put(i,index++);
     }
     return build(0,inorder.length);
    }
}