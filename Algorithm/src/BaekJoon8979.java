import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon8979 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Olympic[] olympics = new Olympic[N];
		for (int i = 0; i < N; i++) {
			int nation = sc.nextInt();
			int gold = sc.nextInt();
			int silver = sc.nextInt();
			int bronze = sc.nextInt();
			olympics[i] = new Olympic(nation, gold, silver, bronze);
		}
		Arrays.sort(olympics);
		int rank = 0;
		for (int i = 0; i < olympics.length; i++) {
			if (K == olympics[i].getNation()) {
				rank = i;
				break;
			}
		}

		int result = rank;
		for (int i = 0; i < rank; i++) {
			if (olympics[i].getGold() == olympics[rank].getGold()
					&& olympics[i].getSilver() == olympics[rank].getSilver()
					&& olympics[i].getBronze() == olympics[rank].getBronze()) {
				result = i;
				break;
			}
		}
		System.out.println(result + 1);
	}
}

class Olympic implements Comparable<Olympic> {
	private int nation;
	private int gold;
	private int silver;
	private int bronze;

	public Olympic() {
		super();
	}

	public Olympic(int nation, int gold, int silver, int bronze) {
		super();
		this.nation = nation;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	@Override
	public int compareTo(Olympic o) {
		if (this.gold != o.gold) {
			return o.gold - this.gold;
		} else if (this.silver != o.silver) {
			return o.silver - this.silver;
		} else if (o.bronze != this.bronze) {
			return o.bronze - this.bronze;
		} else {
			return 0;
		}
	}

}