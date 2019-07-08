package com.ifree.algorithm.data;

import com.ifree.algorithm.data.entity.Node;

/**
 * @author fengyupeng
 * 
 * 链表
 *
 */
public class LinkedList{

	private Node pHead = new Node();

	public int size() {
		int length = 0;
		Node pTemp = pHead;
		
		while(pTemp.next != null) {
			pTemp = pTemp.next;
			length++;
		}
		
		return length;
	}
	
	
	public boolean add(final String value) {	
		
		Node pNode = new Node();
		pNode.value = value;
		pNode.next = null;
		Node pTemp = pHead;
		while(pTemp.next != null) {
			pTemp = pTemp.next;
		}
		pTemp.next = pNode;
		return true;
	}
}
