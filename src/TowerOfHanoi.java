import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

    public List<String> towerOfHanoi(int n) {
        List<String> list = new ArrayList<>();
        char from = 'A';
        char to = 'C';
        char buffer = 'B';
        move(list, n, from, buffer, to);


        return list;
    }

    public void move(List<String> list, int n , char from, char buffer, char to) {
        if (n == 1) {
            list.add("from " + from +  " to " + to);
        }
        else
        {
            move(list, n - 1, from, to, buffer);
            move(list, 1, from, buffer, to);
            move(list, n-1, buffer, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi tower = new TowerOfHanoi();
        System.out.println(tower.towerOfHanoi(n));
    }

    //Given n = 3
    //return ["from A to C", "from
}
