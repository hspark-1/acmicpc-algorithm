import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iterate = Integer.parseInt(br.readLine());

        for (int i=0; i<iterate; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int documentNum = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());

            int[] priority = new int[documentNum];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<documentNum; j++) priority[j] = Integer.parseInt(st.nextToken());

            int printPointer = 0;
            int priorityPointer = documentNum - 1;
            int[] print = Arrays.copyOf(priority, documentNum);
            Arrays.sort(priority);

            while (true) {
                if (print[printPointer] == priority[priorityPointer]) {
                    if (printPointer == targetIdx) {
                        System.out.println(documentNum - priorityPointer);
                        break;
                    }
                    priorityPointer--;
                    print[printPointer++] = -1;
                    printPointer = printPointer % documentNum;
                } else {
                    printPointer++;
                    printPointer = printPointer % documentNum;
                }
            }
        }
    }
}