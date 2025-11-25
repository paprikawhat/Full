package src.person;

import java.util.Comparator;

public class Person {
    String name;
    String secondName;
    String job;
    String position;
    int experience;
    int age;
    double salary;
    public Person(String name, String SecondName, String job, String position, int experience, int age, double salary) {
        this.name = name;
        this.secondName = SecondName;
        this.job = job;
        this.position = position;
        this.experience = experience;
        this.age = age;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getJob() {
        return job;
    }
    public String getPosition() {
        return position;
    }
    public int getExperience() {
        return experience;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("=======Person========\n" +
                "Name %s %s\n" +
                "Age %d\n" +
                "Job %s\n" +
                "Position %s\n" +
                "Experience %d\n" +
                "Salary %f" +
                "=====================",
                name, secondName, age, job, position, experience, salary);
    }
    public static Comparator<Person> compareByName() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.getName());
            }
        };
    }
    public static Comparator<Person> compareByAge() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };
    }
    public static Comparator<Person> compareBySalary() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.salary - o2.salary == 0) return 0;
                return o1.salary > o2.salary ? +1 : -1;
            }
        };
    }
}
