import java.util.ArrayList;
import java.util.List;

public class LettersOfPhoneNumberCombinations {
    private final String[] map = new String[] {"", "", ""};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }

        //convert string digits to char array
        char[] arrayDigits = digits.toCharArray();
        List<String> result = new ArrayList<>();

        return null;
    }
}
