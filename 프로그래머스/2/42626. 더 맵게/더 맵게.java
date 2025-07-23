import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i:scoville) priorityQueue.add(i);
        int num1 = priorityQueue.poll();
        while (num1 < K) {
            cnt++;
            if (priorityQueue.isEmpty()) return -1;
            int num2 = priorityQueue.poll();
            priorityQueue.add(num1 + num2 * 2);
            num1 = priorityQueue.poll();
        }
        
        return cnt;
    }
}