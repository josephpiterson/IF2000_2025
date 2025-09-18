package IF2000_Lab_3.domain_lab3;

public class Person {
    //atributos
    private String name;
    private String Lastname;
    private String id;
    private String phone;
    private int age;

    public Person(String name,String Lastname, String id,String phone,int age){
        this.name=name;
        this.Lastname=Lastname;
        this.id=id;
        this.phone=phone;
        this.age=age;
    }
    public Person(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }   
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" 
        + getName() 
        + ", Lastname=" 
        + getLastname() 
        + ", id=" + getId() 
        + ", phone=" 
        + getPhone() 
        + ", age=" 
        + getAge()
        ;
    }


}
