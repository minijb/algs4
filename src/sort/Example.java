package sort;
import edu.princeton.cs.algs4.StdOut;

public class Example {
    public static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int x, int y) {
        Comparable t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static void show(Comparable[] a) {
        for( int i = 0 ; i < a.length ; i++){
            StdOut.print(a[i]);
            StdOut.print(" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for ( int i = 1 ; i < a.length ; ++i ){
            if (less(a[i] , a[i-1])) return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a , int low , int high) {
       for (int i = low+1; i < high+1; i++) {
            if(less(a[i], a[i-1])) return false;
       } 
       return true;
    }
}
