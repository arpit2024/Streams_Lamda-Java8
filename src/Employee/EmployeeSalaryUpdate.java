package Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeSalaryUpdate {
        private String  name;
        private double salary;

        public EmployeeSalaryUpdate(String name, double salary){
                this.name=name;
                this.salary=salary;
        }

        public  void setName(String name){
            this.name=name;
        }
        public String getName(){
            return name;
        }

        public void setSalary(double salary){
                this.salary=salary;
        }

        public double getSalary(){
            return salary;
        }

        public String toString(){
                //return  "Employee{name="+name+ ", Salary=" + salary + "}";
              return String.format("Employee{name='%s',salary=%.2f}",name,salary);
//                return String.format("name='%s',salary=%.2f",name,salary);
        }


        public static  void main(String[] args){

                Scanner sc=new Scanner(System.in);

                List< EmployeeSalaryUpdate> empList= Arrays.asList(
                        new EmployeeSalaryUpdate("Alice", 18000),
                        new EmployeeSalaryUpdate("Bob", 25000),
                        new EmployeeSalaryUpdate("Charlie", 30000),
                        new EmployeeSalaryUpdate("David", 15000),
                        new EmployeeSalaryUpdate("Eva", 22000)
                );

                //code to give 10% raise to employees with salary > 20000
                List<EmployeeSalaryUpdate> list= empList.stream()
                        .peek(emp-> {// peek lets us modify while streaming
                                if(emp.getSalary()>20000){
                                        emp.setSalary(emp.getSalary()*1.10);
                                }
                        })
                        .collect(Collectors.toList());

                empList.forEach(System.out::println);
        }


}
