public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        //board is null or empty
        if (board == null || board.length == 0) {
            return false;
        }
        //word is empty
        if (word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean find(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }

        //exit for recursion
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#';
        //look for next character in four directions
        boolean result = find (board, i - 1, j, word, start + 1)
                        || find (board, i + 1, j, word, start + 1)
                        || find (board, i, j - 1, word, start + 1)
                        || find (board, i, j + 1, word, start + 1);

        //recover the char changed to '#'
        board[i][j] = word.charAt(start);

        return result;
    }

    public static void main(String[] args) {
        String[] board = {"ABCE", "SFCS", "ADEE"};
    }
}
