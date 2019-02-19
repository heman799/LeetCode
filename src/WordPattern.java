import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String teststr) {
        HashMap<Character, String> hashMap = new HashMap<>();

        String[] newTestArray = teststr.split(" ");

        if(pattern.length() != newTestArray.length)
            return false;


        //insert into HashMap
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (!hashMap.containsKey(c)) {
                if (hashMap.containsValue(newTestArray[i])){
                    return false;
                }
                hashMap.put(c, newTestArray[i]);
            }
            else {
                if (!newTestArray[i].equals(hashMap.get(c))){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main (String[] args) {
        String pattern = "abba";
        String teststr = "dog cat cat dog";
        System.out.print(wordPattern(pattern, teststr));
    }
}
