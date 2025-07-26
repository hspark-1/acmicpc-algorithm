import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[0]);
        for (int i=1; i<N; i++) {
            int pos = Collections.binarySearch(arrayList, arr[i]);
            if (pos < 0) pos = - (pos + 1);

            if (pos == arrayList.size()) arrayList.add(arr[i]);
            else arrayList.set(pos, arr[i]);
        }

        System.out.print(arrayList.size());
    }
}