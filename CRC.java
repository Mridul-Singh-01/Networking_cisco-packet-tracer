import java.util.*;  
class CRC{  
    public static void main(String args[]) {  
        Scanner scan = new Scanner(System.in);  
        int size;  
        System.out.println("Enter the size of the data array: ");  
        size = scan.nextInt();  
        int data[] = new int[size];  
        System.out.println("Enter data bits in the array one by one: ");  
        for(int i = 0 ; i < size ; i++) {  
            System.out.println("Enter bit " + (1+i) + ":");  
            data[i] = scan.nextInt();  
        }  
        System.out.println("Enter the size of the divisor array:");  
        size = scan.nextInt();  
        int divisor[] = new int[size];  
        System.out.println("Enter divisor bits in the array one by one: ");  
        for(int i = 0 ; i < size ; i++) {  
            System.out.println("Enter bit " + (1+i) + ":");  
            divisor[i] = scan.nextInt();  
        }  
        int rem[] = divideDataWithDivisor(data, divisor);  
        for(int i = 0; i < rem.length-1; i++) {  
            System.out.print(rem[i]);  
        }  
        System.out.println("\nGenerated CRC code is: ");  
        for(int i = 0; i < rem.length-1; i++) {  
            System.out.print(rem[i]);  
        }  
        System.out.println("\nData + CRC Code is :"); 
        for(int i = 0; i < data.length; i++) {  
            System.out.print(data[i]);  
        } 
        for(int i = 0; i < rem.length-1; i++) {  
            System.out.print(rem[i]);  
        }  
        System.out.println(); 
        scan.close(); 
    }
    static int[] divideDataWithDivisor(int oldData[], int divisor[]) {  
        int rem[] = new int[divisor.length];  
        int i;  
        int data[] = new int[oldData.length + divisor.length];  
        System.arraycopy(oldData, 0, data, 0, oldData.length);  
        System.arraycopy(data, 0, rem, 0, divisor.length);  
        for(i = 0; i < oldData.length; i++) {  
            System.out.println((i+1) + ".) First data bit is : "+ rem[0]);  
            System.out.print("Remainder : ");  
            if(rem[0] == 1) {  
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], divisor[j]);  
                    System.out.print(rem[j-1]);  
                }  
            }  
            else {  
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], 0);  
                    System.out.print(rem[j-1]);  
                }  
            }  
            rem[divisor.length-1] = data[i+divisor.length];  
            System.out.println(rem[divisor.length-1]);  
        }  
        return rem;  
    }  
    static int exorOperation(int x, int y) {  
        if(x == y) {  
            return 0;  
        }  
        return 1;  
    }  
}  