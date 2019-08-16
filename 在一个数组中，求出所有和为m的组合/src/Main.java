/**
 *在长度为n的单调递增型数组a[n]中，1 <= a[i] <= 100，编写一个程序打印出和为m的所有组合。
 *
 * 例如：a[] = {1,2,3,5,6},m=11，打印出
 * 5 6
 * 2 3 6
 * 1 2 3 5
 *
 * 每个位置的数只有选和不选两种情况，可以用0,1表示
 * 比如 00011 则表示例的数组{1,2,3,5,6}中选了5和6，那么计算结果就是11
 * 所以解决这题的方法可以穷举出所有n(数组长度)位的二进制数，并且把当前位置为1的数相加计算，结果为m即可
 */
public class Main {

    public static void binaryCal(int[] a,int m) {
        int n = a.length;
        //最大的数为2的n次方
        int max = 1 << n;
        for(int i = 1;i < max;i++) {
            //转成二进制数
            String binaryNum = Integer.toBinaryString(i);
            //转成相同的位数，不足n位的在前补0
            binaryNum = toSameLen(binaryNum,n);
            char[] bitNum = binaryNum.toCharArray();
            int sum = 0;
            for(int j = 0;j < bitNum.length;j++) {
                //二进制数当前位置为1，则加起来
                if (bitNum[j] == '1') {
                    sum += a[j];
                }
                if(sum>m){
                    break;
                }
            }
            //和为m了，输出
            if (sum == m) {
                output(bitNum,a);
            }
        }
    }
    private static String toSameLen(String binaryNum, int len) {
        //数的长度
        int numLen = binaryNum.length();
        if (numLen == len) {
            return binaryNum;
        }
        StringBuilder sb = new StringBuilder();
        //差几位补几个0
        for(int i = 0;i < len - numLen;i++) {
            sb.append(0);
        }
        return sb.append(binaryNum).toString();
    }
    private static void output(char[] bitNum, int[] a) {
        for(int i = 0;i < bitNum.length;i++) {
            if (bitNum[i] == '1') {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
    }
}
