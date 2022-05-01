package com.atguigu.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        //测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
    }
}

//创建一个环形单向链表
@SuppressWarnings({"all"})
class CircleSingleLinkedList {
    //创建一个first节点， 当前没有编号
    private Boy first = null;
    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if(nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针， 帮助构建环形链表
        //使用for来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1) {
                first = boy;
                first.setNext(first); //构成换
                curBoy = first; //让curBoy指向第一个小孩
            }else {
                curBoy.setNext(boy); //
                boy.setNext(first);
//                curBoy = boy;
                curBoy = curBoy.getNext();
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        if(first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if(curBoy.getNext() == first) { //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); //curBoy后移
        }
    }

}


//创建一个Boy类， 表示一个节点
class Boy {
    private int no; //编号
    private Boy next; //指向下一个节点， 默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}