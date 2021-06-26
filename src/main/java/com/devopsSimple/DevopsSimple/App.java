package com.devopsSimple.DevopsSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.github.axet.vget.VGet;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		
		  VGet v;
		Test t=new Test();
		System.out.println( "Hello World! " +t.additionner.apply(4, 5));
	//-------------------------------------------------------------------------------------------------------	
		
		//https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
		
		// Consumer to display a number 
        Consumer<Integer> display = a -> System.out.println(a); 
  
        // Implement display using accept() 
        display.accept(10); 
  
        // Consumer to multiply 2 to every integer of a list 
        Consumer<List<Integer> > modify = list -> 
        { 
            for (int i = 0; i < list.size(); i++) 
                list.set(i, 2 * list.get(i)); 
        }; 
  
        // Consumer to display a list of numbers 
        Consumer<List<Integer> > dispList = list -> list.stream().forEach(a -> System.out.print(a + " ")); 
  
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(2); 
        list.add(1); 
        list.add(3); 
        //list.set(list.size()-1,4);
  
        // Implement modify using accept() 
        modify.accept(list); 
  
        // Implement dispList using accept() 
        dispList.accept(list); 
        
        
        // combiner les deux etapes en utilisant la methode default de l'imterface 
        // using addThen() 
        modify.andThen(dispList).accept(list); 
        ; 
		
	}
}
