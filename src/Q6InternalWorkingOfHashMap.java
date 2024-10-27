import java.util.*;

public class Q6InternalWorkingOfHashMap {
    public void call() {
        Map<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");

//        k1.id = 2;

        System.out.println();
        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);

        System.out.println();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        System.out.println();
        System.out.println("map size " + map.size());
    }
}

class MyKey {
    public int id;
    public String key;

    MyKey(int id, String key) {
        this.id = id;
        this.key = key;
    }

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode() " + id);
//        return super.hashCode();

        return id;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Calling equals() " + id);
//        return super.equals(obj);

        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        // Cast and compare field
        MyKey myKey = (MyKey) obj;
        return myKey.id == this.id;
    }
}
