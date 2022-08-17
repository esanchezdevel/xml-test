package com.xml.test.dto;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

/**
 * 
 * @author esanchez
 * To parse an object to one XML, we need to have one ObjectFactory class 
 * located in the same package where is present our object. 
 * This ObjectFactory must be annotated with @XmlRegistry annotation and 
 * should have a create...method that returns a new instance of our object
 */

@XmlRegistry
public class ObjectFactory {

	private final static QName _MyDTO_QNAME = new QName("", "my-dto");
	private final static QName _MySubDTO_QNAME = new QName("", "my-sub-dto");
	
	public ObjectFactory() {
		
	}
	
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "my-dto")
    public JAXBElement<MyDTO> createMyDTO(MyDTO value) {
        return new JAXBElement<MyDTO>(_MyDTO_QNAME, MyDTO.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MySubDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "my-sub-dto")
    public JAXBElement<MySubDTO> createMySubDTO(MySubDTO value) {
        return new JAXBElement<MySubDTO>(_MySubDTO_QNAME, MySubDTO.class, null, value);
    }
}
