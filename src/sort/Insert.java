package sort;

public class Insert extends Example {
    /*
     * public static void sort(Comparable[] a) {
     * int N = a.length;
     * for (int i = 1; i < N; i++) {
     * Comparable temp = a[i];
     * int j = i;
     * for (; j > 0 && less(temp, a[j - 1]); j--) {
     * a[j] = a[j-1];
     * }
     * a[j] = temp;
     * }
     * }
     */

    public static void sort(Comparable[] a) {
        int N = a.length;

        // 使用哨兵 --- 消除 j > 0 这个比较！！！
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (less(a[i], a[min])) min = i;
        }
        exch(a, 0, min);

        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int j = i;
            for (;less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    public static void sort(Comparable[] a,int low , int high) {
        int N = high - low + 1;

        // 使用哨兵 --- 消除 j > 0 这个比较！！！
        int min = low;
        for (int i = low; i < high+1; i++) {
            if (less(a[i], a[min])) min = i;
        }
        exch(a, low, min);

        for (int i = low+1; i < high+1; i++) {
            Comparable temp = a[i];
            int j = i;
            for (;less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    // public static void sort(Comparable[] a) {
    // int N = a.length;
    // for (int i = 1; i < N; i++) {
    // for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
    // exch(a, j, j-1);
    // }

    // }
    // }

}
