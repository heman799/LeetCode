import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i-1) == '+') {
                result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "+++++++";
        List<String> result = generatePossibleNextMoves(a);
        for(String s: result) {
            System.out.println(s);
        }
    }
}

