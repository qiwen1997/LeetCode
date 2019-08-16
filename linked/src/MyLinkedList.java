import java.util.HashMap;

public class MyLinkedList {

  Node head=null;

  /**
   * 链表添加结点
   * 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
   * @param data
   */
  public void addNode(int data){
    Node node=new Node(data);
    if(head==null){
      head=node;
      return;
    }
    Node temp=head;
    while(temp.next!=null) {
        temp = temp.next;
    }
    temp.next=node;
  }

  /**
   * 输出
   */
  public void printLink(){
    Node curNode=head;
    while(curNode!=null){
      System.out.print(curNode.data+" ");
      curNode=curNode.next;
    }
    System.out.println();
  }

  /**
   * 求链表的长度
   * @return
   */
  public int length(){
    int length=0;
    Node temp=head;
    while(temp!=null){
      length++;
      temp=temp.next;
    }
    return length;
  }

  /**
   * 链表删除结点
   * 把要删除结点的前结点指向要删除结点的后结点，即直接跳过待删除结点
   * @param index
   * @return
   */
  public boolean deleteNode(int index){
    if(index<1||index>length()){
      return false;
    }
    if(index==1){
      head=head.next;
      return true;
    }
    Node preNode=head;
    Node curNode=preNode.next;
    for(int i=1;i<index-1;i++){
      preNode=preNode.next;
      curNode=curNode.next;
    }
    preNode.next=curNode.next;
    return true;
  }

  /**
   * 链表结点排序，并赶回排序后的头结点
   * 选择排序算法，即每次都选出未排序结点中最小的结点，与第一个未排序结点交换
   * @return
   */
  public Node linkSort(){
    Node curNode=head;
    while(curNode!=null){
      Node nextNode=curNode.next;
      while(nextNode!=null){
        if(curNode.data>nextNode.data){
          int temp=curNode.data;
          curNode.data=nextNode.data;
          nextNode.data=temp;
        }
        nextNode=nextNode.next;
      }
      curNode=curNode.next;
    }
    return head;
  }

  /**
   * 去掉重复元素
   * 需要额外的存储空间HashMap，调用hashMap.containKey()来判断重复结点
   */
  public void distincLink(){
    Node temp=head;
    Node pre=null;
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    while(temp!=null){
      if(hashMap.containsKey(temp.data)){
        pre.next=temp.next;
      }else{
        hashMap.put(temp.data,1);
        pre=temp;
      }
      temp=temp.next;
    }
  }

  /**
   * 返回倒数第k个结点
   * 两个指针，第一个指针向前移动k-1次，之后两个指针共同前进
   * 当前面的指针到达末尾是，后面的指针所在的位置就是倒数第k个位置
   * @param k
   * @return
   */
  public Node findReverNode(int k){
    if(k<1||k>length()){
      return null;
    }
    Node first=head;
    Node second=head;
    for(int i=0;i<k-1;i++){
      first=first.next;
    }
    while(first.next!=null){
      first=first.next;
      second=second.next;
    }
    return second;
  }

  /**
   * 反转链表
   * 先保留下一个结点，之后再指针反转，将两个结点后移一步
   */
  public void reserveLink(){
    Node curNode=head;
    Node preNode=null;
    while (curNode!=null){
      Node nextNode=curNode.next;//保留下一个结点
      curNode.next=preNode;//指针反转
      preNode=curNode;//前结点后移
      curNode=nextNode;//后结点后移
    }
    head=preNode;
  }

  /**
   * 反向输出链表，三种方式：
   * 方法一、先反转链表，再输出链表，需要链表遍历两次
   * 方法二、把链表中的数字放入栈中再输出，需要维护额外的栈空间
   * 方法三、依据方法二中栈的思想，通过递归来实现，递归其实就是将先执行的数据压入栈中，再全部出栈
   * @param node
   */
  public void reservePrt(Node node){
    if(node!=null){
      reservePrt(node.next);
      System.out.print(node.data+" ");
    }
  }

