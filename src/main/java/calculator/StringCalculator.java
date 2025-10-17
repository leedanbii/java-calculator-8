package calculator;

import java.util.regex.*;

public class StringCalculator {
	public static int add(String input) {
    	if(input == null || input.isEmpty()) {
    		return 0;
    	}
    	String[] numbers = splitNumbers(input);
    	return sum(numbers);
    }
	
	private static String[] splitNumbers(String input) {
		Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches()) {
			String customDelimiter = matcher.group(1);
			String numbers = matcher.group(2);
			return numbers.split(Pattern.quote(customDelimiter));
		}
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
