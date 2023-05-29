import java.util.*;
public class HammingCode
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of bits of the message");
        int n=Integer.parseInt(sc.nextLine());
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter bit number "+(i+1));
            a[i]=Integer.parseInt(sc.nextLine());
        }
        int r=1;
        while(Math.pow(2,r)<(n+r+1))
        {
            r++;
        }
        int b[]=new int[n+r];
        int k=0;
        while(Math.pow(2,k)<(n+r))
        {
            k++;
        }
        k--;
        int t=n;
        for(int i=0;i<(n+r);i++)
        {
            int flag=0;
            for(int j=0;j<=k;j++)
            {
                if(i==Math.pow(2,j)-1)
                flag=1;
            }
            if(flag==0)
            b[i]=a[--t];
        }
        t=k;
        for(int i=0;i<=k;i++)
        {
            int c=0;
            
            for(int j=(int)Math.pow(2,i);j<=(n+r);j++)
            {
                String ch=Integer.toBinaryString(j);
                if(Integer.toBinaryString(j).length()<Integer.toBinaryString(n+r).length())
                {
                    for(int l=Integer.toBinaryString(n+r).length();l>=ch.length();l--)
                    ch="0"+ch;
                }
                
                if(ch.substring(ch.length()-i-1,ch.length()-i).equals("1")&&b[j-1]==1)
                {
                    
                    c++;
                }
                
            }
            
            if(c%2==0)
            b[(int)Math.pow(2,i)-1]=0;
            else
            b[(int)Math.pow(2,i)-1]=1;
            
        }
        for(int i=n+r-1;i>=0;i--)
        {
            System.out.print(b[i]+" ");
        }
    }
}