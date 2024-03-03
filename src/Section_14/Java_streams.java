package Section_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Java_streams {

	public static void main(String[] args) {
		
	
		
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("ajay");
//		names.add("rahul");
//		names.add("amy");
//		names.add("raj");
//		names.add("adam");
//		int count=0;
//		for (int i=0;i<names.size();i++) {
//			String name = names.get(i);
//			if(name.startsWith("a")) {
//				count++;
//			}
//		}
//System.out.println("The number of the count is starting with the letter is : "+count);
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("ajay");
		names.add("rahul");
		names.add("amy jackson");
		names.add("raj");
		names.add("adam");
		
		long c = names.stream().filter(s->s.startsWith("a")).count();
		System.out.println(c);
		
	
		long d = Stream.of("ajay","rahul","amy","raj","adam").filter(s->
		{
		s.startsWith("a");
		return true;
		}).count();
		System.out.println(d);
		
		//names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));
		
		//introducing map concept for further filtering of the condition
		Stream.of("Ajay","Rahul","Amy","raj","adam").filter(s->s.endsWith("y")).map(s->s.toUpperCase())
		.forEach(s-> System.out.println(s));
		
		
		List<String> name = Arrays.asList("Ajay","Rahul","Amy","Raj","Adam");
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		Stream<String> newStream = Stream.concat(names.stream(), name.stream());
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Amy"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		//using the collector to collect the value ion the list
		List<String> ls = Stream.of("Ajay","Rahul","Amy","raj","adam").filter(s->s.startsWith("A")).map(s->s.toLowerCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		//finding the unique number
		List<Integer> number = Arrays.asList(45,1,8,2,2,3,4,9,4,5,1,6,7,8,8,9);
		number.stream().distinct().forEach(s->System.out.println(s));
		
		//sort the array - 3rd index
		List<Integer> li = number.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
		
	}
	}


