import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    int size;
    double sum;
    Queue<Integer> q = new LinkedList<>();

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        sum = 0;
    }


    public double next(int val) {
        if (q.size() >= size) {
            sum -= q.peek();
            q.poll();
        }

        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
