import java.util.ArrayList;

public class TinyUrl {
    private final ArrayList<String> list = new ArrayList<>();
    private int count = 0;
    public String encode(String longUrl) {
        list.add(longUrl);
        return String.valueOf(count++);
    }

    public String decode(String shortUrl) {
        int i = Integer.valueOf(shortUrl);
        return list.get(i);
    }

    public static void main(String[] args) {
        String a = "https://lintcode.com/problems/design-tinyurl ";
        TinyUrl tinyUrl = new TinyUrl();
        String encodeString = tinyUrl.encode(a);
        System.out.println(encodeString);
        String decodeString = tinyUrl.decode(encodeString);
        System.out.println(decodeString);
    }

}
