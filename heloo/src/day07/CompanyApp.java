package day07;

public class CompanyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee em = new Employee();
		em.printInfo();
		em.no=2;
		em.name="김사원";
		em.dept="노무부";
		em.salary=7000;
		em.printInfo();
		
		Employee em2 = new Employee(5,"지혁준","노무현",6000);
		em2.printInfo();
	}

}
