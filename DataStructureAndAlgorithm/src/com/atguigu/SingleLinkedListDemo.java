package com.atguigu;

import java.io.PrintStream;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);

        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示一把
//        singleLinkedList.list();
//        //修改节点信息
//        singleLinkedList.update(new HeroNode(2,"hsp","hsp"));
//        singleLinkedList.list();
//
//        System.out.println("=======测试删除节点========");
////        singleLinkedList.del(1);
////        singleLinkedList.del(2);
////        singleLinkedList.del(3);
//        singleLinkedList.del(4);
//        singleLinkedList.list();
//        //测试一下 求单链表中有效节点的个数
//        System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));
//
//        //测试一下看看是否得到了倒数第k个节点
//        System.out.println("倒数第k个节点是=" + findLastIndexNode(singleLinkedList.getHead(), 5));
        System.out.println("==========反转后=============");
//        SingleLinkedListDemo.reverseLinkedList(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("==========逆序打印=============");
        SingleLinkedListDemo.printReverse(singleLinkedList.getHead());

    }


    //腾讯面试题,将单链表翻转
    @SuppressWarnings({"all"})
    public static void reverseLinkedList(HeroNode head) {
        //如果当前链表为空，或者只有一个点
        if(head.next == null || head.next.next == null) {
            return;
        }

        HeroNode curr = head.next;
        HeroNode next = null; //指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while(true) {
            if(curr == null){
                break;
            }
            next = curr.next;
            curr.next = reverseHead.next;
            reverseHead.next = curr;
            curr = next;
        }
        head.next = reverseHead.next;
    }

    @SuppressWarnings({"all"})
    public static void printReverse(HeroNode head) {
        if(head.next == null) {
            throw new RuntimeException("链表为空");
        }

        HeroNode cur = head.next;
        Stack<HeroNode> heroNodes = new Stack<>();
        while (true) {
            if (cur == null){
                break;
            }
            heroNodes.add(cur);
            cur = cur.next;
        }


        while (true) {
            if(heroNodes.isEmpty()){
                break;
            }
            HeroNode pop = heroNodes.pop();
            System.out.println(pop);
        }
    }


    //查找单链表中的倒数第k个节点 【新浪面试题】
    //思路
    //1。编写一个方法， 接收head节点， 同时接收一个index
    //2。index 表示倒数第index个节点
    //3。 先把链表从头到尾遍历， 得到链表总的长度 getlength
    //4。 得到size 后， 我们从链表的第一个开始遍历（size-index）个， 就可以得到
    //5. 如果找到了， 则返回该节点， 否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null; //没有找到
        }
        //第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size-index 位置， 就是我们倒数的k个节点
        //先做一个index的校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义辅助遍历, for 循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //方法： 获取到单链表的节点的个数（如果是带头节点的链表，需要不统计头节点
    /**
     *
     * @param head 链表的头节点
     * @return  返回的就是有效节点的个数
     */
    @SuppressWarnings({"all"})
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量， 这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }
}



//定义SingleLinkedList管理我们的英雄
@SuppressWarnings({"all"})
class SingleLinkedList  {
    //先初始化一个头节点， 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }


    //添加节点到单向链表
    //思路， 当不考虑编号顺序时
    //1。找到当前链表的最后节点
    //2。将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode tempNode = head;
        //遍历链表， 找到最后
        while (true) {
            //找到链表的最后
            if (tempNode.next == null) {
                break;
            }
            //如果没有找到最后，就将tempNode后移
            tempNode = tempNode.next;
        }
        //当退出while循环时， temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        tempNode.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到制定位置
    //（如果有这个排名， 则添加是不， 并给出提示）
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为但链表，因此我们找的tempNode 是位于 添加位置的前一个节点，否则插入不了
        HeroNode tempNode = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while(true) {
            if(tempNode.next == null) { //说明tempNode已经在链表的最后
                break;
            }
            if(tempNode.next.no > heroNode.no) { //位置找到， 就在temp的后面加入
                break;
            }else if(tempNode.next.no == heroNode.no) { //说明希望添加的heroNode编号已经存在
                flag = true;
                break;
            }
            tempNode = tempNode.next; //后移，遍历当前链表
        }
        //判断flag的值
        if(flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号%d已经存在了， 不能加入\n", heroNode.no);
        }else {
            //插入到链表中
            //顺序不能调转， 因为如果先赋值heroNode的地址给tempNode.next, tempNode.next 值会被覆盖
            heroNode.next = tempNode.next;
            tempNode.next = heroNode;
        }
    }

    //修改节点的信息， 根据no编号来修改，即no编号不能改
    //说明
    //1。 根据newHeroNode 的 no 来修改即可
    public void update(HeroNode heroNode) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点， 根据no编号
        //定义一个辅助变量
        HeroNode tempNode = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if(tempNode == null) {
                break; //到链表的最后
            }
            if (tempNode.no == heroNode.no) {
                //找到
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag){
            tempNode.name = heroNode.name;
            tempNode.nickname = heroNode.nickname;
        }else { //没有找到
            System.out.println("修改节点（"+ heroNode.no +"）的编号不存在");
        }
    }

    //删除节点
    //思路
    //1。head 不能动， 因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2。说明我们在比较时， 是temp.next.no和 需要删除的节点的no比较
    public void del(int no) {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode tempNode = head;

        boolean flag = false; //标志是否找到待删除节点的
        while (true) {
            if(tempNode.next == null){ //已经到链表的最后
                break;
            }
            if(tempNode.next.no == no){
                //找到待删除节点的前一个节点tempNode
                flag = true;
                break;
            }
            tempNode = tempNode.next; //tempNode后移， 遍历
        }

        //判断flag
        if (flag){//找到
            //可以删除
            tempNode.next = tempNode.next.next;
        }else {
            System.out.println("删除节点（"+ no +"）的编号不存在");
        }
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode tempNode = head.next;
        while (true) {
            //判断是否到链表最后
            if(tempNode == null) {
                break;
            }
            //输出节点的信息
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

}

//定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，我们重写tostring
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}