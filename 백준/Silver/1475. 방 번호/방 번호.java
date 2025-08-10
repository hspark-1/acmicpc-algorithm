import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] str = s.split("");
        int[] numSet = new int[10];
        int max = -1;
        int maxIdx = -1;
        for (String tempS : str) {
            int num = Integer.parseInt(tempS);
            numSet[num]++;

            if (max < numSet[num]) {
                max = numSet[num];
                maxIdx = num;
            }

            if (max == numSet[num]) {
                if (num != 6 && num != 9) maxIdx = num;
            }
        }

        if (maxIdx != 6 && maxIdx != 9) System.out.print(max);
        else {
            int temp = numSet[6] - numSet[9];
            if (temp == 0) System.out.print(numSet[6]);
            else if (temp < 0) {
                if (-temp % 2 == 0) {
                    System.out.print(numSet[6] + (-temp) / 2);
                } else {
                    System.out.print(numSet[6] + 1 + (-temp) / 2);
                }
            } else if (temp > 0) {
                if (temp % 2 == 0) {
                    System.out.print(numSet[9] + (temp) / 2);
                } else {
                    System.out.print(numSet[9] + 1 + (temp) / 2);
                }
            }
        }
    }
}