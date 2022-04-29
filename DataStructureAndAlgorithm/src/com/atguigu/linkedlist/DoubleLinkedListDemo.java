package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        //修改测试
        HeroNode2 newHeroNode = new HeroNode2(4, "hsp","hsp");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
@SuppressWarnings({"all"})
class DoubleLinkedList{
    //先初始化一个头节点， 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 tempNode = head.next;
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

    //添加节点到单向链表
    //思路， 当不考虑编号顺序时
    //1。找到当前链表的最后节点
    //2。将最后这个节点的next 指向新的节点
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 tempNode = head;
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
        //形成一个双向链表
        tempNode.next = heroNode;
        heroNode.pre = tempNode;
    }

    //修改节点的信息， 根据no编号来修改，即no编号不能改
    //说明
    //1。 根据newHeroNode 的 no 来修改即可
    public void update(HeroNode2 heroNode) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点， 根据no编号
        //定义一个辅助变量
        HeroNode2 tempNode = head.next;
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
        HeroNode2 tempNode = head.next;

        boolean flag = false; //标志是否找到待删除节点的
        while (true) {
            if(tempNode == null){ //已经到链表的最后
                break;
            }
            if(tempNode.no == no){
                //找到待删除节点的前一个节点tempNode
                flag = true;
                break;
            }
            tempNode = tempNode.next; //tempNode后移， 遍历
        }

        //判断flag
        if (flag){//找到
            //可以删除
            tempNode.pre.next = tempNode.next;
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针异常
            if(tempNode.next!=null){
                tempNode.next.pre = tempNode.pre;
            }
        }else {
            System.out.println("删除节点（"+ no +"）的编号不存在");
        }
    }
}


//定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点， 默认为null
    public HeroNode2 pre; //指向前一个节点， 默认为null

    //构造器
    public HeroNode2(int no, String name, String nickname) {
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
