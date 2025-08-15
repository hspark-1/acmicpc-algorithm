import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int vertNum, horiNum;
    static int coordiX, coordiY;
    static int orderNum;
    static int[][] map;
    static int[] order;
    static int[] dice = new int[6];
    static int[] diceLocation = new int[6];

    static boolean move(int curOrder) {
        int temp;
        switch(curOrder) {
            case 1:
                if (coordiY+1 == horiNum) return false;
                coordiY++;
                temp = diceLocation[0];
                diceLocation[0] = diceLocation[1];
                diceLocation[1] = diceLocation[5];
                diceLocation[5] = diceLocation[2];
                diceLocation[2] = temp;
                return true;
            case 2:
                if (coordiY == 0) return false;
                coordiY--;
                temp = diceLocation[0];
                diceLocation[0] = diceLocation[2];
                diceLocation[2] = diceLocation[5];
                diceLocation[5] = diceLocation[1];
                diceLocation[1] = temp;
                return true;
            case 3:
                if (coordiX == 0) return false;
                coordiX--;
                temp = diceLocation[0];
                diceLocation[0] = diceLocation[3];
                diceLocation[3] = diceLocation[5];
                diceLocation[5] = diceLocation[4];
                diceLocation[4] = temp;
                return true;
            case 4:
                if (coordiX+1 == vertNum) return false;
                coordiX++;
                temp = diceLocation[0];
                diceLocation[0] = diceLocation[4];
                diceLocation[4] = diceLocation[5];
                diceLocation[5] = diceLocation[3];
                diceLocation[3] = temp;
                return true;
            default:
                return false;
        }
    }

    static void solution() {
        // 0: 현재위치 1-4: order가 해당 값일 때 5: top
        diceLocation[0] = 2;
        diceLocation[1] = 3;
        diceLocation[2] = 1;
        diceLocation[3] = 0;
        diceLocation[4] = 4;
        diceLocation[5] = 5;
        for (int curOrder : order) {
            if(move(curOrder)) {
                int a = map[coordiX][coordiY];
                if (a == 0) {
                    map[coordiX][coordiY] = dice[diceLocation[0]];
                } else {
                    dice[diceLocation[0]] = a;
                    map[coordiX][coordiY] = 0;
                }
                System.out.println(dice[diceLocation[5]]);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertNum = Integer.parseInt(st.nextToken());
        horiNum = Integer.parseInt(st.nextToken());
        coordiX = Integer.parseInt(st.nextToken());
        coordiY = Integer.parseInt(st.nextToken());
        orderNum = Integer.parseInt(st.nextToken());

        map = new int[vertNum][horiNum];
        for (int i=0; i<vertNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<horiNum; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        order = new int[orderNum];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<orderNum; i++) order[i] = Integer.parseInt(st.nextToken());

        solution();
    }
}