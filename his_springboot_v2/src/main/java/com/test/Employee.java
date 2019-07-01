package com.test;
//定义一个Employee实体对象员工
public class Employee implements Comparable<Employee> ,Cloneable{
	String eno;//编号 是数字类型
	String name;
	String sex;
	String birth;
	String edu;
	String tel;
	String add;

	/**
	 * @Description 进行比较的接口方法，比较也可以作为排序的规则，按编号的大小进行比较
	 * @Date 15:04 2019/6/29
	 * @Param
	 * @return 0 是表示二者相同，1表示0>this  -1表示o<this
	 **/
	@Override
	public int compareTo(Employee o) {
		if(o.getEno().equals(this.getEno()))
			return 0;
		else
			return Long.parseLong(o.getEno()) > Long.parseLong(this.getEno())? 1 : -1;
	}

	public void printEmployee(){
		System.out.println(this.eno + "+" + this.name + "+" + this.sex + "+" + this.birth + "+" + this.edu + "+" + this.tel
				+ "+" + this.add);
	}

	public Employee(String eno, String name, String sex, String birth, String edu, String tel, String add) {
		super();
		this.eno = eno;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.edu = edu;
		this.tel = tel;
		this.add = add;
	}

	@Override
	public Employee clone() {
		Employee emp = null;
		try{
			emp = (Employee) super.clone();   //浅复制
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return emp;
	}
	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}


}
