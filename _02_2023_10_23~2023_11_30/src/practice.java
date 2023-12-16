import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.Builder.Default;

public class practice {
public static void main(String[] args) {
// eatable = > 인터페이스 이름
	// 인터페이스를  구현  = > void eat () 메소드가 정의만 되어있습니다.
	//eatable 이라는 인터페이스에는 void babgrut() 이라는 메소드가 정의되어있는데 println("밥그릇을 이용해서 먹습니다 " )  구현이되어있다.
	
	
	//푸들 클래스   = > 젅부 eatable 이라는 인터페이스를 상속받음  
	//말티즈 클래스
	//비숑 클래스 


public void 푸들 implements eatable()
{
	
}

public void 말티즈 ()
{
	
}

public void 비숑 ()
{
	
}

/*
 * 푸들 : 푸들처럼 먹습니다 
 * 		밥그릇을 이용해서 먹습니다
 * 
 * 말티즈 : 말티즈처럼 먹습니다 
 * 		밥그릇을 이용해서 먹습니다
 * 비숑 : 비숑처럼 먹습니다 
 * 		밥그릇을 이용해서 먹습니다
 * 
 */
	
}
interface eatable
{
	public static void eat()
	{
		
	};

	public static void babgrut() {
		System.out.println("밥그릇을 이용해서 먹습니다");
	};
}
}

