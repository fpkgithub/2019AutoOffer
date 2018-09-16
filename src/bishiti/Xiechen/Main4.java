package bishiti.Xiechen;

import java.util.*;

/**
 * 2
 * p 1 1
 * p 2 2
 * g 1
 * p 2 102
 * p 3 3
 * g 1
 * g 2
 * g 3
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//容量限制
        LURCache1 instence = new LURCache1(n);
        List<Integer> list = new ArrayList<>();//存get的结果
        while (true) {
            String s = scanner.next();
            if (s.equals("p")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                instence.put(a, b);
            } else if (s.equals("g")) {
                int c = scanner.nextInt();
                int m = instence.get(c);
                //System.out.println(m);
                list.add(m);
            } else {
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        scanner.close();
    }
}

class LURCache1<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;
    private Map<Integer, Integer> cache;

    public LURCache1(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new LinkedHashMap<Integer, Integer>(cacheSize, 0.75F, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}