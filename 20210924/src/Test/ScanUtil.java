package Test;

import java.util.Scanner;

public class ScanUtil {
	static Scanner scn = new Scanner(System.in);

	public static int readInt(String msg) {
		System.out.println(msg);
		int num = scn.nextInt();
		scn.nextLine();
		return num;

	}

	public static String readStr(String msg) {
		System.out.println(msg);
		return scn.nextLine();

	}

	public static Gender readGender(String msg) {
		System.out.println(msg);
		while (true) {
			String gender = scn.nextLine();

			if (gender.equals("MAN")) {
				return Gender.MAN;
			} else if (gender.equals("WOMAN")) {
				return Gender.WOMAN;
//			} else if (gender.equals("")) {
				//..........?
			} 
			else {
				System.out.println("잘못 입력했습니다. <MAN> 또는 <WOMAN>로 입력하세요.");
			}

		}

	}
}
