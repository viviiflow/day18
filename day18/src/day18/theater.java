package day18;

import java.util.Scanner;

class Ticket {
	boolean chk;
	static int cnt = 0;

	void showdata() {
		if (chk == true) {
			System.out.print("■ ");
		} else {
			System.out.print("□ ");
		}
	}
}

class Function {
	Scanner sc = new Scanner(System.in);
	String name = "";

	void showmenu() {
		System.out.println("====" + name + "====");
		System.out.println("[1]자리 예매");
		System.out.println("[2]계산");
		System.out.println("[3]종료");
	}

	void paymoney() {
		System.out.println("총 금액은 " + (Ticket.cnt * 12000) + "원입니다.");
		System.out.println("결제할 금액을 입력해주세요");
		int money = sc.nextInt();
		System.out.println("반환 금액은: " + ((money - (Ticket.cnt * 12000))) + "원입니다.");
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
		movie.name = "메가박스";
		while (true) {
			movie.showmenu();
			for (int i = 0; i < tk.length; i++) {
				tk[i].showdata();
			}

			System.out.println();
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("번호를 입력하세요: ");
				int slt = sc.nextInt();
				if (tk[slt].chk == false) {
					tk[slt].chk = true;
					tk[slt].cnt++;
				} else {
					System.out.println("이미 예매된 자리입니다.");
				}
			} else if (choice == 2) {
				movie.paymoney();
			} else if (choice == 3) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
