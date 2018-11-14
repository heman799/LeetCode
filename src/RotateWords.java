import java.util.*;

public class RotateWords {
    public static int countRotateWords(List<String> words){
        Set<String> dict = new HashSet<>();

        for (String w : words) {
            String s = w + w;
            for (int i = 0; i < w.length(); i++) {
                dict.remove(s.substring(i, i + w.length()));
            }

            dict.add(w);
        }

        return dict.size();
    }

    public static void main(String[] args) {
        String[] words = {"picture", "turepic", "icturep", "word", "ordw", "lint"};
        List<String> list = Arrays.asList(words);
        System.out.print(countRotateWords(list));
    }
}
