public class array {

  public static int max(int a,int b){
    return a<b?a:b;
  }

  /**
   * 求最大子数组之和（子数组连续）
   * 动态规划法
   * @param arr
   * @return
   */
  public static int maxSubArray(int arr[]){
    int n=arr.length;
    int[] End=new int[n];
    int[] All=new int[n];
    End[n-1]=All[n-1]=arr[n-1];
    End[0]=All[0]=arr[0];
    for(int i=1;i<n;i++){
      End[i]=max(End[i-1]+arr[i],arr[i]);
      All[i]=max(End[i],All[i-1]);
    }
    return All[n-1];
  }

  public int maxnum(int a[],int begin){
    int length=a.length-begin;
    if(length==1){
      return a[begin];
    }else{
      return max(a[begin],maxnum(a,begin+1));
    }
  }

}
