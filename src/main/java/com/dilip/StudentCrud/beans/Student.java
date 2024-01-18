package com.dilip.StudentCrud.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stdbase")
public class Student {
	@Id
	@Column(name="id")
	public Integer stdid;
	private String stdname;
	private String branch;
	private String gmail;
	private int age;
	public Student() {
		super();
	}
	public Student(int stdid, String stdname, String branch, String gmail, int age) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.branch = branch;
		this.gmail = gmail;
		this.age = age;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", branch=" + branch + ", gmail=" + gmail + ", age="
				+ age + "]";
	}
	
	
	

}
