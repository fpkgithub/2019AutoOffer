package ThreadSource.SynchronizationLocks;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ConcurrentMap接口,扩充了 Map接口,成为了并发编程中,最有用的一个接口.
 */
public class ConcurrentMapTest
{
    public static void main(String[] args)
    {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

        //putIfAbsent()方法,会在给定的key没有value时,为其添加一个value,否则不替换
        String value = map.putIfAbsent("c3", "p1"); //p0
        String value2 = map.putIfAbsent("c3", "p2");  //p0
        System.out.println(value);
        System.out.println(value2);

        //getOrDefault()方法,会尝试获取给定key的value,如果不存在,则返回我们指定的默认值.
        String value3 = map.getOrDefault("hi", "there");
        System.out.println(value3); //there


        //replaceAll()方法,用于替换此Map中,满足条件的项的value.
        map.replaceAll((key, value4) -> "r2".equals(key) ? "d3" : value4);
        System.out.println(map.get("r2")); //d3

        //compute()方法,允许我们对特定的项进行转换.
        map.compute("foo", (key, value5) -> value5 + value5);
        System.out.println(map.get("foo"));  //barbar

        // merge()方法,用于对给定key的value进行操作,生成一个新的值.
        map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));  //boo was foo


    }
}
