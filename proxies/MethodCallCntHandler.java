package proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MethodCallCntHandler implements InvocationHandler {
    private Object target;

    private Map<String, Integer> methodCallCnt = new ConcurrentHashMap<>();

    public MethodCallCntHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        String name = m.getName();

        Integer originCnt = methodCallCnt.get(name);
        if (originCnt == null) {
            methodCallCnt.putIfAbsent(name, 1);
        } else {
            methodCallCnt.replace(name, originCnt, originCnt+1);
        }

        return m.invoke(target, args);
    }

    public void printMethodCallCnt() {
        methodCallCnt.forEach((k, v) -> System.out.printf("%s was called %d times\n", k, v));
    }
}
