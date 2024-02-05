package Java17;

/**
 * records will allow you to create immutable data classes
 */
 record Employee(Long id,double salary,int yearOfExperience ) {}

class  Records{
    public static void main(String[] args) {
        Employee emp=new Employee(1L,100000,10);

        System.out.println(emp);
        System.out.println(emp.id());
    }
}
