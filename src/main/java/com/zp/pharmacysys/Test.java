package com.zp.pharmacysys;

import java.util.Scanner;

import org.apache.xerces.impl.xs.SchemaSymbols;

public class Test {

	
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
	
	private static class Node{
		private String data;
		private Node next;
		
		Node(){}
		Node(String data){
			this.data = data;
			this.next = null;
		}
		Node(String data,Node next){
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String[] args){
		Node head = new Node();
		
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();// 录入字符串
	    String[] strs = str.split(",");// 使用正则表达式进行分割
	        /*String[] is = new String[strs.length];
	        for (int i = 0; i < strs.length; i++) {// 遍历String数组，赋值给int数组
	            is[i] = strs[i];
	           
	           a
	        }*/
	        head.next  =  new Node(strs[0]);
	        for(int i = 0 ; i< (strs.length-1); i++) {
	        (new Node(strs[i])).next = new Node(strs[i+1]);
	        }
	        System.out.println(isLoop(head));
		
	}
}

