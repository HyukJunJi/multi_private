package day07;

public class School2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher te = new Teacher();
		Teacher te1 = new Teacher(2,"지혁준","수학",'M');
		te.printInfo();
		te1.printInfo();
		
		
//		Object teacher[]= {te,te1};
//		for(Object a:teacher) {
//			System.out.println(a);
//		}
		Teacher[] tea= new Teacher[2];
		tea[0]=te;
		tea[1]=te1;
		for(Teacher a:tea) {
			System.out.println(a);
		}
		
	}

}
