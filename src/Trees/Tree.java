package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 9/23/15.
 */
public class Tree {
    int val;
    List<Tree> children;
    public Tree(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
