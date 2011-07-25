
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author liumin 
 */
public class IPconv 
{
	 //此处将32位十六进制数分成4个2字节的数，因为long型只有32位，会溢出
	public static String long2ip(String  iplong)
    {  
		String iplong1=iplong.substring(2,4);//提取十六进制的高两位
		long ip1= Integer.valueOf(iplong1, 16);//将高两位转化为十进制
		String iplong2=iplong.substring(4,6);
		long ip2= Integer.valueOf(iplong2, 16);
		String iplong3=iplong.substring(6,8);
		long ip3= Integer.valueOf(iplong3, 16);
		String iplong4=iplong.substring(8,10);//提取最低两位
		long ip4= Integer.valueOf(iplong4, 16);
		String ipInfo; //设置新的字符串用于保存上步操作结果
		ipInfo=Long.toString(ip1,10)+'.'+Long.toString(ip2,10)+'.'+Long.toString(ip3,10)+'.'+Long.toString(ip4,10); 
		return ipInfo;//返回函数值
    }
	

	public static void main(String[] args)//主函数，一般放到最后
   {
      try 
      {
         FileReader read = new FileReader("F:/net1.txt");//准备文件
         BufferedReader br = new BufferedReader(read);//用字符流获取文件
         PrintStream out = new PrintStream(new FileOutputStream("F://Out.txt"));//输出到文件
         String iplong;
         while((iplong = br.readLine())!=null) //逐行读取
         {
             System.out.println(long2ip(iplong));//函数调用
             String flag=long2ip(iplong);
             out.println(flag);
          }
       }
      //
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      } 
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }  
   
}
