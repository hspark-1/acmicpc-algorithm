import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] T, P;
    static int max_profit = 0;

    public static void dfs(int day, int profit) {
        if (profit > max_profit) {
            max_profit = profit;
        }

        if (day >= N) {
            return;
        }

        int end_day = day + T[day];
        if (end_day <= N) {
            dfs(end_day, profit + P[day]);
        }

        dfs(day + 1, profit);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.print(max_profit);
    }
    
}