public class FirstUniqueCharacterInAString {
    public char firstUniqueChar(String str) {
        char xorResult = '1';
        for(int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if( i != j) {
                    xorResult = (char)(str.charAt(i) ^ str.charAt(j));
                    if ( xorResult == '\0') {
                        break;
                    }
                }


                if(j == str.length() - 1){
                    return str.charAt(i);
                }
            }

        }

        return xorResult;

    }

    public static void main(String[] args) {
        String s = "abaccdeff";

        FirstUniqueCharacterInAString first = new FirstUniqueCharacterInAString();
        char result = first.firstUniqueChar(s);
        System.out.print(result);
    }
}
