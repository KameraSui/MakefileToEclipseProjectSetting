package com.esslib.makefiletool;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import net.sourceforge.makefileparser.Parser;
import net.sourceforge.makefileparser.managers.VariableManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Main()).verifyXML();
	}

	public void convert() {

		// lib:makefile parser
		// https://sourceforge.net/projects/makefileparser/?source=navbar

		System.out.println("hello");

		String cincludes = null;
		// try parse
		try {
			VariableManager vv = new VariableManager();
			Parser s = new Parser(vv);
			File f = new File("Makefile");
			if (!f.exists()) {
				return;
			}
			s.parse(f);
			// C_INCLUDE

			cincludes = vv.getValue("C_INCLUDE");

			System.out.println(cincludes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 得到include列表
		if (cincludes != null) {
			// 去掉空格
			cincludes = cincludes.replace(" ", "");
			String[] incs = cincludes.split("-I");

			for (String i : incs) {
				System.out.println(i);
			}

		}
	}

	void verifyXML() {

		// .target_cproject
		try {

			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(".target_cproject"));

			Element root = document.getRootElement();

			Element f = __searchForAttr(root.elements(), "name", "GNU C");
			
			if (f != null) {

				 System.out.println(f.asXML());

				Element opt = f.element("option");
				if (opt != null) {
					
					for(Element so : opt.elements()){
						System.out.println(so.asXML());
						System.out.println(so.attributeValue("value"));
					}
					
				}

			} else {
				System.out.println("found none");
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	Element __searchForAttr(List<Element> l, String attr, String value) {

		for (Element e : l) {

			// System.out.println("Searching " + e.getName());

			if (e.attribute(attr) != null) {
				// System.out.println(">>>> " + e.attribute(attr).getValue());
			}

			if (e.attribute(attr) != null) {
				if (e.attributeValue(attr).equals(value))
					return e;
			}

			if (e.elements().size() > 0) {

				Element f = __searchForAttr(e.elements(), attr, value);
				if (f != null) {
					return f;
				}
			}

		}

		return null;
	}

}
