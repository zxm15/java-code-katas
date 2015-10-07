package Graph.DifferenceBetweenTreeAndGraph;

/**
 * Created by ZXM on 10/7/15.
 * Given n nodes labeled from 0 to n - 1 and a list of directed edges
 * (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * <p>
 * For example:
 * <p>
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * <p>
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return true.
 */

/**
 * analysis
 * nodes and list of edges => graph (pointers and objects)
 * note that it is directed edge
 *
 * tree
 * one and only one root,
 * except the root, each node should have one and only one parent
 * no loop,
 * no forest => only one weak connected component
 *
 * what makes a node a root?
 * indegree = 0 or it is not a children node
 * use map<children, parent>
 *
 * one and only one parent
 * check if the children 's parent is the same one
 * use above map
 *
 * no forest
 * iterate through the nodes again and check the map to count how many root it has
 * more than 1 is forest, 0 could be loop
 *
 * however above cases does not contains all the loop cases
 *  1-2-3-2
 *
 * method 1:
 * could use a hashmap to get rid of the most cases except for some loop cases
 * generate adjaency list for this and detect the loop
 *
 * method 2:
 * union find
 *
 * if the two nodes has the same parent
 * on the same path, loop return false
 * not on the same path,
 *      if non of them is the parent, then more than one parent, return false;
 *      if one of them is the parent,
 *         1-2-3 if 1 - 3 more than 1 parent,
 *               if 3- 1, loop
 *      if both of them are the parent, it must be same node, self loop.
 *
 * above could solve all the loop and more than one parent issue
 * we will need to check if there is only one weak connected component or one root
 * iterate through the union find and check if there is only one father.
 * you may find this is the exactly the same method as undirected graph for union find
 *
 */
public class GraphValidTreeWithDirectedEdge {

}
