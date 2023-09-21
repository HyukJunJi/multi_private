package day08;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superman se=new Superman("eden",1,2);

		Superman se1=new Superman("ddd",3);

		Superman se2=new Superman();

		Superman se3=new Superman("eden");
		
		Aquaman a1=new Aquaman();
		
		Aquaman a2=new Aquaman("aaa",10,3);
		
		Aquaman a3=new Aquaman("aaa");
		
		Aquaman a4=new Aquaman("aaa",39);
//
//		Aquaman ae1=new Aquaman("ddd",3);
//
//		Aquaman ae2=new Aquaman();
//
//		Aquaman ae3=new Aquaman("eden");
		
		Superman []arr= {se,se1,se2,se3};
		
		Aquaman []arr1= {a1,a2,a3,a4};
		
		for(Superman a:arr) {
			System.out.println(a.showInfo());
		}
		
		for(Aquaman a:arr1) {
			System.out.println(a.showInfo());
		}


	}

}
