package com.fastcode.inf.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class SystemResponse implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -929336147248496337L;
	
	private Integer status;
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
