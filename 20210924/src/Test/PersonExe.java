package Test;


public class PersonExe {

	private static PersonExe singleton = new PersonExe();
	private Person[] people;

	private PersonExe() {
		people = new Person[100];
		people[0] = new Person("홍길동", Gender.MAN, "1111-2222");
		people[1] = new Person("김길동", Gender.MAN, "3333-4444");
		people[2] = new Student("위정아", Gender.WOMAN, "4444-5555", "예담");
		people[3] = new Worker("위민정", Gender.WOMAN, "6666-7777", "삼성");
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void execute() {
		while (true) {
			System.out.println("----------------------------");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("----------------------------");
			int menu = ScanUtil.readInt("메뉴를 선택하세요.");
			if (menu == 1) {
				System.out.println("추가");
				addPerson();
			} else if (menu == 2) {
				System.out.println("조회");
				showList();
			} else if (menu == 3) {
				System.out.println("수정");
				modify();
			} else if (menu == 4) {
				System.out.println("삭제");
				delete(); 
			} else if (menu == 5) {
				System.out.println("종료합니다.");
				break;
			}
		}
		System.out.println("끝");
	}

	private void addPerson() {
		System.out.println("1.사람 2.학생 3.직장인");
		int choice = ScanUtil.readInt("메뉴 선택");
		String name = ScanUtil.readStr("이름 입력");
		Gender gender = ScanUtil.readGender("성별 입력 : MAN or WOMAN");
		String phone = ScanUtil.readStr("연락처 입력");
		Person person = null;

		if (choice == 1) {
			person = new Person(name, gender, phone);

		} else if (choice == 2) {
			String school = ScanUtil.readStr("학교 입력");
			person = new Student(name, gender, phone, school);
		} else if (choice == 3) {
			String company = ScanUtil.readStr("회사 입력");
			person = new Worker(name, gender, phone, company);

		}
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("등록 성공");
	}
	
	private void showList() {
		String name = ScanUtil.readStr("조회 할 이름 입력");
		String gender = ScanUtil.readStr("조회 할 성별 입력 : MAN or WOMAN");
		while (true) {
			if (gender.equals("MAN") || gender.equals("WOMAN") || gender.equals(""))
				break;
			else gender = ScanUtil.readStr("조회 할 성별 입력 : MAN or WOMAN");
		} 	
			
		for (int i = 0; i < people.length; i++) {
			if(people[i] !=null) {
				if (!name.equals("") && !gender.equals("")) {
					if (people[i].getName().indexOf(name) != -1 && people[i].getGender().name().equals(gender))
						System.out.println(people[i].toString());
				} else if (!name.equals("")) {
					if (people[i].getName().indexOf(name) != -1)
						System.out.println(people[i].toString());
				} else if (!gender.equals("")) {
					if (people[i].getGender().name().equals(gender))
						System.out.println(people[i].toString());
				} else {
					System.out.println(people[i].toString());
				}
			}
		}
		
	}
	
	private void modify() {
		System.out.println("[목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] !=null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = ScanUtil.readInt("수정 할 사람 선택");
		String phone = ScanUtil.readStr("변경 할 연락처 입력");
		if (!phone.equals(""))
			people[num].setPhone(phone);
		
		if (people[num] instanceof Student) {
			String school = ScanUtil.readStr("변경할 학교 입력");
			if (!school.equals(""))
				((Student) people[num]).setSchool(school);
		} else if (people[num] instanceof Worker) {
			String company = ScanUtil.readStr("변경할 회사 입력");
			if (!company.equals(""))
				((Worker) people[num]).setCompany(company);
			
		}
		
		System.out.println("수정 완료.");
		
	}
	
	private void delete() {
		System.out.println("[목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] !=null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = ScanUtil.readInt("삭제 할 사람 선택");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 할 정보 없음");
		}
	}
		
	
	

}
