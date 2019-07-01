package com.test;
//使用单向链表进行编写数据结构
public class Node  {
	Employee emp;
	Node next = null;//默认为null，通过判断是否为null用来表示该链表是否已经结束

	Node(){

	}

	public boolean compare(Node n){
		int i = this.emp.compareTo(n.getEmp());
		if(i == 1 || i == 0)
			return true;
		else
			return false;
	}

	public void printEmployee(){
		System.out.println(emp.eno + "+" + emp.name + "+" + emp.sex + "+" + emp.birth + "+" + emp.edu + "+" + emp.tel
				+ "+" + emp.add);
	}
	Node(Employee e){
		this.emp = e;
	}
	Node(Employee e,Node ne){
		this.emp = e;
		this.next = ne;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
