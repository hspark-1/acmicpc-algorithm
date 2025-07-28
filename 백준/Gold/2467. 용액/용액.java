import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i=0; i<N; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        long[] answer = {arr[0], arr[N-1]};
        int left = 0;
        int right = N-1;
        long min = Math.abs(arr[right] + arr[left]);
        while(left + 1 < right) {
            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                long temp = Math.abs(arr[--right] + arr[left]);
                if (min > temp) {
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                    min = temp;
                }
            } else {
                long temp = Math.abs(arr[++left] + arr[right]);
                if (min > temp) {
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                    min = temp;
                }
            }
        }
        System.out.print(answer[0] + " " + answer[1]);
    }
    
}