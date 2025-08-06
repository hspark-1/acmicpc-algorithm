import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] whiteBoard = new int[100][100];
        int cnt = 0;

        for (int k=0; k<N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int ii=Integer.parseInt(st.nextToken());
            int jj=Integer.parseInt(st.nextToken());
            for (int i = ii; i<ii+10; i++) {
                for (int j = jj; j<jj+10; j++) {
                    if (whiteBoard[i][j] == 0) {
                        whiteBoard[i][j] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}