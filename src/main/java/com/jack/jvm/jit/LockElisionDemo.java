package com.jack.jvm.jit;

/**
 * 如果给这个示例代码添加一个JVM
 * 参数： -XX:-EliminateLocks 主动关闭锁清除后，
 * 再执行这个案例，两个方法的耗时差距就明显更大了。
 *
 * 添加参数前输出：
 * StringBuffer耗时：1652
 * StringBuilder耗时：1049
 *
 * 参数后：
 * StringBuffer耗时：4526
 * StringBuilder耗时：1074
 */
public class LockElisionDemo{

    public static String BufferString(String s1,String s2){
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

    public static String BuilderString(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            BufferString("aaaaa","bbbbbb");
        }
        System.out.println("StringBuffer耗时："+(System.currentTimeMillis()-startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            BuilderString("aaaaa","bbbbbb");
        }
        System.out.println("StringBuilder耗时："+(System.currentTimeMillis()-startTime2));
    }
}
