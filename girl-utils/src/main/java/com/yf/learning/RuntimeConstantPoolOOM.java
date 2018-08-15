package com.yf.learning;

import java.util.ArrayList;
import java.util.List;

//代码清单2-6
//        运行时常量池导致的内存溢出异常

/**
 * VM
 * Args：-XX：PermSize=10M-XX：MaxPermSize=10M
 *
 * @author zzm
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
//使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
//10MB的PermSize在integer范围内足够产生OOM了
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }

        String stre = "计算机科学112";


        String str1 = new StringBuilder("计算机").append("科学").toString();
        String str2 = new StringBuilder("计算机").append("科学112").toString();

//        intern 取回的是常量池的引用   字符串常量池中已经有它的引用了，不符合“ 首次出现” 的原则
        System.out.println(str1 == str1.intern());
        System.out.println(str2 == str2.intern());
    }
}