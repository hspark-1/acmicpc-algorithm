import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[][] coordinates = new long[3][2];
        for (int i=0; i<3; i++) {
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
            if (i == 2) break;
            st = new StringTokenizer(br.readLine());
        }

        long answer = (coordinates[0][0] * coordinates[1][1] + coordinates[1][0] * coordinates[2][1] + coordinates[2][0] * coordinates[0][1]) - (coordinates[1][0] * coordinates[0][1] + coordinates[2][0] * coordinates[1][1] + coordinates[0][0] * coordinates[2][1]);
        if (answer == 0) System.out.print(0);
        else System.out.print((answer < 0) ? -1 : 1);
    }
}