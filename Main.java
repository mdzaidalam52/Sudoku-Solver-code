import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] a = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				a[i][j] = s.nextInt();
		
		if(!solve(a, 0, 0)) {
			System.out.println("not able to solve");
		}

		System.out.println("_________________________");
		for(int i = 0; i < 9; i++) {
			System.out.print("|" + " ");
			for(int j = 0; j < 9; j++) {
				System.out.print(a[i][j] + " ");
				if(j%3 == 2) {
					System.out.print("|" + " ");
				}
			}
			if(i%3 == 2) {
				System.out.println();
				System.out.println("_________________________");
			}else {

				System.out.println();
			}
		}

	}
	
	static boolean solve(int[][] a, int x, int y) {
		boolean bool = false;
		if(a[x][y] != 0) {
			if(x == 8 && y == 8) {
				return true;
			}else if(y == 8) {
				return solve(a, x+1, 0);
			}else {
				return solve(a, x, y+1);
			}
		}else {
			bool = true;
			for(int i = 1; i <= 9; i++) {
				if(check(a, x, y, i)) {
					a[x][y] = i;
					
					if(x == 8 && y == 8) {
						return true;
					}else if(y == 8) {
						if(solve(a, x+1, 0)){
							return true;
						}
					}else {
						if(solve(a, x, y+1)) {
							return true;
						}
					}
				}
				
			}
		}
		if(bool)
			a[x][y] = 0;
		return false;
	}
	
	static boolean check(int[][] a, int x, int y, int k) {
		
		for(int i = 0 ; i < 9; i++) 
			if(a[i][y] == k || a[x][i] == k) 
				return false;
		
		for(int i = 3*(x/3); i < 3*(x/3) + 3; i++)
			for(int j = 3*(y/3); j < 3*(y/3) + 3; j++) 
				if(a[i][j] == k)
					return false;
		
		return true;
	}

}
