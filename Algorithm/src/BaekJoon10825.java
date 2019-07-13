import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10825 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		Subject[] subject = new Subject[N];
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			int korean = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();

			subject[i] = new Subject(name, korean, english, math);
		}

		Arrays.sort(subject);
		for (int i = 0; i < subject.length; i++) {
			System.out.println(subject[i].getName());
		}
	}
}

class Subject implements Comparable<Subject> {
	private String name;
	private int korean;
	private int english;
	private int math;

	public Subject() {

	}

	public Subject(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public int compareTo(Subject o) {
		if (this.korean != o.korean) {
			return o.korean - this.korean;
		} else if (this.english != o.english) {
			return this.english - o.english;
		} else if (this.math != o.math) {
			return o.math - this.math;
		} else {
			return this.name.compareTo(o.name);
		}
	}

}