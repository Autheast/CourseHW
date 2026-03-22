import java.util.Objects;


public class Employee {

    private String fullName;
    private int department;
    private int salary;

    private int id;
    private static int idGenerator = 1;

    public Employee(String fullName, int department, int salary) {
        id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;


    }

    //Геттеры

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary()
    {
        return salary;
    }

    //Сеттеры

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(salary);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary;
    }

    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ". Зарплата: " + salary);
    }
}
