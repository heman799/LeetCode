public class MinimumWindowSubstring {

    //方法一:
    static int initTargetHash(int[] targethash, String Target) {
        int targetnum = 0;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }

    static boolean valid(int[] sourcehash, int[] targethash) {

        for (int i = 0; i < 256; i++) {
            if (targethash[i] > sourcehash[i])
                return false;
        }
        return true;
    }

    public static String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for (i = 0; i < Source.length(); i++) {
            while (!valid(sourcehash, targethash) && j < Source.length()) {
                sourcehash[Source.charAt(j)]++;
                j++;
            }
            if (valid(sourcehash, targethash)) {
                if (ans > j - i) {
                    ans = Math.min(ans, j - i);
                    minStr = Source.substring(i, j);
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }

    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";

        String result = minWindow(source, target);
        System.out.println(result);

    }

}





