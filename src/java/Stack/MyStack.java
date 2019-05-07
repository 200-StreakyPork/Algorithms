package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int firstMax = -65536;
        int secondMax = -65536;
        int firstMin = 65535;
        int secondMin = 65535;

        Stack<Integer> stack = new Stack<>();
        int num =0;
        String Info = in.nextLine();
        String[] intArray = Info.split(" ");
        for(int i=0; i<intArray.length; i++){
            if(i==0){
                num = Integer.parseInt(intArray[i]);
                continue;
            }

            int a = Integer.parseInt(intArray[i]);
            if(i==1){
                firstMax =a;
                secondMax = a;
                firstMin = a;
                secondMin = a;
            }
            else {
                if(a > firstMax){
                    secondMax =firstMax;
                    firstMax = a;
                }
                else if(a > secondMax){
                    secondMax = a;
                }
                if(a < firstMin){
                    secondMin = firstMin;
                    firstMin = a;
                }
                else if(a < secondMin){
                    secondMin = a;
                }

                stack.push(a);
            }
        }


        int temp = stack.pop();
        if(temp==firstMax)
            System.out.println(secondMax+","+firstMin);
        else if(temp==firstMin)
            System.out.println(firstMax+","+secondMax);
        else
            System.out.println(firstMax+","+firstMin);

    }

}
