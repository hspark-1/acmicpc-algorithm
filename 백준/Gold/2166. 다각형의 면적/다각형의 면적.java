import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static double answer = 0;

    public static double getTriangleArea(long[][] coordis) {
        long x1 = coordis[0][0], y1 = coordis[0][1];
        long x2 = coordis[1][0], y2 = coordis[1][1];
        long x3 = coordis[2][0], y3 = coordis[2][1];

        double base = Math.hypot(x2 - x1, y2 - y1);

        double height = heightFromPointToLine(x1, y1, x2, y2, x3, y3);

        return 0.5 * base * height;
    }

    private static double heightFromPointToLine(long x1, long y1, long x2, long y2, long x3, long y3) {
        double A = y2 - y1;
        double B = x1 - x2;
        double C = x2 * y1 - x1 * y2;

        return (A * x3 + B * y3 + C) / Math.sqrt(A * A + B * B);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] coordinates = new long[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N-2; i++) {
            answer += getTriangleArea(new long[][]{coordinates[0], coordinates[i+1], coordinates[i+2]});
        }

        System.out.printf("%.1f", Math.abs(Math.round(answer * 100.0) / 100.0));
    }
}