import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<String> anagrams(String[] strs) {

        List<String> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        if (strs == null || strs.length == 0) {
            return result;
        }

        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String ns = new String(arr);

            if(map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }

        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String[] strs = {"lint", "intl", "inlt", "code"};

        Anagrams anag = new Anagrams();

        for (String s : anag.anagrams(strs)) {
            System.out.println(s);
        }

    }
}
