import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static long[][] coordi;
    static long totalX;
    static long totalY;
    static double min;

    private static void solution(int idx, int cnt, long startX, long startY) {
        if (cnt + (N - idx) < N/2) return;
        if (cnt == N/2) {
            long dx = (totalX - startX) - startX, dy = (totalY - startY) - startY;
            min = Math.min(min, Math.sqrt(dx*dx + dy*dy));
            return;
        }

        if (idx == N) return;
        solution(idx+1, cnt+1, startX+coordi[idx][0], startY+coordi[idx][1]);
        solution(idx+1, cnt, startX, startY);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            min = Double.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            coordi = new long[N][2];
            
            totalX = 0;
            totalY = 0;
            
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                coordi[i][0] = Long.parseLong(st.nextToken());
                coordi[i][1] = Long.parseLong(st.nextToken());
                totalX += coordi[i][0];
                totalY += coordi[i][1];
            }

            solution(0, 0, 0L, 0L);
            System.out.println(min);
            T--;
        }
    }
}