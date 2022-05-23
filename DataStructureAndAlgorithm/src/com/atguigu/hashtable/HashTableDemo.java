package com.atguigu.hashtable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入查找的id");
                    int searchId = scanner.nextInt();
                    hashTable.findEmpById(searchId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//hashtable
class HashTable {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.empLinkedListsArray = new EmpLinkedList[this.size];
        for(int i = 0; i < size; i++) {
            this.empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        this.empLinkedListsArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for(int i = 0; i < this.size; i++) {
            this.empLinkedListsArray[i].list(i);
        }
    }

    public int hashFun(int id) {
        return id % this.size;
    }

    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = this.empLinkedListsArray[empLinkedListNo].findEmpById(id);
        if(emp != null) {
            System.out.println("在第" + (empLinkedListNo + 1) + "条链表中找到雇员id=" + id);
        }else {
            System.out.println("在哈希表中， 没有找到该雇员");
        }
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

    public void list(int no) {
        if(head == null) {
            System.out.println("第" + (no+1) + "链表为空");
            return;
        }
        System.out.print("第" + (no+1) + "链表的信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.print(" => id=" + curEmp.id + " name=" + curEmp.name);
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;
        while(true) {
            if(curEmp.id == id) {
                break;
            }
            if(curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}