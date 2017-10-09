package com.esslib.makefiletool;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import net.sourceforge.makefileparser.Parser;
import net.sourceforge.makefileparser.managers.VariableManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Main()).test();
	}
	
	

	public void test() {
		System.out.println("hello");
		Parser s = new Parser(new VariableManager());
		try {
			
			File f =  new File("Makefile");
			
			if (!f.exists()) {
				return;
			}
			
			
			s.parse(f);
			System.out.println(s.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

 

 
	 

}
