import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);

            if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());

            System.out.println(maxHeap.peek());
        }
    }
}