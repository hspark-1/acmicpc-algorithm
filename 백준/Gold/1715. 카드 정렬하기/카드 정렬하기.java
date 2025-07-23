import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) priorityQueue.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        while (true) {
            int a = priorityQueue.poll();
            if (priorityQueue.isEmpty()) {
                System.out.println(sum);
                break;
            }
            int b = priorityQueue.poll();
            sum += (a + b);
            priorityQueue.add(a + b);
        }
    }
}
