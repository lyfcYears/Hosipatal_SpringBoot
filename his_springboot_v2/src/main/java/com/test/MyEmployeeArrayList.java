package com.test;

/**
 * @ClassName MyEmployeeArrayList
 * @Description 这个类是用来对于单链表的存储，并且提供查找方法以及排序算法
 * 其中排序算法有 冒泡排序、快速排序、希尔排序
 * 查找算法有 二分查找
 * @Date 2019/6/29 15:46
 * @Version 1.0
 **/
//这个类仅仅是作用于排序和查找，传入一个头结点，并且该头结点是具有
    //next的数据的，不包含add方法
public class MyEmployeeArrayList {
    //头结点
    Node head ;

    public MyEmployeeArrayList(Node head){
        this.head = head;

    }
    //冒泡排序
    /**
     * @Description 对于head结点进行冒泡排序
     * 冒泡排序的思路：二二对比，交互位置。
     * @Date 16:05 2019/6/29
     * @Param []
     * @return com.test.Node
     **/
    public Node blueSortList(){
        Node node = this.head;
        Node upper,cur,next;//upper表示之前一个结点，cur 表示当前的结点，next表示当前结点的下一个结点，cur与next是需要进行对比的
        upper = node;
        cur = node.next;
        next = cur.next;
        //一次排序的最后一个节点
        Node lastNode = null;
        int i = 1;
        //当第二个节点为当次排序的最后一个节点时，整体排序结束
        while(node.next != lastNode){
            //如果这一层次进行循环完成之后就会进行下一次的循环
            if(next == lastNode){
                lastNode = cur;
                cur = node.next;
                next = cur.next;
                upper = node;
            }else if(next.compare(cur)){//下一个结点与当前的一个结点进行对比，如果true，那么就进行调用位置，也就是把前一个的next换成next，如果false，那么就调下一个对比
                cur.next = next.next;
                next.next = cur;
                upper.next = next;
                upper = next;
            }else{
                upper = cur;
                cur = cur.next;
            }
            next = cur.next;
        }
        return node;
    }


    public static void quickSort(Node head, Node end) {
       //判断是否为同一个
        if (head != end) {
            Node node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }
    public static Node partion(Node head, Node end) {
        Node p1 = head, p2 = head.next;
        //走到末尾才停
        while (p2 != end) {
            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.compare(head)) {
                p1 = p1.next;
                Employee temp = p1.emp;
                p1.emp = p2.emp;
                p2.emp = temp;
            }
            p2 = p2.next;
        }
        //当有序时，不交换p1和key值
        if (p1 != head) {
            Employee temp = p1.emp;
            p1.emp = head.emp;
            head.emp = temp;
        }
        return p1;
    }


    public void printList(Node next) {
        next = next.next;
        next.printEmployee();
        while (next.next != null){
            next = next.next;
            next.printEmployee();
        }
    }

    public void printList() {
        Node next = head.next;
        next.printEmployee();
        while (next.next != null){
            next = next.next;
            next.printEmployee();
        }
    }


}
