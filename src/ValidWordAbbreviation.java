import java.lang.String;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, m = word.length(), n = abbr.length();
        while (i < m && j < n) {
            //限定了单词中只有小写字母和数字，所以分成两种情况进行处理
            // abbr[j] >= '0' && abbr[j] <= '9'
            if (Character.isDigit(abbr.charAt(j))) {
                //如果当前数字是0，返回false,因为数字不能以0开头
                if (abbr.charAt(j) == '0')
                    return false;
                //把数字整体取出来，用一个while循环将数字整体取出来
                //然后原单词的指针也要对应的向后移动这么多位数
                int val = 0;
                while (j < n && Character.isDigit(abbr.charAt(j))) {
                    val = val * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += val;
            }
            else {
                if (word.charAt(i++) != abbr.charAt(j++)) {
                    return false;
                }
            }
        }

        return i == m && j == n;
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";

        boolean result = validWordAbbreviation(word, abbr);
        System.out.print(result);
    }
}
