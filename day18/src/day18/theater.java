package day18;

import java.util.Scanner;

class Ticket {
	boolean chk;
	static int cnt = 0;

	void showdata() {
		if (chk == true) {
			System.out.print("�� ");
		} else {
			System.out.print("�� ");
		}
	}
}

class Function {
	Scanner sc = new Scanner(System.in);
	String name = "";

	void showmenu() {
		System.out.println("====" + name + "====");
		System.out.println("[1]�ڸ� ����");
		System.out.println("[2]���");
		System.out.println("[3]����");
	}

	void paymoney() {
		System.out.println("�� �ݾ��� " + (Ticket.cnt * 12000) + "���Դϴ�.");
		System.out.println("������ �ݾ��� �Է����ּ���");
		int money = sc.nextInt();
		System.out.println("��ȯ �ݾ���: " + ((money - (Ticket.cnt * 12000))) + "���Դϴ�.");
	}
}

public class theater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ticket[] tk = new Ticket[8];
		for (int i = 0; i < tk.length; i++) {
			tk[i] = new Ticket();
		}
		Function movie = new Function();
		movie.name = "�ް��ڽ�";
		while (true) {
			movie.showmenu();
			for (int i = 0; i < tk.length; i++) {
				tk[i].showdata();
			}

			System.out.println();
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("��ȣ�� �Է��ϼ���: ");
				int slt = sc.nextInt();
				if (tk[slt].chk == false) {
					tk[slt].chk = true;
					tk[slt].cnt++;
				} else {
					System.out.println("�̹� ���ŵ� �ڸ��Դϴ�.");
				}
			} else if (choice == 2) {
				movie.paymoney();
			} else if (choice == 3) {
				System.out.println("�����մϴ�.");
				break;
			}
		}
	}
}
