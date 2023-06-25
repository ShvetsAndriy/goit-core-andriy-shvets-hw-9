package hashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap();
        System.out.println(map + "Size of new map = " + map.size());
//    put(Object key, Object value)
        System.out.println("\n1. Adding 6 elements and 1 double");
        map.put("first", 10);   // Buckets 15, 1st element
        map.put("first", 100);  // Buckets 15, key the same -> new value
        map.put("first0", 11);  // Buckets 15, 2nd element
        map.put("second", 20);  // Buckets 3, 1st element
        map.put("firs", 220);   // Buckets 3, 2nd element
        map.put("firs11", 222); // Buckets 3, 3rd element
        map.put("third", 30);   // Buckets 6, 1st element
        System.out.println(map + "Size of map = " + map.size());
//    get(Object key)
        System.out.println("\n2. Getting value of doubled element");
        System.out.println("map.get 'first' = " + map.get("first"));
//    remove(Object key)
        System.out.println("\n3. Removing 2 exist elements and trying to remove another one");
        map.remove("firs");     //map.remove 'firs'
        map.remove("third");    //map.remove 'third'
        map.remove("firs4");    //map.remove something else (not from a map)
        System.out.println(map + "Size of map = " + map.size());
//    clear()
        System.out.println("\n4. Clearing map");
        map.clear();
        System.out.println(map + "Size of map = " + map.size());
    }
}
