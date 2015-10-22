package BitSet;

import java.util.BitSet;

/**
 * Created by ZXM on 10/21/15.
 */
public class BitSetMain {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(8);

        System.out.println(bitSet);

        bitSet.set(1);
        System.out.println(bitSet);
        bitSet.set(2);
        System.out.println(bitSet);

        bitSet.set(4);
        System.out.println(bitSet);


        bitSet.set(7);
        System.out.println(bitSet);

        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(7));
        System.out.println(bitSet.get(8));
        System.out.println(bitSet.get(12));
    }
}
