package AlgoTasks.t03_sorting2.zadanie33;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Student other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}