package sort;


public class Merge extends Example{
    public static enum version{
        one,two,three;
    }

    public static void sort(Comparable[] a,version v) {
        switch(v) {
            case one:
                aux = new Comparable[a.length];
                sort(a, 0 , a.length-1);
                break;
            case two:
                sort(a.clone(),a,0,a.length-1);//通过交换参数避免对于辅助数组的复制
                break;
            case three:
                sortBottomToUp(a);

        }
    }

    public static void sort(Comparable[] a , int low , int high) {
        int mid = ( low + high ) /2;
        if((high - low) < 64){
            Insert.sort(a,low,high);
        }
        else{
            sort(a, low, mid);
            sort(a, mid+1, high);
            if( less(a[mid], a[mid+1]) ) return; //因为部分有序，因此可以进行截断
            merge(a, low, mid, high); 
        }
    }


    //use Auxiliary array
    public static Comparable[] aux;
    public static void merge(Comparable[] a , int low , int mid , int high)
    {
        int i = low ,j = mid+1;
        //复制
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];   
        }
        for(int k = low ; k <= high ; k++)
        {
            if   ( i > mid )                     a[k]      = aux[j++];
            else if( j > high )                      a[k]  = aux[i++];
            else if( less(aux[j], aux[i]) )           a[k] = aux[j++];
            else a[k]                                      = aux[i++];
        }
    }


    public static void sort(Comparable[] src , Comparable[] dst , int l , int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort(dst, src, l, mid);
        sort(dst, src, mid + 1, r);
        merge(src, dst, l, mid, r);
    }

    public static void merge(Comparable[]src , Comparable[] dst, int l, int mid, int r) {
        int i = l, j = mid + 1;
        // System.arraycopy(a, l, aux, l, r - l + 1); 避免数组复制
        for (int k = l; k <= r; k++) {
          if (i > mid) dst[k] = src[j++];
          else if (j > r) dst[k] = src[i++];
          else if (less(src[i], src[j])) dst[k] = src[i++];
          else dst[k] = src[j++];
        }
    }


    //自底向上的排序算法
    public static void sortBottomToUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        //sz -- 每次排序的数组长度
        for (int sz = 1; sz < N; sz = sz*2) {
            for (int lo = 0; lo < N-sz; lo += sz*2) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz+1, N-1));
                //确保不会超过数组
            }
        }
    }
}
