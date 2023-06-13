package day10.singleton;

public class SingleTonEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SamsungCompany company = new SamsungCompany();
		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		System.out.println(company1);
		System.out.println(company2);
	}

}

class SamsungCompany{
	
	private static SamsungCompany company = new SamsungCompany();
	
	private String name;
	private String address;
	
	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
	}
	public static SamsungCompany getInstance() {
		return company;
	}
}






