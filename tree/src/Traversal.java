import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

  public static void main(String[] args) {
    TreeNode treeNode=new TreeNode(6);
    treeNode.left=new TreeNode(1);
    treeNode.left.right=new TreeNode(3);
    treeNode.right=new TreeNode(8);
    Traversal traversal=new Traversal();
    //traversal.preOrder(treeNode);

//    traversal.midSearch(treeNode);
//    System.out.println();
//    traversal.midOrder(treeNode);

//    traversal.posSearch(treeNode);
//    System.out.println();
//    traversal.posOrder(treeNode);

   // traversal.levelTrav(treeNode);

    //System.out.println(traversal.level(treeNode));
//    System.out.println(left);
//    System.out.println(right);

   // System.out.println(traversal.findLevel(treeNode));

//    TreeNode node=new TreeNode(8);
//    traversal.insert(6,node);
//    traversal.insert(7,node);
//    traversal.insert(9,node);
//
//    traversal.midSearch(node);

  }

  //前序递归
  public  void preSearch(TreeNode root){
    if(root !=null){
      System.out.print(root.val+" ");
      preSearch(root.left);
      preSearch(root.right);
    }
  }

  //中序递归
  public  void midSearch(TreeNode root){
    if(root !=null){
      midSearch(root.left);
      System.out.print(root.val+" ");
      midSearch(root.right);
    }
  }

  //后序递归
  public void posSearch(TreeNode root){
    if(root !=null){
      posSearch(root.left);
      posSearch(root.right);
      System.out.print(root.val+" ");
    }
  }

  /**
   * 前序非递归，从根开始先输出在把全部的左孩子压栈，
   * 然后出栈找右孩子，在把全部的左孩子压栈
   * @param root
   */
  public void preOrder(TreeNode root){
    Stack<TreeNode> stack=new Stack<>();
    while(root!=null||!stack.empty()){
      while(root!=null){
        System.out.print(root.val+" ");
        stack.push(root);
        root=root.left;
      }
      if(!stack.isEmpty()){
        root=stack.pop();
        root=root.right;
      }
    }
  }

  /**
   * 中序非递归，先把左孩子全部压栈，
   * 出栈一个输出然后找一个右孩子，然后再把左孩子全部压栈
   * @param root
   */
  public void midOrder(TreeNode root){
    Stack<TreeNode> stack=new Stack<>();
    while(root!=null||!stack.empty()){
      while(root!=null){
        stack.push(root);
        root=root.left;
      }
      if(!stack.isEmpty()){
        root=stack.pop();
        System.out.print(root.val+" ");
        root=root.right;
      }
    }
  }

  /**
   * 1申请两个栈s1，s2，头节点入栈s1
   * 2如果栈s1不为空，执行以下操作：弹出一个元素，入栈s2，如果该节点左孩子不空入栈s1，如果该节点右孩子不空入栈s1.
   * 3.将栈s2中的节点一次出栈，打印。
   * @param root
   */
  public void posOrder(TreeNode root){
    if(root==null){
      return;
    }
    Stack<TreeNode> stack1=new Stack<>();
    Stack<TreeNode> stack2=new Stack<>();
    stack1.push(root);
    while(!stack1.isEmpty()){
      TreeNode node=stack1.pop();
      stack2.push(node);
      if(node.left!=null){
        stack1.push(node.left);
      }
      if(node.right!=null){
        stack2.push(node.right);
      }
    }
    while(!stack2.isEmpty()){
      TreeNode node2=stack2.pop();
      System.out.print(node2.val+" ");
    }

  }

  /**
   * 层序遍历
   * 用一个队列，先把头结点放进去，循环中先输出再看队列第一个元素有没有左右孩子
   * 有就放进去，之后出队
   * @param root
   */
  public void levelTrav(TreeNode root){
    if(root==null){
      return;
    }
    Queue<TreeNode> queue=new ArrayDeque<>();
    queue.add(root);
    TreeNode cur;
    while(!queue.isEmpty()){
      cur=queue.peek();
      System.out.print(cur.val+" ");
      if(cur.left!=null){
        queue.add(cur.left);
      }
      if(cur.right!=null){
        queue.add(cur.right);
      }
      queue.poll();
    }
  }

//  static int left=0;
//  static int right=0;
  /**
   * 计算二叉树深度
   * 递归实现
   * @param root
   * @return
   */
  public int level(TreeNode root){
    if(root==null){
      return 0;
    }
    int left = level(root.left);
    int right = level(root.right);
    return Math.max(left,right)+1;

  }

  /**
   * 求二叉树深度非递归
   * 层序遍历思想
   * @param root
   * @return
   */
  public int findLevel(TreeNode root){
    if(root==null){
      return 0;
    }
    Queue<TreeNode> queue=new ArrayDeque<>();
    queue.add(root);
    int level=0;
    int cur,last;
    while(!queue.isEmpty()){
      cur=0;//记录本层已经遍历的节点个数
      last=queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
      while(cur<last){
        TreeNode node=queue.poll();
        cur++;
        if(node.left!=null){
          queue.add(node.left);
        }
        if(node.right!=null){
          queue.add(node.right);
        }
      }
      level++;
    }
    return level;
  }

  /**
   * 实现二叉排序树
   * 一个前结点，一个当前结点
   * 判断大小向左或者右走，走到null插入
   * @param data
   * @param root
   */
  public void insert(int data,TreeNode root){
    TreeNode newNode=new TreeNode(data);
    if(root==null){
      root=newNode;
    }else{
      TreeNode current=root;
      TreeNode parent;
      while(true){
        parent=current;
        if(data<current.val){
          current=current.left;
          if(current==null){
            parent.left=newNode;
            return;
          }
        }else{
          current=current.right;
          if(current==null){
            parent.right=newNode;
            return;
          }
        }
      }
    }
  }

  /**
   * 判断树是否对称（递归）
   * @param r1
   * @param r2
   * @return
   */
  public  boolean isSymmetrical(TreeNode r1, TreeNode r2) {
    if (r1 == null&&r2 == null)
      return true;
    if (r1 == null||r2 == null)
      return false;
    return r1.val==r2.val&&isSymmetrical(r1.left,r2.right)&&isSymmetrical(r1.right,r2.left);
  }

  /**
   * 判断树是否对称（非递归）
   * 利用栈，先把根的左右子树压栈
   * 进入循环，取出左右子树判断
   * 把左子树的左节点与右子树的右节点，左子树的右节点与右子树的左节点成对压栈
   * @param root
   * @return
   */
  public boolean Symmetrical(TreeNode root){
    boolean result=true;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.isEmpty()) {
      TreeNode right = stack.pop();
      TreeNode left = stack.pop();
      if (right == null && left == null) {
        continue;
      }
      if (right == null || left == null) {
        result = false;
        break;
      }

      if (right.val!=left.val) {
        result = false;
        break;
      }
      stack.push(left.right);
      stack.push(right.left);
      stack.push(left.left);
      stack.push(right.right);
    }
    return result;
  }

}
