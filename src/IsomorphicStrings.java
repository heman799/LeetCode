public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
//  这道题让我们求同构字符串，就是说原字符串中的每个字符可由另外一个字符替代，可以被其本身替代，相同的字符一定要被同一个字符替代，
//  且一个字符不能被多个字符替代，即不能出现一对多的映射。根据一对一映射的特点，
//  我们需要用两个哈希表分别来记录原字符串和目标字符串中字符出现情况，由于ASCII码只有256个字符，
//  所以我们可以用一个256大小的数组来代替哈希表，并初始化为0，我们遍历原字符串，分别从源字符串和目标字符串取出一个字符，
//  然后分别在两个哈希表中查找其值，若不相等，则返回false，若相等，将其值更新为i + 1，因为默认的值是0，所以我们更新值为i + 1，
//  这样当 i=0 时，则映射为1，如果不加1的话，那么就无法区分是否更新了

    int[] S = new int[256];
    int[] T = new int[256];

    for (int i = 0; i < s.length(); i++) {
        if(S[s.charAt(i)] != T[t.charAt(i)]){
            return false;
        }

        S[s.charAt(i)] = i + 1;
        T[t.charAt(i)] = i + 1;
    }

    return true;

    }
}
