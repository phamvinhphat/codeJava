

import java.util.*;

/*
 * co caro
 */
public class autoCaro {
	static String a[][] = new String[6][6];
	static byte chon;

	
	/*
	 * ban co 5x5
	 */
	public static void create_board() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				a[i][j] = "-";
			}
		}
	}

	/*
	 * duy chuyen cua co X
	 */
	public static void inputCaro(int row, int clumn, String n) {
			a[row][clumn] = n;
	}
	
	/*
	 * xuat ban co 5x5
	 */
	public static void output() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println("\n");
		}
	}

	
	
	public static boolean is_legal_moveO() {
		int h = 0;
		Random rd = new Random();
//		if (row < 6 && column < 6) {
		do {	
				int value  = rd.nextInt(5)+1;
				int value2 = rd.nextInt(5)+1;
				if (a[value][value2] == "-") {
						inputCaro(value,value2,"O");
						if(checkWin(value, value2) == true) {
							System.out.println("O Thang");
							chon = 0; 
						}
						return true;
				} 
		}while( h == 0 );
// phai chan cai false kho thi no se thoat khoi chuong trinh  
		//return false;
		return false;
	}
	
 	public static void make_moveO() {
 		boolean ble = is_legal_moveO() ;
 		if(ble == true) {
			System.out.println("\n---------------");
			System.out.println("\nO Sau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
 		}
 	}
	
	/*
	 * Kiem tra dieu kien de duy chuyen cua ban co
	 */

	public static boolean is_legal_move(int row, int column, String n) {
		if (row < 6 && column < 6) {
			if(n.equalsIgnoreCase("X") || n.equalsIgnoreCase("O")) {
					if (a[row][column] == "-") {
							return true;
					}
			}
			System.out.println("\n" + row + "  " + column);
		}
		if (row == 0 || column == 0) {
			return false;
		}
		return false;
	}
	

	/*
	 * kiem tra co hop phap ko de thuc hien viec di chuyen
	 *
	 */
	public static void make_move(int row, int column, String n) {
		boolean bl = is_legal_move(row, column,n);
		if (bl == true) {
			System.out.print("\ndi chuyen hop phap \n");
			inputCaro(row, column, n);
			System.out.println("\n---------------");
			System.out.println("\nX Sau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
			make_moveO();
		} else {
			System.out.print("\n!!!! di chuyen (Ten) khong hop phap !!!!\n");
			System.out.println("\n---------------");
		}
	}
	
	/*
	 * tu dong danh (y tuong tim kiem dau - ed no cos hang va cot de danh vao
	 * co the su dung do- while de dung 
	 */

	public static void random2() {
		Random r1 = new Random();
		int value = r1.nextInt(5)+1;
		int value2 = r1.nextInt(5)+1;
		a[value][value2] = "O";
		
	}
	

		public static boolean checkWin(int i, int j)  {
			int d = 0, k = i, d2 = 0, k2 = j, d3 =0 ;
			
			// so cot 
			while (k < 6 && a[k][j].equalsIgnoreCase(a[i][j]) ) {
				d++;
				k++;
			}
			
			k= i-1;
		
			while( k!=0 && a[k][j].equalsIgnoreCase(a[i][j]) ) {
				d++;
				k--;
				}
			if(d > 4 ) {
				return true;
			}
			
			// so hang
			while(k2 < 6 && a[i][k2].equalsIgnoreCase(a[i][j])) {
				d2++;
				k2++;
			}
			k2 = j-1;
			while(k2 != 0 && a[i][k2].equalsIgnoreCase(a[i][j]) ) {
				d2++;
				k2--;
			}
			
			if(d2 > 4) {
				return true;
			}
			
			
			// so duong cheo dau huyen
			int k3 =i , k4 = j;
			while(k3 < 6 && k4 < 6 && a[k3][k4].equalsIgnoreCase(a[i][j]) ) {
				d3++;
				k3++;
				k4++;
			}
			
			k3 = i-1;
			k4 = j-1;
			while(k3 != 0 && k4 != 0 && a[k3][k4].equalsIgnoreCase(a[i][j]) ) {
				d3++;
				k3--;
				k4--;
			}
			
			if(d3 > 4) {
				return true;
			}
			
			// dương chéo dau sat
			int k5 = i, k6 = j, d4 = 0;
			while(k5 != 0 && k6 != 0 &&k5 < 6 && k6 < 6 && a[k5][k6].equalsIgnoreCase(a[i][j]) ) {
				d4++;
				k5++;
				k6--;
			}
			k5 = i-1;
			k6 = j+1; 
			while(k5 < 6 && k6 < 6 && k5 != 0 && k6 != 0 && a[k5][k6].equalsIgnoreCase(a[i][j])) {
				d4++;
				k5--;
				k6++;
			}
			if(d4 > 4) {
				return true;
			}
		
			return false;
		}
		
		
		
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	

		do {
			System.out.println("\n1: xuat bang ");
			System.out.println("\n2: duy chuyen ");
			System.out.print("Chon buoc : ");
			chon = sc.nextByte();
			switch (chon) {
			case 1:
				create_board();
				output();
				break;

			case 2:
				System.out.println("\n---------------");
				System.out.print("\nNhap so hang X :");
				int sh = sc.nextInt();
				System.out.print("So cot X : ");
				int soc = sc.nextInt();
				System.out.println("\n---------------");
				System.out.print("\nKIEM TRA : ");
				make_move(sh, soc, "X");

				if(checkWin(sh,soc) == true) {
					System.out.print("X Thang");
					chon = 0;
				}
				
				break;

			default:
				chon = 0;
				break;
			}
		} while (chon != 0);
		sc.close();
	}
}
