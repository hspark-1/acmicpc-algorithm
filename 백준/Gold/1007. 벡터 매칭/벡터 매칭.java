import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static long[] coordiX, coordiY;
    static long totalX;
    static long totalY;
    static double min;

    public static void solution(String[] bitmask) {
        long startX = 0, startY = 0;
        for (int i=0; i<bitmask.length; i++) {
            if (bitmask[i].equals("1")) {
                startX += coordiX[i];
                startY += coordiY[i];
            }
        }
        long endX = totalX - startX, endY = totalY - startY;
        min = Math.min(min, Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY)));
    }
    
    public static void combination(String s, int one, int zero) {
        if (s.length() == N) {
            solution(s.split(""));
            return;
        }

        if (one < N/2) combination(s+"1", one+1, zero);
        if (zero < N/2) combination(s+"0", one, zero+1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            min = Double.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            coordiX = new long[N];
            coordiY = new long[N];
            totalX = 0;
            totalY = 0;
            
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coordiX[i] = Long.parseLong(st.nextToken());
                coordiY[i] = Long.parseLong(st.nextToken());
                totalX += coordiX[i];
                totalY += coordiY[i];
            }

            combination("", 0, 0);
            System.out.println(min);
            T--;
        }
    }
}