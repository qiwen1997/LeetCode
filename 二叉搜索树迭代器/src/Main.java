import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

/**
 * 用栈实现中序遍历
 */
class BSTIterator {

    private Stack<TreeNode> stack=new Stack<>();

    public BSTIterator(TreeNode root) {

        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {

        int x=-1;
        if(!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            x=treeNode.val;
            if(treeNode.right!=null){
                treeNode=treeNode.right;
                while(treeNode!=null){
                    stack.push(treeNode);
                    treeNode=treeNode.left;
                }
            }
        }
        return x;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        if(stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */