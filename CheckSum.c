#include<stdio.h>
#include<math.h>
int sender(int arr[10],int n)
{
    int cs,sum=0,i;
    printf("\n****SENDER SIDE****\n");
    for(i=0;i<n;i++){
        sum+=arr[i];
        printf("SUM IS: %d",sum);
    }
    cs=~sum;    
    printf("\ncs IS:%d",cs);
    return cs;
}

void receiver(int arr[10],int n,int sch)
{
    int cs,sum=0,i;
    printf("\n\n****RECEIVER SIDE****\n");
    for(i=0;i<n;i++){
        sum+=arr[i];
        printf("SUM IS:%d",sum);
    }
    sum=sum+sch;
    cs=~sum;
    printf("\ncs IS:%d",cs);
}

void main()
{
    int n,sch,rch;
    printf("\nENTER SIZE OF THE STRING:");
    scanf("%d",&n);
    int arr[n];
    printf("ENTER THE ELEMENTS OF THE ARRAY TO CALCULATE cs:\n");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    sch=sender(arr,n);
    receiver(arr,n,sch);
}

def checksum(data, bit):
    m = (1 << bit) - 1

    cs = 0
    while data > 0:
        cs += data & m
        data >>= bit


    cs = (cs & m) + (cs >> bit)


    r_cs = 0
    while cs > 0:
        r_cs <<= 1
        r_cs |= cs & 1
        cs >>= 1

    return bin(r_cs)


data = 0b100010001100
print("Checksum: ", cs(data, 4))