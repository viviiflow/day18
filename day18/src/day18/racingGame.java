package day18;

import java.util.Random;

class Horse {
	String name = "";
	int pos = 0, rank = 0;
	boolean win = false;
}

class Racing {
	Random ran = new Random();
	String name = "";
	int size = 4, line = 20;
	Horse[] h = new Horse[size];
	int[][] track = new int[size][line];

	void showNum() {
		int cnt = 0, re =-1;
		for (int i = 0; i < 4; i++) {
			if (h[i].win == false) {
				re=h[i].pos;
				track[i][h[i].pos] = 0;
				h[i].pos += ran.nextInt(5)+1;
				try {
					track[i][h[i].pos] = 1;
					System.out.println(h[i].name + "번 말: " + h[i].pos);
				} catch (Exception e) {
					if (cnt == 0) {
						h[i].win = true;
						track[i][19] = 1;
						cnt++;
					} else {
						if(re==19) {
							re--;
						}
						h[i].pos=re;
						i--;
					}
				}
			}
		}
	}

	void showrace() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 20; j++) {
				if (track[i][j] != 0) {
					System.out.print("[" + h[i].name + "]");
				} else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
}

public class racingGame {
	public static void main(String[] args) {
		Racing race = new Racing();
		int num = 1;
		for (int i = 0; i < race.size; i++) {
			race.h[i] = new Horse();
			race.h[i].name = (i + 1) + "";
			race.track[i][0] = 1;
		}
		race.name = "경마 게임";
		System.out.println("======" + race.name + "======");
		System.out.println("!선수 준비!");
		race.showrace();
		while (true) {
			System.out.println("===============");
			race.showNum();
			if(num!=4) {
				race.showrace();
			}
			for (int i = 0; i < race.size; i++) {
				if ((race.h[i].win == true) && (race.h[i].rank == 0)) {
					race.h[i].rank = num;
					num++;
				}
			}
			if (num > 4) {
				break;
			}
		}
		System.out.println("==========결과==========");
		for (int i = 0; i < 4; i++) {
			System.out.println(race.h[i].name + "번 말: " + race.h[i].rank + "등");
		}
	}
}
