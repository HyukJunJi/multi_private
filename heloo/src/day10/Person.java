package day10;
//도메인 (domain) 객체(VO-Value Object, DTO-Data Transfer Object)
public class Person {
	private String name;
	private int age;
	public Person() {
		this("아무개",1);
	}
	public Person(String n,int a) {
		name=n; age=a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/*이름과 나이가 같으면 해시셋에 중복 저장되지 않도록
	 * hashCode()와 equals()를 오버라이드 하자
	 * -------------------------------------------
	 *  해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서
	 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
	 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
	 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
	 *   중복 저장을 하지 않는다.
	 * --------------------------------------------
	 * */
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p =(Person) obj;
			boolean bool =(this.name.equals(p.name)&&this.age==p.age);
			return bool;
		}else {
			return false;
		}
		
	}
}
