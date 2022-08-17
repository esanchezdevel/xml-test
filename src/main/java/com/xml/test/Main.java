package com.xml.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.xml.test.dto.MyDTO;
import com.xml.test.dto.MySubDTO;
import com.xml.test.dto.MyWrapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		
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
		
		
		List<MyWrapper> listOfWrappers = new ArrayList<>();
		MyWrapper myWrapper1 = new MyWrapper();
		MyWrapper myWrapper2 = new MyWrapper();
		
		
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		map1.put("key1", "value1");
		map2.put("key2", "value2");
		
		myWrapper1.setMap(map1);
		myWrapper2.setMap(map2);
		
		listOfWrappers.add(myWrapper1);
		listOfWrappers.add(myWrapper2);
		
		MyDTO myDTO = new MyDTO();
		myDTO.setParam1(list);
		myDTO.setParam2("value 2");
		myDTO.setParam3(listOfWrappers);
		
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
		
		System.out.println("Convert to JSON");
		System.out.println("===============");
		System.out.println("");
		
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(myDTO);
		
		System.out.println(json);
	}
}
