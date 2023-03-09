package utills;

import edu.princeton.cs.algs4.StdRandom;

public class CreateList {
   public static Comparable[] createDoubleList(int N) {
       Comparable[]  a = new Comparable[N];
       for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformDouble();
       }

       return a;
   } 
   public static Comparable[] createInt(int N) {
    Comparable[]  a = new Comparable[N];
    for (int i = 0; i < N; i++) {
         a[i] = StdRandom.uniformInt(N);
    }

    return a;
} 
}
