package com.xml.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.xml.test.dto.MyDTO;
import com.xml.test.dto.MySubDTO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Convert one object to XML format");
		System.out.println("================================");
		System.out.println("");
		
		MySubDTO mySubDTO1 = new MySubDTO();
		mySubDTO1.setSubParam1("sub value 1-1");
		mySubDTO1.setSubParam2("sub value 1-2");

		MySubDTO mySubDTO2 = new MySubDTO();
		mySubDTO2.setSubParam1("sub value 2-1");
		mySubDTO2.setSubParam2("sub value 2-2");
		
		List<MySubDTO> list = new ArrayList<>();
		
		list.add(mySubDTO1);
		list.add(mySubDTO2);
		
		MyDTO myDTO = new MyDTO();
		myDTO.setParam1(list);
		myDTO.setParam2("value 2");
		
		try {
			JAXBContext jc = JAXBContext.newInstance("com.xml.test.dto");
			
			Marshaller m = jc.createMarshaller();
	        m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
	        
	        
	        StringWriter sw = new StringWriter();
	        m.marshal(myDTO, sw);
			
	        System.out.println("RESULT:");
	        System.out.println(sw.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
