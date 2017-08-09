
class Student {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}

public class Test01 {

	public static void change(Student stu) {
		// stu.setName("Tom");
		// stu.setAge(20);
		stu = new Student("Tom", 20);
	}
	
	public static void change(String str) {
		str = new String("good");
	}
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		System.out.println("\u9a86\u660a");
		String str1 = "Programming";
		String str2 = new String("Programming");
		String str3 = "Program" + "ming";
		String str4 = "Program";
		String str5 = "ming";
		String str6 = str4 + str5;
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str6);
		Student stu = new Student("Jerry", 10);
		change(stu);
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
	}
}
