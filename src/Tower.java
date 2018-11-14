import java.util.*;

public class Tower {
    private Stack<Integer> disks;
    /*
     * @param i: An integer from 0 to 2
     */
    public Tower(int i) {
        // create three towers ( i from 0 to 2)
        disks = new Stack<Integer>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(Tower t) {
        //check if moving is allowed: t is not empty and the top of t is less than the top of this tower
        if (t.disks.size() != 0 && t.disks.peek() < this.disks.peek()){
            System.out.println("Error Moving");
            return;
        }
        // Move the top disk of this tower to the top of t.
        t.add(this.disks.pop());
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n > 0) {

            moveDisks( n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this );

            //three steps:
            //T (N -1 , Beg, End, Aux)
            //T (1, Beg, Aux, End)
            //T (N -1 , Aux, Beg, End)
            //in above functions
            //step1: T (N - 1, Beg: this, End: buffer, Aux: destination)
            //step2: T (1, Beg: this  --> End: destination)
            //step3: T (N - 1, Aux: buffer, Beg: this, End: destination)

        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }
}

/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
 */
