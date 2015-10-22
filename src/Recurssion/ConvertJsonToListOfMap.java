package Recurssion;

/**
 * Created by ZXM on 10/22/15.
 * 题目就是flatten json to a list of map, 有一段json，比如说如下：
 * {
 * "uuid": "abc",
 * "properties": {
 * "sessionName": "Test session name",
 * "waypoints": [
 * {"uuid": "def", "properties": {"latitude": 3}}
 * ]
 * }
 * }
 * <p>
 * <p>
 * 把它转化成List<Map<String, Object>>， map里面uuid是key, properties是value。 所以结果应该像下面
 * <p>
 * [
 * <p>
 * {"uuid": "abc", "properties": {"sessionName": "Test session name", "waypoints": ["def"]}},
 * <p>
 * {"uuid": "def", "properties": {"latitude": 3}},
 * .1point3acres缃�
 * ...
 * <p>
 * ]
 */

import java.util.*;

/**analysis
 * The nature is recursion. When the value is an map, recursively parse it using the same function
 * 1. how to represent a json data structure using java
 * Map<String, Object>
 * 2. bfs or dfs?
 * bfs takes o(key) time and O(key) space (heap)
 * dfs takes o(key) time and O(key) space (stack)
 *
 *
 */

//class JsonData {
//    Map<String, Object> json;
//    public JsonData(){
//        json = new HashMap<>();
//    }
//}
public class ConvertJsonToListOfMap {
    public List<Map<String, Object>> convertBFS(Map<String, Object> json) {
        List<Map<String, Object>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        if (json == null || json.size() == 0) return res;
        Queue<Map<String, Object>> queue = new LinkedList<>();
        queue.offer(json);
        while (! queue.isEmpty()) {
            Map<String, Object> data = queue.poll();
            res.add(data);
            for (String key : data.keySet()) {
                Object value = data.get(key);
                if (value instanceof Map && ! visited.contains(key))
                    queue.offer((Map) value);
            }
        }

        return res;
    }


}
