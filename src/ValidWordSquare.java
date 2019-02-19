public class ValidWordSquare {
    public static boolean validWordSquare(String[] words) {
        if (words.length == 0) {
            return false;
        }

        try {
            //遍历二维数组
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i)) {
                        return false;
                    }
                }
            }

            return true;
        }
        catch (StringIndexOutOfBoundsException ex) {
            return true;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"abcd", "bnrt", "crm","dtx"};
        System.out.print(validWordSquare(arr));
    }
}
