import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class LRUSample<K,V> extends LinkedHashMap<K,V> {

  public LRUSample() {
    super();
  }

  int MAX_CACHE=3;

  @Override
  protected boolean removeEldestEntry(Entry<K, V> eldest) {
    if(size()<=MAX_CACHE){
      return false;
    }else{
      return true;
    }
  }

  public static void main(String[] args) {
    LRUSample<Integer,String> cache=new LRUSample<>();

    List<Integer> list=new ArrayList<Integer>();
    list.add(1); list.add(2); list.add(3); list.add(1); list.add(3);
    list.add(2); list.add(4); list.add(1); list.add(3); list.add(2);
    list.add(1); list.add(5); list.add(1);

    for(Integer key:list){
      cache.put(key,"value");
    }
    for(Entry<Integer,String> e:cache.entrySet()){
      System.out.println(e.getKey());
    }
  }

  public ThreadPoolExecutor(int corePoolSize, // 1
      int maximumPoolSize,  // 2
      long keepAliveTime,  // 3
      TimeUnit unit,  // 4
      BlockingQueue<Runnable> workQueue, // 5
      ThreadFactory threadFactory,  // 6
      RejectedExecutionHandler handler ) { //7
    if (corePoolSize < 0 ||
        maximumPoolSize <= 0 ||
        maximumPoolSize < corePoolSize ||
        keepAliveTime < 0)
      throw new IllegalArgumentException();
    if (workQueue == null || threadFactory == null || handler == null)
      throw new NullPointerException();
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.workQueue = workQueue;
    this.keepAliveTime = unit.toNanos(keepAliveTime);
    this.threadFactory = threadFactory;
    this.handler = handler;
  }
}
