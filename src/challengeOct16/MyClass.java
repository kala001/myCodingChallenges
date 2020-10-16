package challengeOct16;

import java.util.Stack;

public class MyClass {
	
//	private static MyClass myclassObj = new MyClass();
//	
//	public static MyClass getInstance() {
//		return myclassObj;
//	}

	
	
	public static void main(String[] args) {
		String string1 = "[{}]{}[{]}";
		System.out.println(MyClass.isBalancedString(string1));
	}
	
	public static boolean isBalancedString(String values) {
		
		Stack<String> stack = new Stack<>();
		for (int i = 0; i< values.length(); i++) {
			String singlechar = String.valueOf(values.charAt(i));
			if (singlechar.equals("{") || singlechar.equals("[") || singlechar.equals("(")) {
				stack.push(singlechar);
				}
				
			if (singlechar.equals("}") || singlechar.equals("]") || singlechar.equals(")")) {
			if (stack.empty()) {
			      return false;
			     }
			String top_char = (String) stack.pop();
			
			if (!top_char.equals("(") && singlechar.equals(")")) {
				return false;
			}
			
			if (!top_char.equals("{") && singlechar.equals("}")) {
				return false;
			}
			
			if (!top_char.equals("[") && singlechar.equals("]")) {
				return false;
			}

		}
			
		
	}
		if (stack.empty()) {
			return true;
		}
return false;
	
}


}