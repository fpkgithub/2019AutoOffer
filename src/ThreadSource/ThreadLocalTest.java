package ThreadSource;

/**
 * 定义了两个ThreadLocal变量。终于的目的就是要看最后两个值能否相应上。这样才有机会证明ThreadLocal所保存的数据可能是线程私有的。
 * 使用两个内部类仅仅是为了使測试简单，方便大家直观理解，大家也能够将这个样例的代码拆分到多个类中，得到的结果是同样的。
 * 測试代码更像是为了方便传递參数。由于它确实传递參数非常方便，但这不过为了測试。
 * 在finally里面有remove()操作，是为了清空数据而使用的。
 */
public class ThreadLocalTest {
    static class ResourceClass {

        public final static ThreadLocal<String> RESOURCE_1 = new ThreadLocal<String>();

        public final static ThreadLocal<String> RESOURCE_2 = new ThreadLocal<String>();

    }

    static class A {

        public void setOne(String value) {
            ResourceClass.RESOURCE_1.set(value);
        }

        public void setTwo(String value) {
            ResourceClass.RESOURCE_2.set(value);
        }
    }

    static class B {
        public void display() {
            System.out.println(ResourceClass.RESOURCE_1.get() + ":" + ResourceClass.RESOURCE_2.get());
        }
    }

    /**
     * 大家能够看到输出的线程顺序并不是最初定义线程的顺序，理论上能够说明多线程应当是并发运行的，
     * 可是依旧能够保持每一个线程里面的值是相应的，说明这些值已经达到了线程私有的目的。
     *
     * @param args
     */
    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        for (int i = 0; i < 15; i++) {
            final String resouce1 = "线程-" + i;
            final String resouce2 = " value = (" + i + ")";
            new Thread() {
                public void run() {
                    try {
                        a.setOne(resouce1);
                        a.setTwo(resouce2);
                        b.display();
                    } finally {
                        ResourceClass.RESOURCE_1.remove();
                        ResourceClass.RESOURCE_2.remove();
                    }
                }
            }.start();
        }
    }
}