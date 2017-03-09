/**
 * Created by Катя on 01.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        level3();
    }

    public static void level1(){
        ShellSort shellSort = new ShellSort("weight",10);
        System.out.println();
        shellSort.output();
        shellSort.sortShell();
        System.out.println();
        shellSort.output();
    }

    public static void level2(){
        ShellSort2 shellSort = new ShellSort2("",10);
        shellSort.output();
        shellSort.sortShell();
        System.out.println();
        shellSort.output();
    }

    public static void level3(){
        int size=10;
        MergeSort mergeSort = new MergeSort("weight",size);
        mergeSort.output();
        mergeSort.mergeSort();
        System.out.println();
        mergeSort.output();
    }
}
