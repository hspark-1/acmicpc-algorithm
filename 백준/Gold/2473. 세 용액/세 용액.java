import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int[] answer = new int[3];
        for (int i=0; i<N; i++) {
            int idx = i;
            int left = 0;
            int right = N - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }
                long temp = arr[idx] + arr[left] + arr[right];
                if (temp == 0) {
                    answer[0] = idx;
                    answer[1] = left;
                    answer[2] = right;
                    Arrays.sort(answer);
                    for (int k=0; k<3; k++) System.out.print(arr[answer[k]] + " ");
                    return;
                }
                min = Math.min(min, Math.abs(temp));
                if (min == Math.abs(temp)) {
                    answer[0] = idx;
                    answer[1] = left;
                    answer[2] = right;
                }

                if (temp < 0) left++;
                else right--;
            }
        }
        Arrays.sort(answer);
        for (int i=0; i<3; i++) System.out.print(arr[answer[i]] + " ");
    }
    
}