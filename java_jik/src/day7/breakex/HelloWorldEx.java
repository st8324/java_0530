package day7.breakex;

public class HelloWorldEx {

	public static void main(String[] args) {
		int i = 1;
		while(true) {
			System.out.println("Hello world!");
			
			if(i==5) {
				break;
			}
			i++;
		}
	}

}
