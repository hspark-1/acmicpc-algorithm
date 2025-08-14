import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int numOfClass;
    static long[] numOfStudents;
    static long main, sub;
    static long answer;

    static void solution() {
        answer = numOfClass;
        for (int i=0; i<numOfClass; i++) {
            numOfStudents[i] -= main;

            if (numOfStudents[i] > 0) {
                answer += numOfStudents[i] / sub;
                if (numOfStudents[i] % sub != 0) answer++;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfClass = Integer.parseInt(br.readLine());

        numOfStudents = new long[numOfClass];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<numOfClass; i++) numOfStudents[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        main = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());

        solution();
        System.out.print(answer);
    }
}