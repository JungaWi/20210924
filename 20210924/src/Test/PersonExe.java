package Test;


public class PersonExe {

	private static PersonExe singleton = new PersonExe();
	private Person[] people;

	private PersonExe() {
		people = new Person[100];
		people[0] = new Person("ȫ�浿", Gender.MAN, "1111-2222");
		people[1] = new Person("��浿", Gender.MAN, "3333-4444");
		people[2] = new Student("������", Gender.WOMAN, "4444-5555", "����");
		people[3] = new Worker("������", Gender.WOMAN, "6666-7777", "�Ｚ");
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void execute() {
		while (true) {
			System.out.println("----------------------------");
			System.out.println("1.�߰� 2.��ȸ 3.���� 4.���� 5.����");
			System.out.println("----------------------------");
			int menu = ScanUtil.readInt("�޴��� �����ϼ���.");
			if (menu == 1) {
				System.out.println("�߰�");
				addPerson();
			} else if (menu == 2) {
				System.out.println("��ȸ");
				showList();
			} else if (menu == 3) {
				System.out.println("����");
				modify();
			} else if (menu == 4) {
				System.out.println("����");
				delete(); 
			} else if (menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			}
		}
		System.out.println("��");
	}

	private void addPerson() {
		System.out.println("1.��� 2.�л� 3.������");
		int choice = ScanUtil.readInt("�޴� ����");
		String name = ScanUtil.readStr("�̸� �Է�");
		Gender gender = ScanUtil.readGender("���� �Է� : MAN or WOMAN");
		String phone = ScanUtil.readStr("����ó �Է�");
		Person person = null;

		if (choice == 1) {
			person = new Person(name, gender, phone);

		} else if (choice == 2) {
			String school = ScanUtil.readStr("�б� �Է�");
			person = new Student(name, gender, phone, school);
		} else if (choice == 3) {
			String company = ScanUtil.readStr("ȸ�� �Է�");
			person = new Worker(name, gender, phone, company);

		}
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("��� ����");
	}
	
	private void showList() {
		String name = ScanUtil.readStr("��ȸ �� �̸� �Է�");
		String gender = ScanUtil.readStr("��ȸ �� ���� �Է� : MAN or WOMAN");
		while (true) {
			if (gender.equals("MAN") || gender.equals("WOMAN") || gender.equals(""))
				break;
			else gender = ScanUtil.readStr("��ȸ �� ���� �Է� : MAN or WOMAN");
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
		System.out.println("[���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] !=null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = ScanUtil.readInt("���� �� ��� ����");
		String phone = ScanUtil.readStr("���� �� ����ó �Է�");
		if (!phone.equals(""))
			people[num].setPhone(phone);
		
		if (people[num] instanceof Student) {
			String school = ScanUtil.readStr("������ �б� �Է�");
			if (!school.equals(""))
				((Student) people[num]).setSchool(school);
		} else if (people[num] instanceof Worker) {
			String company = ScanUtil.readStr("������ ȸ�� �Է�");
			if (!company.equals(""))
				((Worker) people[num]).setCompany(company);
			
		}
		
		System.out.println("���� �Ϸ�.");
		
	}
	
	private void delete() {
		System.out.println("[���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] !=null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = ScanUtil.readInt("���� �� ��� ����");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("���� �� ���� ����");
		}
	}
		
	
	

}
