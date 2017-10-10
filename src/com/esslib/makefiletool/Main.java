package com.esslib.makefiletool;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import net.sourceforge.makefileparser.Parser;
import net.sourceforge.makefileparser.managers.VariableManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Main()).convert();
	}

	public void convert() {
		
		//lib:makefile parser 
		//https://sourceforge.net/projects/makefileparser/?source=navbar
		
		System.out.println("hello");
		
		String cincludes = null;
		//try parse
		try {
			VariableManager vv = new VariableManager();
			Parser s = new Parser(vv);
			File f =  new File("Makefile");
			if (!f.exists()) {
				return;
			}
			s.parse(f);
			//C_INCLUDE
			
			cincludes =  vv.getValue("C_INCLUDE");
			
			System.out.println(cincludes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//得到include列表
		if(cincludes != null ) {
			//去掉空格
			cincludes = cincludes.replace(" ", "");
			String[] incs =  cincludes.split("-I");
			
			for (String i : incs) {
				System.out.println(i);
			}
			
		}		
	}

 

 
	 

}
