import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int numInven = Integer.parseInt(st.nextToken());

        int[][] groundHeight = new int[N][M];
        int maxHeight = Integer.MIN_VALUE, minHeight = Integer.MAX_VALUE;
        int[] heights = new int[257];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                groundHeight[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, groundHeight[i][j]);
                maxHeight = Math.max(maxHeight, groundHeight[i][j]);
                heights[groundHeight[i][j]]++;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int finalHeight = -1;
        for (int i=minHeight; i<=maxHeight; i++) {
            int sum = 0;
            int usedItem = 0;
            for (int j=minHeight; j<=maxHeight; j++) {
                int temp = heights[j] * (j - i);
                if (temp < 0) {
                    sum -= temp;
                    usedItem -= temp;
                }
                else {
                    sum += 2*temp;
                    usedItem -= temp;
                }
            }
            if (usedItem <= numInven) {
                minTime = Math.min(minTime, sum);
                if (minTime == sum) finalHeight = i;
            }
        }

        System.out.print(minTime + " " + finalHeight);
    }
}