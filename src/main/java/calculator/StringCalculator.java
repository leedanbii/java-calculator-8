package calculator;

public class StringCalculator {
	public static int add(String input) {
    	if(input == null || input.isEmpty()) {
    		return 0;
    	}
    	String[] numbers = splitNumbers(input);
    	return sum(numbers);
    }
	
	private static String[] splitNumbers(String input) {
		//커스텀 구분자 추후 확장
		return input.split(",|:");
	}
	
	private static int sum(String[] numbers) {
		int total = 0;
		for(String numStr: numbers) {
			if(numStr.isEmpty()) continue;
			int number = Integer.parseInt(numStr);
			//예외처리 추후 확장
			total += number;
		}
		return total;
	}
}
