public class ReachANumber {
    public int reachNumber(int target) {

        target = Math.abs(target);

        int step = 1, pos = 0;
        while (pos < target) {
            pos += step;
            step++;
        }
        step--;

        if (pos == target) return step;

        pos -= target;

        //当超过目标值的差值d为偶数的时候，只要将d/2步的距离取反
        //d为奇数时， 当前为第n步，
        //1. 如果n+1步为奇数，再做差肯定为偶数
        //2. 如果n+1步为偶数，则需再多走一步，即n+2步
        if (pos % 2 == 0) {
            return step;
        } else if ( (step + 1) % 2 == 1) {
            return step + 1;
        } else {
            return step + 2;
        }

    }
}
