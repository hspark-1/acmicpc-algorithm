import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static long[] arr;
    
    public static boolean check(long mid) {
        long temp = arr[0];
        int idx = 1;
        long cnt = 0;
        while (cnt < M) {
            if (temp - mid < 0) {
                if (idx == N) return false;
                temp = arr[idx++];
            } else {
                temp -= mid;
                cnt++;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long max = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 0;
        long right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
    
}