package DataStructure;

import java.util.List;

/**
 * Created by Gavin on 4/12/2015.
 * public class DeepIterator implements Iterator<Integer> {
 * public DeepIterator(List<DataInteger> list) {
 * // implementation here
 * }
 * public Integer next() {
 * // implementation here
 * }
 * public boolean hashNext() {
 * // implementation here
 * }
 * <p/>
 * public interface DataInteger {
 * public boolean isList();
 * public List<DataInteger> getList();
 * public Integer getElement();
 * }
 * }
 * <p/>
 * // ((1, 3, 5), (4, 7, 3), ((2, 3), 4)) -> 1, 3, 5, 4, 7, 3, 2, 3, 4
 * // ((1,(2,3),4),(5,6) ,(((7),8),9)) -> 1,2,3,4,5,6,7,8,9
 *
 */
public class DeepIterator {
    public interface DataInteger {
        public boolean isList();
        public List<DataInteger> getList();
        public Integer getElement();
    }
}
