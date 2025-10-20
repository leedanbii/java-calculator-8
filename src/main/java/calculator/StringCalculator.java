package calculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return sum(numbers);
    }
    
    private static String[] splitNumbers(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter));
        }
        return input.split(",|:");
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String numStr: numbers) {
            if(numStr.isEmpty()) continue;
            int number = positiveParseInt(numStr);
            total += number;
        }
        return total;
    }

    private static int positiveParseInt(String numStr) {
        try {
            int number = Integer.parseInt(numStr);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
