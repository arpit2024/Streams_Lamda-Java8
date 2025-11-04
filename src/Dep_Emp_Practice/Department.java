package Dep_Emp_Practice;

import java.util.ArrayList;
import java.util.List;

public class Department {
        private String name;
        private List<Employee> empList;

        Department(String name){
                this.name=name;
                this.empList=new ArrayList<>();
        }

        public void addEmp(Employee emp){
                empList.add(emp);
        }
        public String getName(){
                return name;
        }
        public List<Employee> getEmpList(){
                return empList;
        }
}
