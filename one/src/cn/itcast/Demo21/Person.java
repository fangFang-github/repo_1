package cn.itcast.Demo21;

public class Person {
    private String name;
    protected int age;
    String sex;
    public boolean marry;

    public Person() {
    }

    public Person(String name, int age, String sex, boolean marry) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.marry = marry;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", marry=" + marry +
                '}';
    }

    public void eat(){
        System.out.println("eat...");
    }

    public void eat(String food){
        System.out.println("eat..."+food);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }
}
