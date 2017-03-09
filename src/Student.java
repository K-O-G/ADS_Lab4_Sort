/**
 * Created by Катя on 12.02.2017.
 */
public class Student {


    private String surname;
    private String name;
    private int weight;
    private int height;

    @Override
    public String toString() {
        return String.format("%-9s | %-5s | %-6d | %d cm ", surname, name, weight, height);
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }


    private enum surnameR {Lashenko, Gorobets, Morsenko, Olonko, Duzy, Nonamenko}

    private enum nameR {Vasya, Petya, Vlad, Tolya, Olya, Katya, Vera, Ann}


    public Student(int weight, int height) {
        this.surname = randomSurname();
        this.name = randomName();
        this.weight = weight;
        this.height = height;
    }

    public Student() {
        this.height = randomStature();
        this.surname = randomSurname();
        this.name = randomName();
        this.weight = randomWeight();
    }

    public Student(int weight) {
        this.surname = randomSurname();
        this.name = randomName();
        this.weight = weight;
        this.height = randomStature();
    }
//
//    public Student(int height) {
//        this.surname = randomSurname();
//        this.name = randomName();
//        this.weight = randomWeight();
//        this.height = height;
//    }


    private int randomWeight() {
        return (int) (Math.random() * 60) + 40;
    }

    private int randomStature() {
        return (int) (Math.random() * 70) + 130;
    }

    private String randomSurname() {
        return (surnameR.values()[(int) (Math.random() * 6)]).toString();
    }

    private String randomName() {
        return (nameR.values()[(int) (Math.random() * 8)]).toString();
    }
}