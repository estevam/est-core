package com.est.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		int first;
		int second;

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				list.add(1);
			} else if (i == 1) {
				list.add(1);
			} else {
				int x = i - 2;
				first = list.get(x);
				int y = i - 1;
				second = first + list.get(y);

				list.add(second);

				System.out.println(second);
			}

		}
		System.out.println(list.toString());
	}

}
