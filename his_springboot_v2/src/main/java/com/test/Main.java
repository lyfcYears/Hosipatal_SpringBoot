package com.test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static void menu() {
		System.out.println("~~~~~~~~~2019员工管理系统菜单~~~~~~~~~");
		System.out.println("~~~~~~~~~~1.显示所有员工信息~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~2.排序员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~3.添加员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~4.修改员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~5.删除员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~6.查询员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~7.导出员工信息~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~0.退出员工系统~~~~~~~~~~~~");
	}

	//向头结点添加几条测试的数据
	public static Node addTestData(Node head){
		Employee s1 = new Employee("111452","张三","男","20190421","本科","115245845","北京市小行星路");
		Employee s2 = new Employee("115226","李四","男","18892563","博士","255455557","珊瑚路");
		Employee s3 = new Employee("114785","小红","女","19940514","博士","154544578","上海");
		Employee s4 = new Employee("415326","大卫","男","19990303","高中","122565545","宁波大桥");
		Node n1 = new Node(s1);
		Node n2 = new Node(s2);
		Node n3 = new Node(s3);
		Node n4 = new Node(s4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n4;
	}


	public static void main(String[] args) {

		Employee s0 = new Employee("115445","BOSS","男","20190421","本科","115245845","北京市小行星路");
		Node head = new Node();
		head.next = new Node(s0);
		//添加几条数据
		Node current = addTestData(head.next);

		Scanner scn = new Scanner(System.in);
		String cmd = "";

		do {
			menu();
			System.out.println("请输入你的选项（0-7）");
			cmd = scn.nextLine();

			if (cmd.equals("1")) {
				Node tmp = head.next;

				while (tmp != null) {
					Employee s = tmp.emp;
					System.out.println(s.eno + "+" + s.name + "+" + s.sex + "+" + s.birth + "+" + s.edu + "+" + s.tel
							+ "+" + s.add);
					tmp = tmp.next;
				}
			}

			else if (cmd.equals("2")) {
				System.out.println("排序实现 输入1进行冒泡排序；输入2进行快速排序");
				int key = scn.nextInt();
				if(key == 1){
					//先进行对该单链表进行copy，不然排序之后这个链表对象也是排序之后的结果就无法进行其他的排序测试了
					Node copyHead = SortUtil.copyList(head);
					System.out.println("冒泡排序前");
					SortUtil.printList(copyHead);
					Node h = SortUtil.bubbleSort(copyHead);
					System.out.println("冒泡排序后");
					SortUtil.printList(h);
				} else if(key == 2){
					Node copyHead = SortUtil.copyList(head);
					System.out.println("快速排序前");
					SortUtil.printList(copyHead);
					SortUtil.quickSort(copyHead.next,null);
					System.out.println("快速排序后");
					SortUtil.printList(copyHead);
				}
			}

			else if (cmd.equals("3")) {
				System.out.println("欢迎新员工加入，请输入新员工相关信息！");
				System.out.println("请输入员工码");
				String eno = scn.nextLine();
				System.out.println("请输入员工姓名");
				String name = scn.nextLine();
				System.out.println("请输入员工性别");
				String sex = scn.nextLine();
				System.out.println("请输入员工生日");
				String birth = scn.nextLine();
				System.out.println("请输入员工学历");
				String edu = scn.nextLine();
				System.out.println("请输入员工电话");
				String tel = scn.nextLine();
				System.out.println("请输入员工地址");
				String add = scn.nextLine();
				Employee s = new Employee(eno, name, sex, birth, edu, tel, add);
				Node node = new Node();
				node.emp = s;
				current.next = node;
				current = node;
				System.out.println("添加成功！");
			}
			else if (cmd.equals("4")) {
				System.out.println("请输入需要修改的员工信息");
				String eno = scn.nextLine();
				Node tmp = head.next;
				while (tmp != null && !tmp.emp.eno.equals(eno)) {
					tmp = tmp.next;
				}
				if (tmp != null) {
					System.out.println("请输入需要修改的选项");
					System.out.println("1.学历");
					String edu = scn.nextLine();
					System.out.println("2.电话");
					String tel = scn.nextLine();
					System.out.println("3.地址");
					String add = scn.nextLine();
					Employee s = tmp.emp;
					s.edu = edu;
					s.tel = tel;
					s.add = add;
					System.out.println("修改成功！");
				}
			}

			else if (cmd.equals("5")) {
				System.out.println("请输入离职员工的员工码");
				String eno = scn.nextLine();
				Node pre = head;
				Node tmp = head.next;
				while (tmp != null && !tmp.emp.eno.equals(eno)) {
					pre = tmp;
					tmp = tmp.next;
				}
				if (tmp != null) {
					pre.next = tmp.next;
					System.out.println("已删除该员工！");
				}
			}

			else if (cmd.equals("6")) {
				//首先需要进行排序
				Node copyHead = SortUtil.copyList(head);
				SortUtil.quickSort(copyHead.next,null);
				System.out.println("请输入你要查找员工的编号");
				String nid = scn.nextLine();
				Employee employee = SortUtil.binarySearch(copyHead, nid);
				if(employee == null){
					System.out.println("该编号未存在");
				}else{
					System.out.println("存在成功,信息如下：");
					employee.printEmployee();
				}
			}

			else if (cmd.equals("7")) {
				System.out.println("请输入保存路径");
				String filepath = scn.nextLine();
				try {
					FileWriter fw = new FileWriter(filepath);
					Node tmp = head.next;
					while (tmp != null) {
						Employee s = tmp.emp;
						fw.write(s.eno + "\t" + s.name + "\t" + s.sex + "\t" + s.birth + "\t" + s.edu + "\t" + s.tel
								+ "\n" + s.add);
						fw.flush();
						tmp = tmp.next;
					}
					fw.close();
					System.out.println("导出员工信息成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} while (!cmd.equals("0"));
		System.out.println("退出成功！");
		scn.close();
		System.exit(0);
	}
}
