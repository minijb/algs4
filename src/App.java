import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import sort.Insert;
import sort.Merge;
import sort.Shell;
import utills.CreateList;
import utills.TimeTest;

public class App {
    public static void timeT(String[] name, int length, int number) {
        for (String string : name) {
            double time = TimeTest.timeRandomInput(string, length, number);
            StdOut.println(string + " : " + time);
        }
    }

    public static void main(String[] args) throws Exception {
        double time = TimeTest.time("merge1", CreateList.createDoubleList(1000000));
        StdOut.print(time+"\n");
        time = TimeTest.time("merge2", CreateList.createDoubleList(1000000));
        StdOut.print(time+"\n");
        time = TimeTest.time("merge3", CreateList.createDoubleList(1000000));
        StdOut.print(time+"\n");
    }
}
