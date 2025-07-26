import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] arr;

    public static int lowerBound(int[] arr, int value, int right) {
        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static boolean check(int mid) {
        int[] note = new int[N+1];
        note[0] = arr[0];
        int endIdx = 0;
        for (int i=1; i<N; i++) {
            if (note[endIdx] < arr[i]) {
                note[++endIdx] = arr[i];
            }
            else {
                note[lowerBound(note, arr[i], endIdx)] = arr[i];
            }
        }
        return endIdx + 1 >= mid;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = N;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.print(answer);
    }
}