import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i=0; i<testCaseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int planetNum = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j=0; j<planetNum; j++) {
                st = new StringTokenizer(br.readLine());
                int coordiPlanetX = Integer.parseInt(st.nextToken());
                int coordiPlanetY = Integer.parseInt(st.nextToken());
                int coordiPlanetRadius = Integer.parseInt(st.nextToken());
                int diffX = coordiPlanetX - startX;
                int diffY = coordiPlanetY - startY;
                int diffEndX = coordiPlanetX - endX;
                int diffEndY = coordiPlanetY - endY;
                if (diffX * diffX + diffY * diffY < coordiPlanetRadius * coordiPlanetRadius) {
                    if (!(diffEndX * diffEndX + diffEndY * diffEndY < coordiPlanetRadius * coordiPlanetRadius)) cnt++;
                } else {
                    if (diffEndX * diffEndX + diffEndY * diffEndY < coordiPlanetRadius * coordiPlanetRadius) cnt++;
                }
                
            }
            System.out.println(cnt);
        }
    }
}