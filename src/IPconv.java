
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
	 //�˴���32λʮ���������ֳ�4��2�ֽڵ�������Ϊlong��ֻ��32λ�������
	public static String long2ip(String  iplong)
    {  
		String iplong1=iplong.substring(2,4);//��ȡʮ�����Ƶĸ���λ
		long ip1= Integer.valueOf(iplong1, 16);//������λת��Ϊʮ����
		String iplong2=iplong.substring(4,6);
		long ip2= Integer.valueOf(iplong2, 16);
		String iplong3=iplong.substring(6,8);
		long ip3= Integer.valueOf(iplong3, 16);
		String iplong4=iplong.substring(8,10);//��ȡ�����λ
		long ip4= Integer.valueOf(iplong4, 16);
		String ipInfo; //�����µ��ַ������ڱ����ϲ��������
		ipInfo=Long.toString(ip1,10)+'.'+Long.toString(ip2,10)+'.'+Long.toString(ip3,10)+'.'+Long.toString(ip4,10); 
		return ipInfo;//���غ���ֵ
    }
	

	public static void main(String[] args)//��������һ��ŵ����
   {
      try 
      {
         FileReader read = new FileReader("F:/net1.txt");//׼���ļ�
         BufferedReader br = new BufferedReader(read);//���ַ�����ȡ�ļ�
         PrintStream out = new PrintStream(new FileOutputStream("F://Out.txt"));//������ļ�
         String iplong;
         while((iplong = br.readLine())!=null) //���ж�ȡ
         {
             System.out.println(long2ip(iplong));//��������
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
