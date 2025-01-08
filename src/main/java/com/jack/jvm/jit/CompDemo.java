package com.jack.jvm.jit;

/**
 加入 JVM 参数：
 -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions
 后可以看到以下的执行日志
 */
public class CompDemo {
    private int add1(int x1,int x2,int x3,int x4){
        return add2(x1,x2)+ add2(x3,x4);
    }
    private int add2(int x1, int x2){
        return x1+x2;
    }
    //内联优化
    private int add(int x1,int x2,int x3,int x4){
        return x1+x2+x3+x4;
    }

    public static void main(String[] args) {
        CompDemo compDemo = new CompDemo();
        //超过方法调用计数器的阈值 100000 次，才会进入 JIT 实时编译，进行内联优化。
        for (int i = 0; i < 1000000; i++) {
            compDemo.add1(1,2,3,4);
        }
    }
}
