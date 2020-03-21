package ua.lviv.lgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Number[] array = {3, 12, 87, 43, 24, 13, 10, 11, 12, 35, 67, 32, 12, 80, 98, 76, 21, 23, 47, 90};
		Collection collection = new Collection(array);
		Scanner scan = new Scanner(System.in);
		System.out.println("Our array: ");
		for(Number num:array){
			System.out.print(num+" ");
		}
		System.out.println();
		menu();
		int choice;
		if(scan.hasNextInt()){
			choice=scan.nextInt();
			switch (choice) {
				case 1: {
					System.out.println("The replacement of odd elements by zero: ");
					Iterator forwardIterator = collection.returnForwardIterator();
					while (forwardIterator.hasNext()) {
						System.out.print(forwardIterator.next() + " ");
					}
					break;
				}
				case 2: {
					Iterator backwardIterator = collection.returnBackwardIterator();
					System.out.println("Displaying the elements of array from the end, skipping a digit: ");
					while (backwardIterator.hasNext()) {
						System.out.print(backwardIterator.next() + " ");
					}
					break;
				}
				case 3: {
					Iterator anonymousIterator = collection.createdAnonymous();
					System.out.println("Displaying every third odd element of the array from the end:");
					while (anonymousIterator.hasNext()) {
						int num = anonymousIterator.next().intValue();
						if (num % 2 != 0)
							System.out.print(num + " ");
					}
					break;
				}
				case 4: {
					Iterator localIterator = collection.createdLocal();
					int i = 1;
					System.out.println("Checking every 5-th element of the array. If it's even - extract 100. Displaying the array after editing: ");
					while (localIterator.hasNext()) {
						int num = localIterator.next().intValue();
						if (i % 5 == 0) {
							if (num % 2 == 0)
								num -= 100;
						}
						i++;
						System.out.print(num + " ");
					}
					break;
				}
				case 5: {
					Iterator staticIterator = Collection.createdStaticIterator();
					int j = 1;
					System.out.println("Checking every second element of the array. Make the element odd if it was even. Displaying the array after editing:");
					while (staticIterator.hasNext()) {
						int num = staticIterator.next().intValue();
						if (j % 2 == 0) {
							if (num % 2 == 0)
								num--;
						}
						j++;
						System.out.print(num + " ");
					}
					break;
				}
			}
		} else {
			System.out.println("Enter a num, please...");
		}
	}
	public static void menu() {
		System.out.println("Enter a num of your choice: ");
		System.out.println("1. To check out the work of the 1-st inner class");
		System.out.println("2. To check out the work of the 2-nd inner class");
		System.out.println("3. To check out the work of the anonymous class");
		System.out.println("4. To check out the work of the local class");
		System.out.println("5. To check out the work of the static class");
	}

}
