import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            int lastDigit = a % 10;
            int exponent = b;

            if (lastDigit == 0) {
                System.out.println(10);
                continue;
            }

            int cycleLength = 0;
            if (lastDigit == 1 || lastDigit == 5 || lastDigit == 6) {
                cycleLength = 1;
            } else if (lastDigit == 4 || lastDigit == 9) {
                cycleLength = 2;
            } else {
                cycleLength = 4;
            }
            
            int effectiveExponent = (exponent % cycleLength == 0) ? cycleLength : exponent % cycleLength;

            long result = 1;
            for (int j = 0; j < effectiveExponent; j++) {
                result = (result * lastDigit) % 10;
            }

            if (result == 0) {
                System.out.println(10);
            } else {
                System.out.println(result);
            }
        }
    }
}