  /**
   * 寻找单链表的中间结点；
   * 方法一，先求出链表的长度，再遍历1/2链表长度，寻找出链表的中间结点
   * 方法二:
   * 用两个指针遍历链表，一个快指针，一个慢指针
   * 快指针每次向前移动2个结点，慢指针一次向前移动1个结点
   * 当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置
   * @return
   */
  public Node findMiddleNode(){
    Node slowPoint=head;
    Node quickPoint=head;

    /**
     * quickPoint.next==null是链表结点个数为奇数时，快指针已经走到最后了
     * quickPoint.next.next==null是链表结点数为偶数时，快指针已经走到倒数第二个结点了
     * 链表结点个数为奇数时，返回的是中间结点；偶数时，返回的是中间两个中前面的一个
     */
    while(quickPoint.next!=null&&quickPoint.next.next!=null){
      slowPoint=slowPoint.next;
      quickPoint=quickPoint.next.next;
    }
    return slowPoint;
  }

  /**
   * 判断链表是否有环；
   * 设置快指针和慢指针，慢指针每次走一步，快指针每次走两步
   * 当快指针与慢指针相等时，就说明该链表有环
   * @return
   */
  public boolean isRinged(){
    if(head==null){
      return false;
    }
    Node slow=head;
    Node fast=head;
    while(fast.next!=null&&fast.next.next!=null){
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast){
        return true;
      }
    }
    return false;
  }

  /**
   * 寻找有环链表的环入口
   * 当快指针和慢指针相遇后，慢指针从头开始一步一步走，快指针在相遇点开始一步一步走
   * 再次相遇后，相遇点为入口
   * @return
   */
  public Node findEntrance() {
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    slow=head;
    while(slow!=fast){
      slow=slow.next;
      fast=fast.next;
    }
    return slow;
  }

  /**
   * 在不知道头结点的情况下删除指定结点
   * 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过删除结点
   * 1.如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
   * 2.如果删除的结点不是尾结点，则将该结点的值与下一个结点交换，
   * 然后将该结点的指针指向下一个结点的后续结点
   * @param n
   * @return
   */
  public boolean deleteSpeciaNode(Node n){
    if(n.next==null){
      return false;
    }else{
      int temp=n.data;
      n.data=n.next.data;
      n.next.data=temp;
      n.next=n.next.next;
      return true;
    }
  }

  /**
   * 判断两个链表是否相交；
   * 两个链表相交，则他们的尾结点一定相同，比较两个链表的尾结点
   * @param head1
   * @param head2
   * @return
   */
  public boolean isCross(Node head1,Node head2){
    Node temp1=head1;
    Node temp2=head2;
    while(temp1.next!=null){
      temp1=temp1.next;
    }
    while(temp2.next!=null){
      temp2=temp2.next;
    }
    if(temp1==temp2){
      return true;
    }
    return false;
  }

  /**
   * 如果链表相交，求链表相交的起始点
   * 1.首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
   * 2.求出两个链表长度：len=length1-length2
   * 3.让较长的链表先走len步
   * 4.然后连个链表同步向前移动，每次移动都比较结点,第一个相等的结点为相交起始点
   * @param linkedList1
   * @param linkedList2
   * @return
   */
  public Node findFirstCrossPoint(MyLinkedList linkedList1,MyLinkedList linkedList2){
    if(!isCross(linkedList1.head,linkedList2.head)){
      return null;
    }
    int length1=linkedList1.length();
    int length2=linkedList2.length();
    int len=length1-length2;
    Node temp1=linkedList1.head;
    Node temp2=linkedList2.head;
    if(len>0){
      for(int i=0;i<len;i++){
        temp1=temp1.next;
      }
    }else{
      len=0-len;
      for(int i=0;i<len;i++){
        temp2=temp2.next;
      }
    }
    while(temp1!=temp2){
      temp1=temp1.next;
      temp2=temp2.next;
    }
    return temp1;
  }
}
