package Java;

import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String twoString = in.nextLine();
        String a = twoString.split(",")[0];
        int[] A = StringToIntArray(a);
        String b = twoString.split(",")[1];
        int[] B = StringToIntArray(b);

        int length = A.length;
        int count = 0;
        int count_12 = 0;
        int count_21 = 0;
        int count_31 = 0;
        int count_32 = 0;
        for(int i=0;i<length;i++){
            //相同不用操作
            if(A[i]==B[i]){}
            //两组12可以一次交换
            else if(A[i]==1 && B[i]==2){
                count_12++;
                while(count_21!=0 && count_12!=0){
                    count_12--;
                    count_21--;
                    count++;
                }
                while(count_31!=0 && count_12!=0){
                    count_12--;
                    count_31--;
                    count = count + 2;
                }
            }
            else if(A[i]==2 && B[i]==1){
                count_21++;
                while(count_12!=0 && count_21!=0){
                    count_12--;
                    count_21--;
                    count++;
                }
            }
            //由于上述操作，31可以和12分组
            else if(A[i]==3 && B[i]==1){
                count_31++;
                while(count_12!=0 && count_31!=0){
                    count_12--;
                    count_31--;
                    count = count + 2;
                }
            }
            else if(A[i]==3 && B[i]==2){
                count++;
            }
        }

        if(count_12!=0){
            count = count + count_12;
        }
        if(count_21!=0){
            count = count + count_21;
        }
        if(count_31!=0){
            count = count + count_31*2;
        }

        System.out.println(count);
    }

    public static int[] StringToIntArray(String s){
        int length = s.length();
        char[] charArray = s.toCharArray();
        int[] intArray = new int[length];
        for(int i=0;i<length;i++){
            intArray[i] = charArray[i]-'0';
            //System.out.println(intArray[i]);
        }
        return intArray;
    }
}
