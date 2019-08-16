public class Test {

  public static void main(String[] args) {
    MyLinkedList myLinkedList=new MyLinkedList();
    myLinkedList.addNode(8);
    myLinkedList.addNode(6);
    myLinkedList.addNode(7);
    myLinkedList.addNode(9);
    myLinkedList.addNode(6);
    myLinkedList.addNode(6);
    myLinkedList.addNode(4);

    //删除结点
    //System.out.println(myLinkedList.deleteNode(1));

    //排序
    //myLinkedList.linkSort();

    //去重
    //myLinkedList.distincLink();

    //倒数第k个
    //System.out.println(myLinkedList.findReverNode(7).data);

    //反转链表
    //myLinkedList.reserveLink();

    //反向输出
    //myLinkedList.reservePrt(myLinkedList.head);
    //System.out.println();

    //寻找中间结点
    //System.out.println(myLinkedList.findMiddleNode().data);

    //判断有环
//    myLinkedList.head.next.next.next.next.next=myLinkedList.head.next.next;
//    System.out.println(myLinkedList.isRinged());
    //寻找环入口
//    System.out.println(myLinkedList.findEntrance().data);

    //不知头结点删除结点
//    Node node=myLinkedList.head.next.next;
//    myLinkedList.deleteSpeciaNode(node);

    //相交测试
//    MyLinkedList myLinkedList2=new MyLinkedList();
//    myLinkedList2.addNode(5);
//    myLinkedList2.addNode(4);
//    myLinkedList2.head.next=myLinkedList.head.next.next.next;
//    System.out.println(myLinkedList.isCross(myLinkedList.head,myLinkedList2.head));
     //寻找相交点
//    System.out.println(myLinkedList.findFirstCrossPoint(myLinkedList,myLinkedList2).data);

    //输出测试
    myLinkedList.printLink();
    //myLinkedList2.printLink();
  }

  public static int[] ShellSort(int[] array) {
    int len = array.length;
    if(len == 0)
      return array;
    int current, gap = len / 2;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        current = array[i];
        int preIndex = i - gap;
        while (preIndex >= 0 && array[preIndex] > current) {
          array[preIndex + gap] = array[preIndex];
          preIndex -= gap;
        }
        array[preIndex + gap] = current;
      }
      gap /= 2;
    }
    return array;
  }
}
