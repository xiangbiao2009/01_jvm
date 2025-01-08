package com.jack.jvm.jit;

public class JitDemo {
    private int add(int x){
        return x+1;
    }

    public static void main(String[] args) {
        int a = 0;
        JitDemo demo = new JitDemo();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            a = demo.add(a);
        }
        System.out.println("a= "+a);
        System.out.println(">>>>>>>>"+(System.currentTimeMillis()-l));
    }
}
