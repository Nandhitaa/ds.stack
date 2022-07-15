package basic;

import java.util.Stack;

class Node {
	public int val;
	public int min;
	
	public Node(int val, int min) {
		this.val = val;
		this.min = min;
	}
}

public class MinStack {

	Stack<Node> stack;
	
	public MinStack() {
		stack = new Stack<Node>();
	}

	public void push(int val) {
		if(stack.isEmpty()) {
			stack.push(new Node(val, val));
			return;
		}
		
		int prevMin = stack.peek().min;
		int min = Math.min(val, prevMin);
		stack.push(new Node(val, min));
	}
	
	public Integer pop() {
		if(stack.isEmpty()) return null;
		return stack.pop().val;
	}
	
	public Integer min() {
		if(stack.isEmpty()) return null;
		return stack.peek().min;
	}
	
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		System.out.println(obj.min());
		obj.push(2);
		System.out.println(obj.min());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(3);
		System.out.println(obj.min());
		obj.push(1);
		System.out.println(obj.min());
	}

}
