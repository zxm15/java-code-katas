package Math;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Gavin on 4/11/2015.
 * Given a random generator rand(int n) which generates numbers from 0 to n-1 uniformly (inclusive), design a random generator as following:
 * <p/>
 * rand(int n, int[] blacklist)
 * <p/>
 * For example, given n = 10 which generates random numbers from 0 to 9 uniformly.
 * Assume blacklist = [1, 5, 6],
 * rand(10, blacklist) should output random numbers from [0, 2, 3, 4, 7, 8, 9] uniformly.
 */
public class RandomGenerator {
    public static int random(int n, int[] blockList) {
        Arrays.sort(blockList);
        Random rand = new Random();
        int num = rand.nextInt(n - blockList.length); //assume all the number in the list should be in the range of [0,n-1]
        for(Integer i : blockList) {
            if(num >= i) num++; //if having conflict, then move num to right
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] blockList = {1,5,6};
        System.out.println(random(n, blockList));
        System.out.println(random(n, blockList));
        System.out.println(random(n, blockList));
        System.out.println(random(n, blockList));
        System.out.println(random(n, blockList));
        System.out.println(random(n, blockList));
    }
}
