package com.zp.pharmacysys;

import java.util.Scanner;

public class Tset1 {
	private static class Node{
		private String data;
		private Node next;
		
		Node(){}
		Node(String string){
			this.data = string;
			this.next = null;
		}
		Node(String data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public static boolean isLoop(Node head){
		Node slow = head.next;
		Node fast = head.next.next;
		
		// 链表为空或者只有一个节点
		if(slow == null || fast == null){
			return false;
		}
		while(slow.next != null){
			
			// 只有 两个节点，当然是不存在循环的
			if(fast.next == null){
				return false;
			}
			// 如果slow的数据域和fast的数据域相同，则表示有环
			if(slow.data == fast.data){
				return true;
			}
			// slow指针走一步，fast走两步
			slow = slow.next;
			fast = fast.next.next;
			
			//如果fast走到最后为空，表示没有环
			if(fast == null){
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args){
		// 构造链表 1->2->3->4->5->6-4; 
		Node head = new Node();
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("a");
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		// 结果
		System.out.println(isLoop(head));
	}

}
