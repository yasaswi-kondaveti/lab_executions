package com.klu.StudentApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	private int sid;
	@Column
	private int sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSname() {
		return sname;
	}
	public void setSname(int sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public int getSnail() {
		return snail;
	}
	public void setSnail(int snail) {
		this.snail = snail;
	}
	@Column
	private int sage;
	@Column
	private int snail;
	
	

}