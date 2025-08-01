import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfKoreanmelon = Integer.parseInt(br.readLine());
        int[] directions = new int[6];
        int[] lengths = new int[6];

        int maxWidth = 0, maxWidthIdx = -1;
        int maxHeight = 0, maxHeightIdx = -1;
        for (int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directions[i] = Integer.parseInt(st.nextToken());
            lengths[i] = Integer.parseInt(st.nextToken());
            if (directions[i] == 1 || directions[i] == 2) {
                if (lengths[i] > maxWidth) {
                    maxWidth = lengths[i];
                    maxWidthIdx = i;
                }
            } else {
                if (lengths[i] > maxHeight) {
                    maxHeight = lengths[i];
                    maxHeightIdx = i;
                }
            }
        }

        int minWidth = Math.abs(lengths[(maxHeightIdx + 5) % 6] - lengths[(maxHeightIdx + 1) % 6]);
        int minHeight = Math.abs(lengths[(maxWidthIdx + 5) % 6] - lengths[(maxWidthIdx + 1) % 6]);

        System.out.println(numberOfKoreanmelon * ((maxWidth * maxHeight) - (minWidth * minHeight)));
    }
}