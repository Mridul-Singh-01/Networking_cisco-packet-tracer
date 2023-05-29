import java.util.Scanner;

class BitStuffing {
    static void bitStuffing(int N, char arr[])
    {  
        int[]arr2=new int[arr.length];
        for(int x=0;x<arr.length;x++){
            arr2[x]=Integer.parseInt(String.valueOf(arr[x]));
        }  
        int[] brr = new int[30];
        int i, j, k;
        i = 0;
        j = 0;
        while (i < N) {
            if (arr2[i] == 1)
            {
                int count = 1;
                 brr[j] = arr2[i];
                for (k = i + 1; k < N && arr2[k] == 1 && count < 5;k++) 
                {
                    j++;
                    brr[j] = arr2[k];
                    count++;
                    if (count == 5) 
                    {
                        j++;
                        brr[j] = 0;
                    }
                    i = k;
                }
            }
            else {
                brr[j] = arr2[i];
            }
            i++;
            j++;
        }
        for (i = 0; i < j; i++)
            System.out.printf("%d", brr[i]);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in); 
        int N;
        System.out.println("Enter the size of data");
        N=sc.nextInt();
        System.out.print("Enter the message data: ");  
        char[] arr = sc.next().toCharArray();
        bitStuffing(N, arr);
        sc.close();
    }
}