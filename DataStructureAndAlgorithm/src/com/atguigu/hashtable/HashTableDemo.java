package com.atguigu.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {

    }
}

//hashtable
class HashTable {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.empLinkedListsArray = new EmpLinkedList[this.size];
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        this.empLinkedListsArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for(int i = 0; i < this.size; i++) {
            this.empLinkedListsArray[i].list();
        }
    }

    public int hashFun(int id) {
        return id % this.size;
    }
}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if(head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list() {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.println("当前链表的信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.println("=> id=" + curEmp.id + " name=" + curEmp.name);
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }
}