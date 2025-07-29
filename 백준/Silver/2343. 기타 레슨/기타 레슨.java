import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, sum;
    public static int[] arr;
    
    public static boolean check(int mid) {
        int[] temp = new int[M];
        int idx = 0;
        for (int i=0; i<N; i++) {
            if (temp[idx] + arr[i] <= mid) temp[idx] += arr[i];
            else {
                if (idx + 1 >= M) return false;
                temp[++idx] += arr[i];
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        sum = 0;
        int max = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = sum;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
    
}