package com.java11.samples.weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Gfg {
    int i = 0;

    public void x(int i) {
        this.i = i;
        System.out.println("Gfg x function " + this.i);
    }

    @Override
    public String toString() {
        return "Gfg{" +
                "i=" + i +
                '}';
    }
}

public class WeakReferenceExample {

    public static void main(String[] args) {
        weakReference();
        System.out.println("-------------------------------------------------");
        softReference();
        System.out.println("-------------------------------------------------");
        phantomReference();
    }

    private static void weakReference() {
        System.out.println("Test Weak Reference");
        Gfg g = new Gfg();
        g.x(20);
        WeakReference<Gfg> weakReference = new WeakReference(g);
        g = null;
//        System.gc(); // The below code will throw null pointer exception if Garbage collection takes place
        g = weakReference.get();
        System.out.println(g);
        g.x(30);
    }

    private static void softReference() {
        System.out.println("Test Soft Reference");
        Gfg g = new Gfg();
        g.x(20);
        SoftReference<Gfg> softReference = new SoftReference<>(g);
        g = null;
        System.gc(); // The below code will not throw null pointer exception even if Garbage collection takes place
        g = softReference.get();
        System.out.println(g);
        g.x(30);
    }

    private static void phantomReference() {
        System.out.println("Test Phantom Reference");
        Gfg g = new Gfg();
        g.x(20);
        ReferenceQueue<Gfg> referenceQueue = new ReferenceQueue<Gfg>();
        PhantomReference<Gfg> phantomReference = new PhantomReference<>(g, referenceQueue);
        g = null;
//        System.gc(); // The below code will not throw null pointer exception even if Garbage collection takes place
        g = phantomReference.get();
        System.out.println(g);
        System.out.println(referenceQueue.poll());
        g.x(30);
    }

}
