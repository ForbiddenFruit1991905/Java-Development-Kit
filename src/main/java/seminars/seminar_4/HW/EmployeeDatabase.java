package seminars.seminar_4.HW;

/*
Создать справочник сотрудников.
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер;
Номер телефона;
Имя;
Стаж.
Добавить метод, который ищет сотрудника по стажу (может быть список).
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список).
Добавить метод, который ищет сотрудника по табельному номеру.
Добавить метод добавления нового сотрудника в справочник.
 */

import java.util.*;

public class EmployeeDatabase {
    public static void main(String[] args) {
        EmployeeDatabase employeeDatabase = new EmployeeDatabase(12345, "89107777777", "V", 7);
        employeeDatabase.addEmployee(12345, "89107777777", "V", 7);
        employeeDatabase.addEmployee(23456, "8916888888", "D", 10);

        for (Object employee : employeeDatabase.getEmployees()) {
            System.out.println(employee);
        }

        System.out.println("Employees with experience 10 years: " + employeeDatabase.findByWorkExperience(10));
        System.out.println("Phone number of employee 'V': " + employeeDatabase.findNumberByName("V"));
        System.out.println("Employee with number 23456: " + employeeDatabase.findEmployeeByNumber(23456));
    }

    private int employeeNumber;
    private String phoneNumber;
    private String name;
    private static int workExperience;
    private ArrayList employees;

    public EmployeeDatabase(int employeeNumber, String phoneNumber, String name, int workExperience) {
        this.employeeNumber = employeeNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
        employees = new ArrayList();
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public static int getWorkExperience() {
        return workExperience;
    }

    public ArrayList getEmployees() {
        return employees;
    }

    // метод добавления нового сотрудника в справочник
    public void addEmployee(int employeeNumber, String phoneNumber, String name, int workExperience) {
        EmployeeDatabase employee = new EmployeeDatabase(employeeNumber, phoneNumber, name, workExperience);
        employees.add(employee);
    }
    
    // метод, который ищет сотрудника по стажу (может быть список)
    public Map<Integer, String> findByWorkExperience(int exp) {
        Map<Integer, String> newMap = new HashMap<>();
        for (Object emp : employees) {
            EmployeeDatabase employee = (EmployeeDatabase) emp;
            if (exp == getWorkExperience()) {
                newMap.put(employee.getWorkExperience(), employee.getName());
            }
        }
        return newMap;
        /*
         return employees.stream()
            .filter(emp -> emp instanceof EmployeeDatabase)
            .map(emp -> (EmployeeDatabase) emp)
            .filter(emp -> emp.getWorkExperience() == exp)
            .collect(Collectors.toList());
         */
    }

    // метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public Map<String, String> findNumberByName(String name) {
        Map<String, String> newMap = new HashMap<>();
        for (Object emp : employees) {
            EmployeeDatabase employee = (EmployeeDatabase) emp;
            if (name.equals(employee.getName())) {
                newMap.put(employee.getName(), employee.getPhoneNumber());
            }
        }
        return newMap;
        /*
        return employees.stream()
            .filter(emp -> emp instanceof EmployeeDatabase)
            .map(emp -> (EmployeeDatabase) emp)
            .filter(emp -> name.equals(emp.getName()))
            .collect(Collectors
            .toMap(EmployeeDatabase::getName,
            EmployeeDatabase::getPhoneNumber));
         */
    }

    // метод, который ищет сотрудника по табельному номеру
    public Map<Integer, String> findEmployeeByNumber(Integer employeeNumber) {
        Map<Integer, String> newMap = new HashMap<>();
        for (Object emp : employees) {
            EmployeeDatabase employee = (EmployeeDatabase) emp;
            if (employeeNumber.equals(employee.getEmployeeNumber())) {
                newMap.put(employee.getEmployeeNumber(), employee.getName());
            }
        }
        return newMap;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", Employee Number: " + employeeNumber + ", Phone Number: " + phoneNumber + ", Work Experience: " + workExperience + " years.";
    }

}
