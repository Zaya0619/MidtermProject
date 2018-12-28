package design;

import databases.ConnectToMongoDB;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import  java.util.HashMap;

public class EmployeeFortune {

    private static final int NumberOfYearsWithCompany = 8;

    /**
     * EmployeeFortune class has a main methods where you will be able to create Object from
     * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible
     * to use with proper business work flow.Think as a Software Architect, Product Designer and
     * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
     * more to design an application that will meet for fortune 500 Employee Information
     * Services.
     * <p>
     * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
     **/
    public static void main(String[] args) {
        String vision = "We Belive in Information";

        EmployeeInfo employee1 = new EmployeeInfo("John", 1212);
        EmployeeInfo employee2 = new EmployeeInfo("Suzy", 1313);
        EmployeeInfo employee3 = new EmployeeInfo("Joe", 1414);
        EmployeeInfo employee4 = new EmployeeInfo("Grace", 1515);

        employee1.assignDepartment("IT");
        employee2.assignDepartment("Sales");
        employee3.assignDepartment("HR");
        employee4.assignDepartment("Marketing");

        employee1.setSalary(8000);
        employee1.calculateSalary(employee1.getSalary());
        employee2.setSalary(7000);
        employee2.calculateSalary(employee2.getSalary());
        employee3.setSalary(6500);
        employee3.calculateSalary(employee3.getSalary());
        employee4.setSalary(7500);
        employee4.calculateSalary(employee4.getSalary());

        employee1.createCompany(vision);
        employee2.createCompany(vision);
        employee3.createCompany(vision);
        employee4.createCompany(vision);

        employee1.setPerformance(8);
        double bonus1212 = employee1.calculateEmployeeBonus(employee1.getSalary(), employee1.getPerformance());
        employee2.setPerformance(6);
        double bonus1313 = employee2.calculateEmployeeBonus(employee2.getSalary(), employee2.getPerformance());
        employee3.setPerformance(4);
        double bonus1414 = employee3.calculateEmployeeBonus(employee3.getSalary(), employee3.getPerformance());
        employee4.setPerformance(2);
        double bonus1515 = employee4.calculateEmployeeBonus(employee4.getSalary(), employee4.getPerformance());

        EmployeeInfo.calculateEmployeePension(employee1.getSalary());

        Map<Integer, ArrayList<Object>> employeeInfo = new HashMap<Integer, ArrayList<Object>>();
        ArrayList<Object> employeeRecord1212 = new ArrayList<Object>();
        employeeRecord1212.add(employee1.employeeName());
        employeeRecord1212.add(employee1.calculateSalary(employee1.getSalary()));
        employeeRecord1212.add(bonus1212);

        ArrayList<Object> employeeRecord1313 = new ArrayList<Object>();
        employeeRecord1313.add(employee2.employeeName());
        employeeRecord1313.add(employee2.calculateSalary(employee2.getSalary()));
        employeeRecord1313.add(bonus1313);

        ArrayList<Object> employeeRecord1414 = new ArrayList<Object>();
        employeeRecord1414.add(employee3.employeeName());
        employeeRecord1414.add(employee3.calculateSalary(employee3.getSalary()));
        employeeRecord1414.add(bonus1414);

        ArrayList<Object> employeeRecord1515 = new ArrayList<Object>();
        employeeRecord1515.add(employee4.employeeName());
        employeeRecord1515.add(employee4.calculateSalary(employee4.getSalary()));
        employeeRecord1515.add(bonus1515);

        employeeInfo.put(1212, employeeRecord1212);
        employeeInfo.put(1313, employeeRecord1313);
        employeeInfo.put(1414, employeeRecord1414);
        employeeInfo.put(1515, employeeRecord1515);


        ConnectToMongoDB connection = new ConnectToMongoDB();
        for (Integer obj : employeeInfo.keySet()) {
            for (Object obj1 : employeeInfo.get(obj)) {
                System.out.println(obj1);
                ArrayList<String> list1 = new ArrayList<>();
                list1.add(obj.toString());
                list1.add(obj1.toString());
                //InsertDataFromArrayListToMongoDB(list1, "employee_record", "employee_id", "employee_info");
            }

        }
        System.out.println("Reading from database");
        //ArrayList<String> empRec = ConnectToMongoDB.readDataBase("employee_record", "employee_id", "employee_info")
    }
}
