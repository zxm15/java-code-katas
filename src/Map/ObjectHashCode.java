package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZXM on 11/12/15.
 */
public class ObjectHashCode {

    private String name;
    private int id;
    private Map<String, Integer> map;

    public ObjectHashCode(String name, int id) {
        this.name = name;
        this.id = id;
        this.map = new HashMap<>();
    }

    @Override
    public int hashCode() {

        int hash = 17;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + id;
        hash = 31 * hash + map.hashCode();

        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ObjectHashCode)) return false;
        if (this.name.equals(((ObjectHashCode) obj).name)) return false;
        if (this.id != ((ObjectHashCode) obj).id) return false;
        if (this.map != ((ObjectHashCode) obj).map) return false;

        return true;
    }

    public static void main(String[] args) {
        Integer i = 1;
        System.out.println(i.hashCode());
        Double d = 1.2;
        System.out.println(d.hashCode());
        Character c = 'a';
        System.out.println(c.hashCode());
        String str = "abc";
        System.out.println(str.hashCode());
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map.hashCode());
        //before I defined the hashCode and equals methods for the ObjectHashCode, they are different;
        ObjectHashCode o = new ObjectHashCode("gavin", 12);
        o.map.put("gavin", 12);
        System.out.println(o.hashCode());
        ObjectHashCode o1 = new ObjectHashCode("gavin", 12);
        o1.map.put("gavin", 12);
        System.out.println(o1.hashCode());

        System.out.println(o.map.equals(o1.map));


    }
}
