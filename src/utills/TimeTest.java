package utills;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import sort.Insert;
import sort.Merge;
import sort.Selection;
import sort.Shell;

public class TimeTest {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer= new Stopwatch();
        if(alg.equals("insert")) Insert.sort(a);
        if(alg.equals("select")) Selection.sort(a);
        if(alg.equals("shell")) Shell.sort(a);
        if(alg.equals("merge1")) Merge.sort(a,Merge.version.one);
        if(alg.equals("merge2")) Merge.sort(a,Merge.version.two);
        if(alg.equals("merge3")) Merge.sort(a,Merge.version.three);

        return timer.elapsedTime();
        
    }

    // T number of N length list
    public static double timeRandomInput(String alg, int N , int T){
        double totalTime = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for(int j = 0 ; j < N ; j++){
                a[j] = StdRandom.uniformDouble();
            }   

            totalTime += time(alg, a);
        }
        return totalTime;

    }

    public static Double[] timeListInput(String[] algs , int N , int T)
    {
        int algsLength = algs.length;
        Double[] timeList = new Double[algsLength];
        int num = 0;
        for (String name : algs) {
            Double time =  timeRandomInput(name, N, T);
            timeList[num] = time;
            num++;
        }

        return timeList;

    }
    
}
