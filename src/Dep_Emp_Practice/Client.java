package Dep_Emp_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Client class to demonstrate functionality of Department and Employee classes and print highest salary employees in each department
public class Client {
        public static void main(String[] args){
                Department dp1=new Department("IT");
                dp1.addEmp(new Employee("A", 1, "Developer", 3, 10000));
                dp1.addEmp(new Employee("B", 2, "Support", 5, 5000));
                dp1.addEmp(new Employee("C", 3, "Tester", 4, 7000));
                Department dp2=new Department("Tech");
                dp2.addEmp(new Employee("D", 4, "Technician", 6, 9000));
                dp2.addEmp(new Employee("E", 5, "Lead", 7, 8000));
                dp2.addEmp(new Employee("F", 6, "Manager", 8, 6000));

                List<Department> depList= Arrays.asList(dp1,dp2);

                for(Department dp:depList){
                        System.out.println("Department Name"+dp.getName());

                        List<Employee> empList=new ArrayList<>(dp.getEmpList());
                        empList.sort((e1,e2)->e2.getSalary()-e1.getSalary());//Descending

                        if(empList.size()>2){
                                System.out.println("1st Highest in "+dp.getName()+":"+empList.get(0).toString());
                                System.out.println("2nd Highest in "+dp.getName()+":"+empList.get(1).toString());
                        }
                        else{
                                System.out.println("Not Enough Employees for Comparison");
                        }
                }

        }


}
