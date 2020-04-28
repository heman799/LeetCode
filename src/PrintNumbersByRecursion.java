import java.util.ArrayList;
import java.util.List;

public class PrintNumbersByRecursion {
    public List<Integer> numberByRecursion(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        num(n, 0, res);
        return res;

    }

    public void num(int n, int ans, ArrayList<Integer> res) {
        if (n == 0) {
            if (ans > 0) {
                res.add(ans);
            }
            return;
        }

        int i;
        for (i = 0; i <= 9; i++) {
            num(n - 1, ans * 10 + i, res);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        PrintNumbersByRecursion printNumbersByRecursion = new PrintNumbersByRecursion();

        System.out.println(printNumbersByRecursion.numberByRecursion(3));
    }
}
