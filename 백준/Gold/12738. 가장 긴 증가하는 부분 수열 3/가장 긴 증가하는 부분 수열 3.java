import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i=1; i<N; i++) {
            int idx = Collections.binarySearch(answer, arr[i]);
            if (idx < 0) idx = (-idx) - 1;
            if (idx < answer.size()) answer.set(idx, arr[i]);
            else answer.add(arr[i]);
        }
        System.out.println(answer.size());
    }
    
}