package com.est.fibonacci;

import java.util.Scanner;

class FibonacciArray {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			long f = fib(i);
			System.out.println("fib(" + i + ") = " + f);
		}
	}

	public static long fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	
	public int getFib(int index) {
		if (index == 0)
			return 0;

		if (index == 1)
			return 1;

		int first = 0;
		int second = 1;
		int result = 0;

		for (int i = 1; i < index; i++) {
			result = first + second;
			first = second;
			second = result;
		}

		return result;
	}

}
