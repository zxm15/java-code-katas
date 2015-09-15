package Trees;
import java.util.ArrayList;
/**
 * Created by ZXM on 5/29/15.
 */
public class FindAllSumPath {
    public ArrayList<ArrayList<Integer>> findAllPaths(BTreeNode root, int target) {
        ArrayList<ArrayList<Integer>>  res = new ArrayList();
        if (root == null) return res;
        findAllPaths(root, 0, target, new ArrayList<Integer>(), new ArrayList<BTreeNode>(), res);
        return res;
    }

    public void findAllPaths(BTreeNode root, int level, int target, ArrayList<Integer> sums, ArrayList<BTreeNode> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        path.add(root);
        sums.add(root.val);


        int t = 0;
        for (int i = level; i >= 0; i--) {
            //int t = 0;
            t += sums.get(i);
            //sums.set(i, sums.get(i) + root.val);
            //sums[level] += root.val;
            if (t == target) {
                ArrayList<Integer> solution = generatePath(path, i, level);
                res.add(solution);
            }
        }

        findAllPaths(root.left, level + 1, target, sums, path, res);
        findAllPaths(root.right, level + 1, target, sums, path, res);

        path.remove(path.size() - 1);
        sums.remove(sums.size() - 1);


    }

    public ArrayList<Integer> generatePath(ArrayList<BTreeNode> path, int start, int end) {
        ArrayList<Integer> res = new ArrayList();
        for (int i = start; i <= end; i++) res.add(path.get(i).val);
        return res;
    }

    public static void main(String[] args) {
        FindAllSumPath paths = new FindAllSumPath();
        BTreeNode obj = new BTreeNode(0);
        BTreeNode root = obj.createBTree(3);
        obj.printBTreeByLevel(root);
        ArrayList<ArrayList<Integer>> res = paths.findAllPaths(root, -6);
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) System.out.print(i + "-->");
            System.out.println();
        }

        //paths.findAllPaths();
    }

}
