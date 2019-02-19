public class StringCompress {
    //write your code here
    public String compress(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }

        String out = "";
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                sum++;
            }
            else {
                out = out + s.charAt(i) + sum;
                sum = 1;
            }
        }

        out = out + s.charAt(s.length() - 1) + sum;

        return out.length() < s.length() ? out : s;
    }

    public static void main(String[] args) {
        String a = "aabcccccaaa";
        StringCompress stringCompress = new StringCompress();
        String result = stringCompress.compress(a);
        System.out.println(result);
    }
}
