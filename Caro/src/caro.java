


import java.io.UnsupportedEncodingException;
import java.util.*;


/*
 * co caro
 */
public class caro {
	/*
	 * khoi tao bang ban dau 
	 */
	static int row = 10;
	static int column = 10;
	static byte chon;
	static String a[][] = new String[row][column];
	
	/*
	 * lap ban co
	 */
	public static void create_board() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(i == 0 || i % 2 == 0 ) {
					a[i][j] = "_";					
				}
				if(a[i][j] == null) {
					a[i][j] = " ";
				}
			}
		}
	}
	
	

	
	
	/*
	 * xuat ban co 5x5
	 */
	public static void output() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(a[i][j] +"|");
			}
			System.out.print("\n");
		}
	}
	
	
	/*
	 * duy chuyen cua co
	 */
	public static void inputCaro(int row, int clumn, String n) {
			a[row][clumn] = n;
	}
	
	
	/*
	 * Kiem tra dieu kien de duy chuyen cua ban co
	 */
	public static boolean is_legal_move(int row2, int column2) {
		if (row2 < row && column2 < column || row2 != 0 ) {
					if (a[row2][column2] == " ") {
							return true;
					}
				}
		return false;
	}

	
	/*
	 * kiem tra co hop phap ko de thuc hien viec di chuyen
	 *
	 */
	public static void make_move(int row, int column, String n) {
		boolean bl = is_legal_move(row, column);
		if (bl == true) {
			System.out.print("\ndi chuyen hop phap \n");
			inputCaro(row, column, n);
			System.out.println("\n---------------");
			System.out.println("\nSau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
			 if( checkWin(row, column) == true ) {
				 System.out.println("Thang");
				 chon = 0;
			 }
		} else {
			System.out.print("\n!!!! di chuyen (Ten) khong hop phap !!!!\n");
			System.out.println("\n---------------");
		}
	}
	
	
	
	
	
	/*
	 * chay bang random
	 */
	public static boolean inputRandom() {
		int h = 0;
		Random rd = new Random();
		do {	
				int value  = rd.nextInt(row);
				int value2 = rd.nextInt(column);
				if (a[value][value2] == " ") {
						inputCaro(value,value2,"O");
						if(checkWin(value, value2) == true) {
							System.out.println("Thang");
							chon = 0; 
						}
						return true;
				} 
		}while( h == 0 );
		return false;
	}
	
	/*
	 * xuat random
	 */
	public static void make_moveO() {
		boolean bl = inputRandom();
		if (bl == true) {
			System.out.println("\n---------------");
			System.out.println("\nO Sau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
		}
	}
	
	
	/*
	 * xuat cac buoc duy chuyen
	 */
	public static void make_move_auto(int row, int column, String n) {
		boolean bl = is_legal_move(row, column);
		if (bl == true) {
			System.out.print("\ndi chuyen hop phap \n");
			inputCaro(row, column, n);
			System.out.println("\n---------------");
			System.out.println("\nX Sau khi di chuyen \n ");
			output();
			if( checkWin(row, column) == true) {
				System.out.println("X thang ");
				chon = 0;
			}
			System.out.println("\n---------------");
			make_moveO();
		} else {
			System.out.print("\n!!!! di chuyen (Ten) khong hop phap !!!!\n");
			System.out.println("\n---------------");
		}
	}
	
	
	
	public static boolean checkWin(int i, int j)  {
		if(i < row && j < column) {
			
			// so cot 
			int check_column = 0, transfer_row = i ;
			while (transfer_row < column && a[transfer_row][j].equalsIgnoreCase(a[i][j]) ) {
				check_column ++ ;
				transfer_row = transfer_row + 2;
			}
			
			transfer_row = i - 2;
		
			while(  transfer_row >= 0 && a[transfer_row][j].equalsIgnoreCase(a[i][j]) ) {
				check_column ++ ;
				transfer_row = transfer_row - 2; 
			}
			
			if(check_column > 4 ) {
				return true;
			}
			
			
			// so hang
			int check_row = 0, transfer_column = j;
			while(transfer_column < row && a[i][transfer_column].equalsIgnoreCase(a[i][j])) {
				check_row ++ ;
				transfer_column ++ ;
			}
			
			transfer_column = j - 1; 
			
			while(transfer_column >= 0 && a[i][transfer_column].equalsIgnoreCase(a[i][j]) ) {
				check_row ++ ;
				transfer_column -- ;
			}
			
			if(check_row > 4) {
				return true;
			}
			
			
			// so duong cheo dau huyen
			int transfer_row_1 = i , transfer_column_1 = j, check_ringht_diagonal = 0;
			while(transfer_row_1 < row && transfer_column_1 < column
					&& a[transfer_row_1][transfer_column_1].equalsIgnoreCase(a[i][j]) ) {
				
				check_ringht_diagonal ++ ;
				transfer_row_1 ++ ;
				transfer_column_1 = transfer_column_1 + 2 ;
				
			}
			
			transfer_row_1 = i - 2;
			transfer_column_1 = j - 1;
			
			while(transfer_row_1 >= 0 && transfer_column_1 >= 0 
					&& a[transfer_row_1][transfer_column_1].equalsIgnoreCase(a[i][j]) ) {
				
				check_ringht_diagonal ++ ;
				transfer_row_1 = transfer_row_1 - 2 ;
				transfer_column_1 -- ;
			}
			
			if(check_ringht_diagonal > 4) {
				return true;
			}
	
			
			// dương chéo dau sat
			int transfer_row_2 = i, transfer_column_2 = j, check_left_diagonal = 0;
			while(transfer_column_2 >= 0 && transfer_row_2 < row 
					&& transfer_column < column 
					&& a[transfer_row_2][transfer_column_2].equalsIgnoreCase(a[i][j]) ) {
				
				check_left_diagonal++;				
				transfer_row_2 = transfer_row_2 + 2;
				transfer_column_2--;
			}
			
			transfer_row_2 = i - 2;
			transfer_column_2 = j + 1; 
			
			while(transfer_row_2 < row && transfer_column_2 < column
					&& transfer_row_2 >= 0 
					&& a[transfer_row_2][transfer_column_2].equalsIgnoreCase(a[i][j])) {
				
				check_left_diagonal++;
				transfer_row_2 = transfer_row_2 - 2;
				transfer_column_2++;
			}
			
			if(check_left_diagonal > 4) {
				return true;
			}
		}	
		return false;
	}
	
	

	public static void main(String args[]) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
//		
//		create_board();
//		create_board();
//		output();
		int change = 1;
		
		do {
			System.out.println("=========CO CARO========");
			System.out.println("Chon so 1 : choi mot nguoi ");
			System.out.println("Chon so 2 : choi hai nguoi ");
			System.out.println("Chon so 0 : thoat khoi tro choi ");
			System.out.print("Chon : "); 
			byte chon1 = sc.nextByte();
			if(chon1 == 2) {
					do {
						System.out.println("\n-----CO CARO HAI NGUOI CHOI------");
						System.out.println("chon 1 : Tao mang choi moi ");
						System.out.println("chon 2 : duy chuyen ");
						System.out.print("Chon  : ");
						chon = sc.nextByte();
						switch (chon) {
						case 1:
						create_board();
						output();
						break;
			
						case 2:
							System.out.println("\n---------------");
							System.out.print("\nNhap so hang :");
							int sh = sc.nextInt();
							System.out.print("So cot : ");
							int soc = sc.nextInt();
							System.out.println("\n---------------");
							System.out.print("\nKIEM TRA : ");
							if(is_legal_move(sh,soc) == true) {
								if(change % 2 != 0) {
									make_move(sh, soc, "X");
									change ++ ;
								} else {
									make_move(sh, soc, "O");
									change ++ ;
								}
							} else {
								System.out.println("!!! LOI SAI DO HANG VA COT KHONG DUNG !!!");
							}
							break;
			
						default:
							chon = 0;
							break;
						}
					} while (chon != 0);
					
			} else if (chon1 == 1) {
				do {
					System.out.println("\n-----CO CARO MOT NGUOI CHOI------");
					System.out.println("chon 1: Tao mang choi moi ");
					System.out.println("chon 2: duy chuyen ");
					System.out.print("Chon  : ");
					chon = sc.nextByte();
					switch (chon) {
					case 1:
						create_board();
						output();
						break;
		
					case 2:
						System.out.println("\n---------------");
						System.out.print("\nNhap so hang X :");
						int sh1 = sc.nextInt();
						System.out.print("So cot  X : ");
						int soc1 = sc.nextInt();
						System.out.println("\n---------------");
						System.out.print("\nKIEM TRA : ");
						make_move_auto(sh1, soc1, "X");
						

						
						break;
		
					default:
						chon = 0;
						break;
					}
				} while (chon != 0);
			}
		sc.close();
	}while(chon !=0 );
	}
}