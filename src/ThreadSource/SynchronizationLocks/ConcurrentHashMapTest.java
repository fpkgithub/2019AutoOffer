package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * ConcurrentHashMap中的元素是无序的
 */
public class ConcurrentHashMapTest
{
    public static void main(String[] args)
    {
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        //Java8中,提供了三种并行操作的函数:forEach(), search()和reduce()

        //ForEach： 用于并行的执行迭代map中的key/value对的操作
        //因为在我的机器上, ForkJoinPool的最大尺寸为3,所以在下面的例子中,你会看到,最多启动了三个线程
        map.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));
        /**
         * key: r2; value: d2; thread: main
         * key: foo; value: bar; thread: ForkJoinPool.commonPool-worker-2
         * key: han; value: solo; thread: ForkJoinPool.commonPool-worker-1
         * key: c3; value: p0; thread: main
         */

        //Search:用于并行的查找map中给定的key的值,如果找到,就返回其value,如果找不到,就返回null.如果会找到多个,则其返回值不确定
        String result = map.search(1, (key, value) ->
        {
            System.out.println("search:" + Thread.currentThread().getName());
            if ("foo".equals(key))
            {
                return value;
            }
            return null;
        });
        System.out.println("Result:" + result);
        /**
         * search:main
         * search:ForkJoinPool.commonPool-worker-1
         * search:ForkJoinPool.commonPool-worker-2
         * search:main
         * Result:bar
         */

        //Reduce:接受两个类型为 BigFunction的lambda表达式.第一个lambda表达式,会将map中的每一个key/value对转换成一个值,
        // 然后第二个lambda表达式,会将这些转换后的值,拼接成一个单一的结果.它会忽略 null
        String result2 = map.reduce(1, (key, value) ->
        {
            System.out.println("Transform:" + Thread.currentThread().getName());
            return key + "=" + value;
        }, (s1, s2) ->
        {
            System.out.println("Reduce:" + Thread.currentThread().getName());
            return s1 + "," + s2;
        });

        System.out.println("Result:" + result2);
    }
}
