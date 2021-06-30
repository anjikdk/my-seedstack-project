package org.generated.project.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.seedstack.business.domain.BaseAggregateRoot;

@Entity
public class Student extends BaseAggregateRoot<Integer>{

	@Id
	private Integer stdId;
	private String fname;
	private String lname;
	
	private Student()
	{
		
	}
	
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", fname=" + fname + ", lname=" + lname + "]";
	}
}
