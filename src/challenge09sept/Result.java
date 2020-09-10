package challenge09sept;
import java.util.ArrayList;
import java.util.List;

public class Result {

	private static boolean isNumber(String value) {
		boolean isInteger = true;
		;
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException ex) {
			isInteger = false;
		}
		return isInteger;
	}



	public static int foofunction(List<String> blocks) {

		System.out.println(blocks);
		int result = 0;
		if (blocks.size() > 1) {
			int prevScore = 0;
			int currentScore = 0;
			int lastPrevScore = 0;
			int mostPrevScore = 0;
			for (int i = 0; i < blocks.size(); i++) {
				currentScore = 0;
				String element = blocks.get(i);
				if (isNumber(element)) {
					int value = Integer.parseInt(element);
					mostPrevScore = lastPrevScore;
					currentScore = value;
					lastPrevScore = prevScore;
					prevScore = currentScore;
					result = result + value;
					
				} else {
					switch (element) {
					case "Z":
						result = result - prevScore;
						prevScore = lastPrevScore;
						lastPrevScore = mostPrevScore;
						break;
					case "X":
						mostPrevScore = lastPrevScore;
						lastPrevScore = prevScore;
						currentScore = 2 * prevScore;
						prevScore = currentScore;
						result = result + currentScore;
						break;
					case "+":
						mostPrevScore = lastPrevScore;
						currentScore = prevScore + lastPrevScore;
						lastPrevScore = prevScore;
						prevScore = currentScore;
						result = result + currentScore;
						break;
					}
				}
			}
		}
		return result;

	}

	public static void main(String args[]) {
		List<String> list = new ArrayList();
//	list.add("8");
		list.add("5");
		list.add("-2");
		list.add("4");
		list.add("Z");
		list.add("X");
		list.add("9");
		list.add("+");
		list.add("+");
		System.out.println(foofunction(list));
	}

}
