package calculator;

public class StringCalculator {
	public static int add(String input) {
    	if(input == null || input.isEmpty()) {
    		return 0;
    	}
    	// 이후에 확장
    	return Integer.parseInt(input);
    }
}
