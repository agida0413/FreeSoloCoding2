/*
 * 학생 클래스를 구현한다
맴버변수로는 name, hakbun 이 있다(외부에서 접근을 못하게 하려한다)

학생클래스는 일반학생클래스(추상클래스가 존재하고)
Void study 라는 메소드를 기능까지 구현하고있다. 
Void  eat 메소드는 정의만되어있다.
 또한 이 추상클래스는 sleepable이라는 인터페이스를 상속받고있다.
 sleepable 인터페이스는 void sleep이라는 메소드만 정의되어있다.
 
이 학생 클래스(추상클래스)를 상속받아 
1. 조원학생 클래스 (class NormalStudent)
2. 조장 학생 클래스(class LeaderStudent) -> void lead() 메소드 추가
를 구성하고 
서로 다른5명(조장1명 조원4명) 객체를 생성하라
홍신영 , 김용준 ,임하경 . . 박나현. . 객체


void study , void sleep는 모두 같은 기능을 구현하고 eat은 다른 기능을가진다.
모든 메소드는 println 을 통해 출력하는 기능만 가지고 있다 . ex) void sleep( ){println ( " 집에서 잠을잡니다." ) } ;  

 이게 완료가되면
 5명을 하나의 클래스로 묶을수있게 어레이리스트로 담아 모든 메소드 출력
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class sol {
	public static void main(String[] args) {
		sleepable a =new 임하경();
		sleepable b =new 김용준();
		
		List<sleepable> list =new ArrayList<sleepable>();
		list.add(a);
		list.add(b);
		
		for (sleepable sleepable : list) { 
			sleepable.sleep();
					
					
		}
		
		
//	List<Student> list = new ArrayList<Student>();
//	
//	list.add(new NormalStudent("김용준",1));
//	list.add(new NormalStudent("홍신영",2));
//	list.add(new NormalStudent("박나현", 3));
//	list.add(new NormalStudent("임하경", 4));
//	list.add(new LeaderStudent("정유나 ", 5));
//	
//	for (Student student : list) {
//	student.study();
//	student.eat();
//	student.sleep();
//	
//	if (student instanceof LeaderStudent) {
//		((LeaderStudent) student).lead();
//	}
//	
//	System.out.println("------------------------------");
//	}
//	}
}

abstract class Student implements sleepable{
	private String name ; 
	private int hakbun;
	Student(String name, int hakbun){
		this. name =name;
		this .hakbun = hakbun;
	}
	
	 void study() {
	System.out.println(this.name + "은 쌍용에서 공부합니다.");	
		
	}
	 abstract void eat();
	 
	@Override
	public void sleep() {
		System.out.println(this.name+ "은 집에서 잠을 잡니다.");
	}
}

interface sleepable {
	void sleep();
	
}

abstract class C {
	
}
class 김용준 extends C implements sleepable {

	@Override
	public void sleep() {
		System.out.println("2시에 잠을잡니다.");
		// TODO Auto-generated method stub
		
	}
	
}
class 임하경 extends C implements sleepable{

	@Override
	public void sleep() {
		System.out.println("12시에 잠을잡니다.");
		// TODO Auto-generated method stub
		
	}
	
}

class NormalStudent extends Student{

	NormalStudent(String name, int hakbun) {
		super(name, hakbun);
		// TODO Auto-generated constructor stub
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println("일반학생이므로 싼밥을 먹습니다.");
	}
	
}

class LeaderStudent extends Student{

	LeaderStudent(String name, int hakbun) {
		super(name, hakbun);
		// TODO Auto-generated constructor stub
	}
	@Override
	void eat() {
		// TODO Auto-generated method stub
		System.out.println("조장이므로 비싼밥을 먹습니다.");
	}
	void lead() {
		System.out.println("조장파워!! 리드한다!");
	}
}}

