import java.util.ArrayList;
import java.util.List;


public class Demo1{



  public static void main(String[] args) {
    final List<String> list=new ArrayList<String>();

    //消费者1
    Thread sub1=new Thread(new Runnable() {
      public void run() {
        try{
          synchronized (list){
            while(true){
              while(list.size()==0){
                list.wait();
              }
              System.out.println("list.remove ->"+list.get(0)+",threadName->"+
                  Thread.currentThread().getName());
              list.remove(0);
              list.notifyAll();
            }
          }
        }catch (InterruptedException e){
          System.out.println(e.getMessage());
        }
      }
    },"sub1");
    sub1.start();

    //消费者2
    Thread sub2=new Thread(new Runnable() {
      public void run() {
        try{
          synchronized (list){
            while(true){
              while(list.size()==0){
                list.wait();
              }
              System.out.println("list.remove ->"+list.get(0)+",threadName->"+
                  Thread.currentThread().getName());
              list.remove(0);
              list.notifyAll();
            }
          }
        }catch (InterruptedException e){
          System.out.println(e.getMessage());
        }
      }
    },"sub2");
    sub2.start();


    //生产者
    Thread addThread=new Thread(new Runnable() {
      public void run() {
        for(int i=0;i<5;i++) {
          try {
            synchronized (list) {
              list.add(i+"");
              System.out.println("添加元素->"+i+",threadName->"+Thread.currentThread().getName());
              Thread.sleep(1000);
              list.notifyAll();
              list.wait();
            }
          }catch (InterruptedException e){
            e.printStackTrace();
          }
        }
      }
    },"producer");
    addThread.start();
  }
}
