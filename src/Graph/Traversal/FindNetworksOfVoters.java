package Graph.Traversal;

/**
 * Created by ZXM on 10/11/15.
 * I work for the local news station and we are covering an upcoming election.
 * We'd like to identify networks of neighboring voters who selected the same candidate.
 * If you are given information about who each voter is, who they voted for,
 * and who their neighbors are can you write a program that will produce this information?
    design the input and output by yourself
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**analysis
 * pattern matching
 * network => graph; neighbor => undirected graph;
 * find difference networks => start with a node, then find all the connected nodes which
 * vote for the same candidate. Mark the nodes as visited and add those nodes into the result list
 *
 * peusdo code
 * network = 0;
 * for (node : graph) {
 *     if (node has not been visited) {
 *          dfs(node, node.candidate, network++, visited, res)
 *     }
 * }
 *
 * return res
 *
 * dfs(node, candidate, network, visited, res) {
 *     if (node has been visited) return;
 *     if (node.candidate != candidate) return;
 *     visited.add(node);
 *     res[network].add(candidate);
 *     for (neighbor : node.neighbor) {
 *         dfs(neighbor, candidate, network, visited, res)
 *     }
 * }
 */
class Voter {
    int id;
    int candidate;
    List<Voter> neighbor;

    public Voter(int id, int candidate) {
        this.id = id;
        this.candidate = candidate;
        neighbor = new ArrayList<>();
    }
}

public class FindNetworksOfVoters {

    public List<List<Voter>> findNetworksOfVoters(List<Voter> voters) {
        List<List<Voter>> res = new ArrayList<>();
        if (voters == null || voters.size() == 0) return res;
        int network = 0;
        Set<Voter> visited = new HashSet<>();
        for (Voter voter : voters) {
            if (! visited.contains(voter)) {
                res.add(new ArrayList<>());
                dfs(voter, network++, voter.candidate, visited, res);
            }
        }

        return res;
    }

    private void dfs(Voter voter, int network, int candidate, Set<Voter> visited, List<List<Voter>> res) {
        if (visited.contains(voter) || voter.candidate != candidate) return;
        visited.add(voter);
        res.get(network).add(voter);
        for (Voter neighbor : voter.neighbor) {
            dfs(neighbor, network, candidate, visited, res);
        }
    }
}
