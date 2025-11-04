package Dep_Emp_Practice;

public class Employee {

        private String name;
        private int id;
        private String position;
        private int yop;
        private int salary;

        Employee( String name,int id,String position, int yop, int salary){
                this.name=name;
                this.id=id;
                this.position=position;
                this.yop=yop;
                this.salary=salary;
        }
        public String getname(){
                return name;
        }
        public int getId(){
                return id;
        }
        public String getPosition(){
                return position;
        }
        public int getYop(){
                return yop;
        }
        public int getSalary(){
                return salary;
        }

        public String toString(){
                return name+"(Salary: " + salary +", Exp: "+ yop+ ")";
        }
}
