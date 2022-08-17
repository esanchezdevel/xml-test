package com.xml.test.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"subParam1", "subParam2"})
public class MySubDTO {

	@XmlElement(name = "sub_param_1")
	private String subParam1;
	
	@XmlElement(name = "sub_param_2")
	private String subParam2;

	public String getSubParam1() {
		return subParam1;
	}

	public void setSubParam1(String subParam1) {
		this.subParam1 = subParam1;
	}

	public String getSubParam2() {
		return subParam2;
	}

	public void setSubParam2(String subParam2) {
		this.subParam2 = subParam2;
	}
}
