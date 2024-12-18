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
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        employeeDatabase.addEmployee(23456, "8916888888", "D", 10);
        employeeDatabase.addEmployee(12345, "89107777777", "V", 7);
        employeeDatabase.addEmployee(34567, "89158883344", "E", 20);
        employeeDatabase.addEmployee(45678, "88100007777", "S", 23);

        
        for (Object employee : employeeDatabase.getEmployees()) {
            System.out.println(employee);
        }

        Map<Integer, String> phoneExpMap = employeeDatabase.findByWorkExperience(20);
        System.out.println("Employees with experience:");
        for (Map.Entry<Integer, String> entry : phoneExpMap.entrySet()) {
            System.out.println("Experience: " + entry.getKey() + ", Name: " + entry.getValue());
        }
        
        Map<String, String> numMap = employeeDatabase.findNumberByName("V");
        System.out.println("Phone number of employee:");
        for (Map.Entry<String, String> entry : numMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone number: " + entry.getValue());
        }
        
        Map<Integer, String> empNumMap = employeeDatabase.findEmployeeByNumber(23456);
        System.out.println("Employee by employee number:");
        for (Map.Entry<Integer, String> entry : empNumMap.entrySet()) {
            System.out.println("Employee number: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    private int employeeNumber;
    private String phoneNumber;
    private String name;
    private int workExperience;
    private ArrayList employees;

    public EmployeeDatabase(int employeeNumber, String phoneNumber, String name, int workExperience) {
        this.employeeNumber = employeeNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    public EmployeeDatabase() {
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

    public int getWorkExperience() {
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
            if (exp == employee.getWorkExperience()) {
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
