import java.util.Scanner;

/**
 * Created by Катя on 01.03.2017.
 */
public class ShellSort {
    private Student[] students;

    public ShellSort(String auto,int size){
        students=new Student[size];
        switch (auto){
            case "auto":{
                AutoInputData();
                break;
            }
            case "weight":{
                InputWeight();
                break;
            }
            default:{
                InputData();
                break;
            }
        }
    }

    private void AutoInputData(){
        for (int i = 0; i < students.length; i++) {
            students[i]=new Student();
        }
    }

    private void InputData(){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            System.out.print("\nPlease, input weight: ");
            int weight=in.nextInt();
            System.out.print("\nPlease, input height: ");
            int height = in.nextInt();
            students[i]=new Student(weight,height);
            System.out.println(students[i].toString());
        }
    }
    private void InputWeight(){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            System.out.print("\nPlease, input weight: ");
            int weight=in.nextInt();
            students[i]=new Student(weight);
            System.out.println(students[i].toString());
        }
    }

    public void sortShell(){
        int h=1;
        while (h<=(students.length/9)){
            h=h*3+1;
        }
        while (h>0){
            for (int i = h; i < students.length; i++) {
                Student key = students[i];
                int j=i;
                while (j>=h&&key.getWeight()<students[j-h].getWeight()){
                    students[j]=students[j-h];
                    j=j-h;
                }
                students[j]=key;
            }
            h=h/3;
        }
    }

    public void output(){
        System.out.println(String.format("%-9s | %-5s | %-6s | %s", "Surname", "Name", "Weight", "Stature"));
        for (Student student:students) {
            System.out.println(student);
        }
    }
}
