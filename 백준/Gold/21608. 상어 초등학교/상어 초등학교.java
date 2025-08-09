import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfClass = Integer.parseInt(br.readLine());
        int numOfStudents = sizeOfClass * sizeOfClass;
        int[] studentOrder = new int[numOfStudents];
        List<Integer>[] favoriteStudents = new ArrayList[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) favoriteStudents[i] = new ArrayList<>();
        
        for (int i = 0; i < numOfStudents; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            studentOrder[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) favoriteStudents[studentOrder[i]-1].add(Integer.parseInt(st.nextToken()));
        }
        
        int[][] seatingChart = new int[sizeOfClass][sizeOfClass];
        boolean[] isSeated = new boolean[numOfStudents];
        seatingChart[1][1] = studentOrder[0];
        isSeated[studentOrder[0]-1] = true;

        for (int i=1; i<numOfStudents; i++) {
            int seatX = -1;
            int seatY = -1;
            int numOfFavorite = -1;
            int numOfEmpty = -1;
            for (int j=0; j<sizeOfClass; j++) {
                for (int k=0; k<sizeOfClass; k++) {
                    int temp = 0;
                    int tempEmpty = 0;
                    if (seatingChart[j][k] == 0) {
                        if (j != 0 && favoriteStudents[studentOrder[i]-1].contains(seatingChart[j-1][k])) temp++;
                        else if (j != 0 && seatingChart[j-1][k] == 0) tempEmpty++;
                        if (j+1 != sizeOfClass && favoriteStudents[studentOrder[i]-1].contains(seatingChart[j+1][k])) temp++;
                        else if (j+1 != sizeOfClass && seatingChart[j+1][k] == 0) tempEmpty++;
                        if (k != 0 && favoriteStudents[studentOrder[i]-1].contains(seatingChart[j][k-1])) temp++;
                        else if (k != 0 && seatingChart[j][k-1] == 0) tempEmpty++;
                        if (k+1 != sizeOfClass && favoriteStudents[studentOrder[i]-1].contains(seatingChart[j][k+1])) temp++;
                        else if (k+1 != sizeOfClass && seatingChart[j][k+1] == 0) tempEmpty++;
                        
                        if ((temp > numOfFavorite) || (temp == numOfFavorite && tempEmpty > numOfEmpty)) {
                            seatX = j;
                            seatY = k;
                            numOfFavorite = temp;
                            numOfEmpty = tempEmpty;
                        }
                    }
                }
            }

            seatingChart[seatX][seatY] = studentOrder[i];
        }

        int answer = 0;
        for (int i=0; i<sizeOfClass; i++) {
            for (int j=0; j<sizeOfClass; j++) {
                int temp = 0;
                if (i != 0 && favoriteStudents[seatingChart[i][j]-1].contains(seatingChart[i-1][j])) temp++;
                if (i+1 != sizeOfClass && favoriteStudents[seatingChart[i][j]-1].contains(seatingChart[i+1][j])) temp++;
                if (j != 0 && favoriteStudents[seatingChart[i][j]-1].contains(seatingChart[i][j-1])) temp++;
                if (j+1 != sizeOfClass && favoriteStudents[seatingChart[i][j]-1].contains(seatingChart[i][j+1])) temp++;
                switch (temp) {
                    case 4:
                        answer += 1000;
                        break;
                    case 3:
                        answer += 100;
                        break;
                    case 2:
                        answer += 10;
                        break;
                    case 1:
                        answer += 1;
                        break;
                }
            }
        }
        System.out.println(answer);
    }
}