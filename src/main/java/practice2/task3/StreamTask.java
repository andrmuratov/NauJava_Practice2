package practice2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTask {

    public static void main(String[] args) {
        List<Employee> employees = genList();

        System.out.println("Spisok sotrudnikov:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("\nResultat (Imya-Otdel):");
        List<String> result = transform(employees);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static List<Employee> genList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Ivanov Ivan", 25, "IT", 50000.0));
        list.add(new Employee("Petrov Petr", 35, "HR", 45000.0));
        list.add(new Employee("Sidorov Alex", 28, "IT", 60000.0));
        list.add(new Employee("Kozlova Maria", 40, "Finance", 70000.0));
        list.add(new Employee("Smirnov Dmitry", 30, "IT", 55000.0));
        return list;
    }

    private static List<String> transform(List<Employee> list) {
        return list.stream()
                .map(e -> e.getFullName() + "-" + e.getDepartment())
                .collect(Collectors.toList());
    }
}