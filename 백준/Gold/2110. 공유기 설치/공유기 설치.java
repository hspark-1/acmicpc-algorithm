import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[] arr;
    public static boolean check(int cnt, int tempC) {
        int startIdx = 0;
        for (int i=1; i<N; i++) {
            if (arr[i] - arr[startIdx] >= cnt) {
                startIdx = i;
                tempC--;
                if (tempC == 1) return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 1;
        int right = arr[N-1] - arr[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, C)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}