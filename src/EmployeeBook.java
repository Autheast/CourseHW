
public class EmployeeBook {

    Employee[] employees = new Employee[10];

    //8. Получить список всех сотрудников
    public void getListAllEmployee() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
                count++;
            }
        }
    }

    // 8. Подсчитать среднее значение зарплат
    public double calculateAverageSalary() {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        return (double) sum / count;
    }

    //8. Вывести значения налогов
    public static double outputTaxValues(double salary, String taxType) {
        switch (taxType) {
            case "PROPORTIONAL":
                return salary * 0.13;
            case "PROGRESSIVE":
                if (salary <= 150_000) {
                    return salary * 0.13;
                } else if (salary <= 350_000) {
                    return salary * 0.17;
                } else {
                    return salary * 0.21;
                }
            default:
                return salary * 0.13;
        }
    }

    //8. Получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату
    public void indexSalaryDepartment(int departmentNumber, double percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() != departmentNumber) {
                continue;
            }
            int oldSalary = employee.getSalary();
            int newSalary = (int) (oldSalary * (1 + percent / 100));
            employee.setSalary(newSalary);
        }
    }

    //8. Получить в качестве параметра номер отдела (1–5) и цифру зарплаты
    public void printEmployeeWithSalaryHigher(int departmentNumber, int minSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() > minSalary) {
                    System.out.println("Номер: " + i);
                    employee.printShortInfo();
                    break;
                }
            }
        }

    }

    //8. Получить в качестве параметра цифру зарплаты wage и число сотрудников employeeNumber
    public void getSalaryFigureParameterWage(int wage, int employeeNumber) {
        int count = 0;
        int i = 0;

        while (i < employees.length && count < employeeNumber) {
            Employee employee = employees[i];

            if (employee != null && employee.getSalary() < wage) {
                System.out.println("Сотрудник " + (count + 1) + ": " + employee.getFullName() + ", зарплата: " + employee.getSalary());
                count++;
            }
            if (count == employeeNumber){
                break;
            }
            i++;
        }
        if (count == 0) {
            System.out.println("Сотрудников с зарплатой меньше " + wage + " не найдено");
        }
    }

    //8. Получить в качестве параметра объект сотрудника
    public boolean getEmployeeObjectParameter(Employee targetEmployee){
        for (int i = 0; i < employees.length; i++) {
            if (targetEmployee.equals(employees[i])){
                return true;
            }
        }
        return false;
    }

    //9. Добавьте метод наполнения
    public boolean addEmployee (Employee newEmployee){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }

        }
        return false;
    }

    //10. Добавьте метод для получения сотрудника по Id.

    public Employee getEmployeeById (int id){
        for ( Employee employee: employees){
            if (employee != null && employee.getId()==id){
                return employee;
            }
        }
        return null;
    }




}