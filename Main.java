import java.util.ArrayList;


abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Elmoyee=[name="+name+",id="+id+",Salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
            super(name,id);
            this.hoursWorked=hoursWorked;
            this.hourlyRate=hourlyRate;
        }

 @Override
    public double calculateSalary(){
     return hourlyRate*hoursWorked;
  }
}

//ArrayList<Employee> employeeList=new ArrayList<>();

 class PayrollSystem{
    private ArrayList<Employee> employeeList= new ArrayList<>();

    public PayrollSystem(){
        employeeList =new ArrayList<>();
    }

    public  void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmloyee(int id){
        Employee employeeToRemove=null;
        for(Employee e:employeeList){
            if(e.getId()==id){
                employeeToRemove=e;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee e:employeeList){
            System.out.println(e);
        }
    }
}

public class Main{
    public static void main(String[] args) {
            PayrollSystem obj=new PayrollSystem();
            FullTimeEmployee emp1=new FullTimeEmployee("Vikas", 1, 70000);
            PartTimeEmployee emp2=new PartTimeEmployee("Ram", 2, 40, 100);

            obj.addEmployee(emp1);
            obj.addEmployee(emp2);

            System.out.println("Intial Employee Details: ");
            obj.displayEmployee();

            obj.removeEmloyee(2);
            System.out.println("\nRemoving Emplyees...");

            System.out.println("\nRemaining Employee Details:");
            obj.displayEmployee();
        }
 }