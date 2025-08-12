import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int numOfNumbers;
    public static int[] numbers;
    public static int[] symbols = new int[4];
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static int add(int a, int b) {return a + b;}
    public static int sub(int a, int b) {return a - b;}
    public static int mul(int a, int b) {return a * b;}
    public static int div(int a, int b) {return a / b;}

    public static int calculate(int symbolsIdx, int firstNum, int secondNum) {
        switch (symbolsIdx) {
            case 0:
                return add(firstNum, secondNum);
            case 1:
                return sub(firstNum, secondNum);
            case 2:
                return mul(firstNum, secondNum);
            case 3:
                return div(firstNum, secondNum);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void solution(int answer, int idx) {
        for (int i=0; i<4; i++) {
            if (symbols[i] > 0) {
                int temp = calculate(i, answer, numbers[idx]);
                if (idx+1 == numOfNumbers) {
                    min = Math.min(min, temp);
                    max = Math.max(max, temp);
                    return;
                } else {
                    symbols[i]--;
                    solution(temp, idx+1);
                    symbols[i]++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfNumbers = Integer.parseInt(br.readLine());
        numbers = new int[numOfNumbers];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<numOfNumbers; i++) numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) symbols[i] = Integer.parseInt(st.nextToken());

        if (numOfNumbers == 2) {
            for (int i=0; i<4; i++) {
                if (symbols[i] == 1) {
                    int temp = calculate(i, numbers[0], numbers[1]);
                    min = temp;
                    max = temp;
                }
            }
        } else {
            solution(numbers[0], 1);
        }
        System.out.print(max + "\n" + min);
    }
}