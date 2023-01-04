import java.io.Serializable;


// 学生类
public class Student implements Serializable {

    private String id;
    private String name;
    private String address;
    private String phoneNum;
    private int age;

    // 有参构造函数

    /**
     *
     * @param id        学号
     * @param name      姓名
     * @param address   地址
     * @param phoneNum  联系方式
     * @param age       年龄
     */
    public Student(String id, String name, String address, String phoneNum, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.id + "\t\t" + this.name + "\t\t" + this.phoneNum + "\t\t" + this.age + "\t\t" + this.address;
    }
}
