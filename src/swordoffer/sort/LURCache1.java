package swordoffer.sort;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used)
 */
public class LURCache1<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 1L;
    private int cacheSize;

    public LURCache1(int cacheSize) {
        super(10, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        boolean r = size() > cacheSize;
        if (r) {
            System.out.println("清除缓存：" + eldest.getKey());
        }

        return r;
    }


    public static void main(String[] args) {

        LURCache1<String, String> cache = new LURCache1<String, String>(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");

        System.out.println("初始化：");
        System.out.println(cache.keySet());
        System.out.println("访问3：");
        cache.get("3");
        System.out.println(cache.keySet());
        System.out.println("访问2：");
        cache.get("2");
        System.out.println(cache.keySet());
        System.out.println("增加数据6,7：");
        cache.put("6", "6");
        cache.put("7", "7");
        System.out.println(cache.keySet());


    }
}
