package sort;
public class Shell extends Example{
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3 * h + 1;
        while( h >= 1 )
        {
            for ( int i = h; i < N ; i++){
                Comparable temp = a[i];
                int j = i;
                for(; j >= 0 && j-h >=0 && less(temp , a[j-h]); j = j - h){
                    a[j] = a[j-h];
                }
                a[j] = temp;
            }
            h = h / 3;
        }
        
    }
}
