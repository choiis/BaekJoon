import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10814 {
	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();

		Member[] member = new Member[N];
		for (int i = 0; i < member.length; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			member[i] = new Member(age, name, i);
		}

		Arrays.sort(member);
		for (int i = 0; i < member.length; i++) {
			System.out.println(member[i]);
		}
	}
}

class Member implements Comparable<Member> {
	private int age;
	private String name;
	private int idx;

	public Member() {
	}

	public Member(int age, String name, int idx) {
		super();
		this.age = age;
		this.name = name;
		this.idx = idx;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public int compareTo(Member o) {
		if (this.age != o.age) {
			return this.age - o.age;
		} else {
			return this.idx - o.idx;
		}
	}

	@Override
	public String toString() {
		return age + " " + name;
	}

}