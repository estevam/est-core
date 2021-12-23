/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.streams;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author estevam
 */
public class TestStreams {

	private static MyStreams test = new MyStreams();

	public static void main(String ards[]) {
		test.readTextFile();
		test.readPerson();
	}

	static class MyStreams {

		public MyStreams() {
		}

		public void readTextFile() {
			List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
	 		list.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
	
		}

		public void readPerson() {
	        /*		
	        List<Person> persons = new ArrayList<Person>();
			persons.add(new Person("Peter", 23));
			persons.add(new Person ("Pamela", 23));
			persons.add(new Person("David", 12));
			List<Person> filtered = persons.stream().filter(p -> p.name.startsWith("P")).collect(Collectors.toList());

			System.out.println(filtered);
			*/

		}

	}

	class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return name;
		}
	}

}
