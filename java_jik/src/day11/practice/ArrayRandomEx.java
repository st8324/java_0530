package day11.practice;

public class ArrayRandomEx {

	public static void main(String[] args) {
		int min = 1, max = 9;
		int [] arr = new int[3];
		/*
		arr[0] = (int)(Math.random()*(max - min + 1) + min);
		arr[1] = (int)(Math.random()*(max - min + 1) + min);
		arr[2] = (int)(Math.random()*(max - min + 1) + min);
		*/
		for(int i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random()*(max - min + 1) + min);
			System.out.println(arr[i]);
		}
		/*
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		*/
	}

}
