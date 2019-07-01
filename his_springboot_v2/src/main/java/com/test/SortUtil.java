package com.test;

import io.swagger.models.auth.In;

import java.util.ArrayList;

/**
 * @ClassName SortUtil
 **/

public class SortUtil {

    /**
     * @Description 得到一个copyList 深拷贝
     * @Date 17:59 2019/6/29
     * @Param [head]
     * @return com.test.Node
     **/
    public static Node copyList(Node head) {
        Node copyHead = new Node();
        Node copy = copyHead;
        Node node = head;
        while (node.next != null){
            copy.next = new Node();
            copy.next.emp = node.next.emp.clone();
            node = node.next;
            copy = copy.next;
        }
        return copyHead;
    }
    /**
     * @Description 打印整个单链表
     * @Date 17:58 2019/6/29
     * @Param [head]
     * @return void
     **/
    public static void printList(Node head) {
        Node node = head;
        while (node.next != null){
            node.next.printEmployee();
            node = node.next;
        }
    }
    public static Employee  binarySearch(Node head,String key){
        //先把链表转为数组
        ArrayList<Node> es = new ArrayList<>();
        Node node = head;
        while (node.next != null){
            node = node.next;
            es.add(node);
        }
        //再进行二分查找
        int low = 0;//从0开始
        int high = es.size() - 1;//最高的下标
        while (low <= high) {//判断
            int mid = low + (high - low) / 2;//取中间值
            if (Integer.parseInt(es.get(mid).getEmp().getEno()) > Integer.parseInt(key))//判断中间值大是否大于需要查找的数组
                high = mid - 1;
            else if (Integer.parseInt(es.get(mid).getEmp().getEno())  < Integer.parseInt(key))
                low = mid + 1;
            else
                return es.get(mid).getEmp();
        }
        return null;
    }

    public static Node bubbleSort(Node copyHead) {
        Node node = copyHead;
        Node upper,cur,next,last;//upper表示之前一个结点，cur 表示当前的结点，next表示当前结点的下一个结点，cur与next是需要进行对比的
        upper = node;
        cur = node.next;
        next = cur.next;
        last = null;//标记最后的结点
        //当第二个节点为当次排序的最后一个节点时，整体排序结束
        while(node.next != last){
            //如果这一层次进行循环完成之后就会进行下一次的循环
            if(next == last){
                last = cur;
                cur = node.next;
                next = cur.next;
                upper = node;
            } else if(next.compare(cur)){//下一个结点与当前的一个结点进行对比，如果true，那么就进行调用位置，也就是把前一个的next换成next，如果false，那么就调下一个对比
                cur.next = next.next;
                next.next = cur;
                upper.next = next;
                upper = next;
            } else{
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
            //大于员工的emp的编号，p1向前走一步，交换p1与p2的值
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

}
