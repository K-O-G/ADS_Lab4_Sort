import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Катя on 01.03.2017.
 */
public class MergeSort {


    private Student[] students;

    public MergeSort(String auto, int size){
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

    public void mergeSort( ) {
        Student [ ] tmpArray = new Student[students.length];
        mergeSort( students, tmpArray, 0, students.length - 1 );

    }


    private void mergeSort( Student[ ] a, Student[ ] tmpArray,
                                   int left, int right ) {
        if( left < right ) {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right );
        }
    }

    private void merge( Student[ ] a, Student[ ] tmpArray,
                               int leftPos, int rightPos, int rightEnd ) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while( leftPos <= leftEnd && rightPos <= rightEnd )
            if( a[ leftPos ].getWeight()<a[rightPos].getWeight())
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        while( leftPos <= leftEnd )
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        while( rightPos <= rightEnd )
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        for( int i = 0; i < numElements; i++, rightEnd-- )
            a[ rightEnd ] = tmpArray[ rightEnd ];

    }


    public void output(){
        System.out.println(String.format("%-9s | %-5s | %-6s | %s", "Surname", "Name", "Weight", "Stature"));
        for (Student student:students) {
            System.out.println(student);
        }
    }

}
