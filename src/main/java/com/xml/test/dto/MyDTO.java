package com.xml.test.dto;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "my-dto") //name of the first tag of the xml
@XmlAccessorType(XmlAccessType.FIELD) //all the object fields will be parsed in the xml
@XmlType(propOrder = {"param1", "param2"}) //order of the object parameters in the xml
public class MyDTO {

	@XmlElement(name = "param_1")
	private List<MySubDTO> param1;
	
	@XmlElement(name = "param_2")
	private String param2;

	public List<MySubDTO> getParam1() {
		return param1;
	}

	public void setParam1(List<MySubDTO> param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}
}
