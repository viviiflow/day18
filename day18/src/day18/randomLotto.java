package day18;

import java.util.Random;

class Lotto {
	int[] data = new int[8];
	boolean win = false;

	void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
}

public class randomLotto {
	public static void main(String[] args) {
		Random ran = new Random();
		Lotto[] lt = new Lotto[5];
		boolean chk = false;
		while (true) {
			for (int i = 0; i < lt.length; i++) {
				lt[i] = new Lotto();
				for (int j = 0; j < lt[i].data.length; j++) {
					lt[i].data[j] = ran.nextInt(2);
				}
				for (int k = 0; k < lt[i].data.length; k++) {
					try {
						if (((lt[i].data[k - 1]) == 1) && ((lt[i].data[k]) == 1) && ((lt[i].data[k + 1]) == 1)) {
							if ((lt[i].win == false) && (chk == false)) {
								lt[i].win = true;
								chk = true;
							} else {
								int n = -1;
								for (int h = 0; h < lt.length; h++) {
									if (lt[h].win == true) {
										n = h;
									}
								}
								if (n == i) {
									lt[i].win = false;
									chk = false;
									i--;
									break;
								} else {
									lt[i].win = false;
									i--;
									break;
								}
							}
						}
					} catch (Exception e) {
					}
				}
			}
			if (chk == true) {
				for (int i = 0; i < lt.length; i++) {
					if (lt[i].win == true) {
						lt[i].print();
						System.out.println("\t:´çÃ·");
					} else {
						lt[i].print();
						System.out.println();
					}
				}
				break;
			}
		}
	}
}
