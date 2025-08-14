import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int numOfPeople;
    static int[][] syncAbility;
    static boolean[] isStart;
    static int minDiff = Integer.MAX_VALUE;
    
    static void calculateDifference() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < numOfPeople; i++) {
            for (int j = 0; j < numOfPeople; j++) {
                if (isStart[i] && isStart[j]) {
                    startScore += syncAbility[i][j];
                } else if (!isStart[i] && !isStart[j]) {
                    linkScore += syncAbility[i][j];
                }
            }
        }

        int diff = Math.abs(startScore - linkScore);
        if (diff < minDiff) {
            minDiff = diff;
        }
    }

    public static void solve(int idx, int count) {
        if (count == numOfPeople / 2) {
            calculateDifference();
            return;
        }

        for (int i = idx; i < numOfPeople; i++) {
            if (!isStart[i]) {
                isStart[i] = true;
                solve(i + 1, count + 1);
                isStart[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfPeople = Integer.parseInt(br.readLine());
        syncAbility = new int[numOfPeople][numOfPeople];
        isStart = new boolean[numOfPeople];

        for (int i=0; i<numOfPeople; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<numOfPeople; j++) syncAbility[i][j] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);
        System.out.print(minDiff);
    }
}