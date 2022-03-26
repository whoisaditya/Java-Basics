
/*
2. Create an abstract Employee.java class for XYZ University. The class contains 
fields for EmpID, name, Salary , and age. Include a constructor that requires 
parameters for the EmpID and name. Include getter and setter methods for each 
field; the setName() method is abstract.Create three Employee subclasses 
named Faculty, PartTimeFaculty, and AdminStaff, each with a setSalary() 
method.Salary for an Faculty is [80000-1,75000], Salary for a PartTimeFaculty is 
between [50000-75000], and salary for a Admin staff is between [10000-35000]. 
SLOT: L59-L60
Write an application that creates an array of at least five objects to demonstrate 
how the methods work for objects for each Student type.Sum up the total salary 
of all such 5 employees and display it also.
*/
class Employee {
    int empID;
    String name;
    double salary;
    int age;

    public Employee(int empID, String name, double salary, int age) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // get name
    public String getName() {
        return name;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }
    
}

class Faculty extends Employee{
    public Faculty(int empID, String name, double salary, int age) {
        super(empID, name, salary, age);
    }
    
    public void setSalary(double salary){
        if(salary >= 80000 && salary <= 75000){
            this.salary = salary;
        }
        else{
            System.out.println("Salary is not in the range");
        }
    }
}

class PartTimeFaculty extends Employee{
    public PartTimeFaculty(int empID, String name, double salary, int age) {
        super(empID, name, salary, age);
    }
    
    public void setSalary(double salary){
        if(salary >= 50000 && salary <= 75000){
            this.salary = salary;
        }
        else{
            System.out.println("Salary is not in the range");
        }
    }
}

class AdminStaff extends Employee{
    public AdminStaff(int empID, String name, double salary, int age) {
        super(empID, name, salary, age);
    }
    
    public void setSalary(double salary){
        if(salary >= 10000 && salary <= 35000){
            this.salary = salary;
        }
        else{
            System.out.println("Salary is not in the range");
        }
    }
}


