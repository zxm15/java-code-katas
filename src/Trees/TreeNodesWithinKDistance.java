package Trees;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Gavin on 4/9/2015.
 */

public class TreeNodesWithinKDistance {


    /**
     * Return all the nodes within k distance for a given tree root and node n
     *
     * @param node    given node
     * @param k       given distance
     * @param visited set to store visited tree nodes
     * @return res ArrayList of BTreeNode
     */


    public static ArrayList<BTreeNode> findNodesWithinKDistance(BTreeNode node, int k, HashSet<BTreeNode> visited)
    {
        ArrayList<BTreeNode> res = new ArrayList<BTreeNode>();
        if (node == null || k < 0 || visited.contains(node)) return res;
        res.add(node);
        visited.add(node);
        res.addAll(findNodesWithinKDistance(node.parent, k - 1, visited));
        res.addAll(findNodesWithinKDistance(node.left, k - 1, visited));
        res.addAll(findNodesWithinKDistance(node.right, k - 1, visited));

        return res;
    }

    public static void main(String[] args)
    {
        BTreeNode root = new BTreeNode(0);
        root.left = new BTreeNode(1);
        root.right = new BTreeNode(2);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new BTreeNode(3);
        root.left.right = new BTreeNode(4);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.left.left.left = new BTreeNode(5);
        root.left.left.left.parent = root.left.left;
        ArrayList<BTreeNode> res = TreeNodesWithinKDistance.findNodesWithinKDistance(root.right, 3, new HashSet<BTreeNode>());
        //System.out.println(res.size());
        for(BTreeNode node : res) System.out.println(node.val);
    }

}

