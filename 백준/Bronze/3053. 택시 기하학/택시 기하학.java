import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R;
		
		R = sc.nextInt();
		
		double R1, R2;
		double PI = 3.14159265358979;
		
		R1 = R;
		R2 = R;
		
		R1 = R1 * R1 * PI;
		R2 = R2 * R2 * 2;
		
		System.out.printf("%.6f\n", R1);
		System.out.printf("%.6f", R2);
		
	}

}