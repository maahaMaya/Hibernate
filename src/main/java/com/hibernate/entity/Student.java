package com.hibernate.entity;

public class Student {

	private int sno;
	private String sname;
	private double smarks;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSmarks() {
		return smarks;
	}

	public void setSmarks(double smarks) {
		this.smarks = smarks;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", smarks=" + smarks + "]";
	}
	
	

}
