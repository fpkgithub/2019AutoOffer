package bishiti.Xiechen;

import java.util.*;
import java.util.Map;

public class Main3 {

    private int cacheSize;
    private Map<Integer, Integer> cache;

    public Main3(int cacheSize) {
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//容量限制
        Main3 instence = new Main3(n);
        List<Integer> list = new ArrayList<>();//存get的结果
        while (scanner.hasNextInt()) {
            String str = scanner.nextLine();
            String[] arr = str.split("\\s+");
            char C = arr[0].toCharArray()[0];
            if ('p' == C) {
                int key = Integer.parseInt(arr[1]);
                int val = Integer.parseInt(arr[2]);
                instence.put(key, val);
            } else if ('g' == C) {
                int key = Integer.parseInt(arr[1]);
                int val = instence.get(key);
                list.add(val);
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