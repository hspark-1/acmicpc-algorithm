import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long a, b;
        a = Long.parseLong(s.split(" ")[0]);
        b = Long.parseLong(s.split(" ")[1]);

        int size = (int) (b - a + 1);
        boolean[] isSquareFree = new boolean[size];

        for (long i = 2; i * i <= b; i++) {
            long square = i * i;
            
            long start = ((a + square - 1) / square) * square;

            for (long j = start; j <= b; j += square) {
                isSquareFree[(int) (j - a)] = true;
            }
        }

        int count = 0;
        for (boolean isFree : isSquareFree) {
            if (!isFree) {
                count++;
            }
        }
        
        System.out.print(count);
    }
}