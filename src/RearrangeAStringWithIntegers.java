import java.util.*;

public class RearrangeAStringWithIntegers {
    public String rearrange(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        int res = 0;
        int index = -1;
        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])){
                res += (cs[i] - '0');
                index++;
            }
            else {
                break;
            }
        }

        if (index == -1){
            return new String(cs);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = index + 1; i < cs.length; i++) {
                sb.append(cs[i]);
            }
            sb.append(res);
            return sb.toString();
        }
    }
}
