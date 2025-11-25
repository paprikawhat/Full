package src.person;

import java.util.Random;

public class PersonGenerator {
    static Random random = new Random();
    private static final String[] FIRST_NAMES = {
            "Александр", "Мария", "Дмитрий", "Анна", "Сергей", "Елена",
            "Андрей", "Ольга", "Михаил", "Ирина", "Алексей", "Наталья",
            "Владимир", "Татьяна", "Иван", "Светлана", "Екатерина", "Павел"
    };
    private static final String[] LAST_NAMES = {
            "Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов", "Попов",
            "Васильев", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев",
            "Лебедев", "Семенов", "Егоров", "Павлов", "Козлов", "Степанов"
    };
    private static final String[] JOBS = {
            "IT", "Медицина", "Образование", "Строительство", "Торговля",
            "Финансы", "Транспорт", "Производство", "Маркетинг", "Юриспруденция"
    };
    private static final JobPosition[] POSITIONS = {
            new JobPosition("Стажер", 30000),
            new JobPosition("Специалист", 50000),
            new JobPosition("Старший специалист", 70000),
            new JobPosition("Менеджер", 90000),
            new JobPosition("Руководитель отдела", 120000),
            new JobPosition("Директор", 200000)
    };
    private static class JobPosition {
        String position;
        double baseSalary;
        public JobPosition(String position, double baseSalary) {
            this.position = position;
            this.baseSalary = baseSalary;
        }
    }
    private static double calculateSalary(double baseSalary, int experience) {
        double expBonus = baseSalary * experience * 0.1;
        double randomBonus = baseSalary * (random.nextDouble() * 0.2 - 0.1);
        return baseSalary + expBonus + randomBonus;
    }
    private static <T> T getRandomElemnt(T[] array) {
        return array[random.nextInt(array.length)];
    }
    static public Person generateRandomPerson() {
        String name = getRandomElemnt(FIRST_NAMES);
        String secondName = getRandomElemnt(LAST_NAMES);
        String job = getRandomElemnt(JOBS);
        JobPosition jobPosition = getRandomElemnt(POSITIONS);
        String position = jobPosition.position;
        int age = 18 + random.nextInt(48);
        int maxExp = age - 18;
        int experience = maxExp > 0 ? random.nextInt(maxExp + 1) : 0;
        double salary = calculateSalary(jobPosition.baseSalary, experience);
        return new Person(name, secondName, job, position, experience, age, salary);
    }
    public static Person[] generateMultiplyPersons(int count) {
        Person[] persons = new Person[count];
        for(int i = 0; i < persons.length; i++) {
            persons[i] = generateRandomPerson();
        }
        return persons;
    }
}
