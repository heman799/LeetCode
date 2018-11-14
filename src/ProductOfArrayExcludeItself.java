import java.util.ArrayList;

public class ProductOfArrayExcludeItself {

    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Long> B = new ArrayList<Long>();
        long[] f = new long[len];

        long tmp = 1;
        long now = 1;
        f[len-1] = A.get(len-1);
        int i ;
        for ( i = len-2; i >= 0; --i)
        {
            f[i] = A.get(i);
            f[i] = f[i] * f[i+1];
        }

        for ( i = 0; i < len; ++i) {

            now = tmp;
            if(i+1<len)
                B.add( now * f[i+1] );
            else
                B.add( now );
            now = A.get(i);
            tmp = tmp * now;

        }
        return B;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);

        ProductOfArrayExcludeItself _prod = new ProductOfArrayExcludeItself();

        ArrayList<Long> result = _prod.productExcludeItself(nums);
        System.out.println(result);
    }
}
