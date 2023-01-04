import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static FileUtils fileUtils = new FileUtils("./data.txt");;
    private static ArrayList<Student> studentsList;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (true) {

            // 打印选项列表
            printChoice();
            // 输入选项序号
            choice = input.nextInt();
            switch (choice) {

                case 1:
                    studentsList = fileUtils.readFile();
                    if (studentsList == null) {
                        studentsList = new ArrayList<>();
                    }
                    Student student = addStudent();
                    studentsList.add(student);
                    fileUtils.writeFile(studentsList);
                    break;

                case 2:
                    System.out.print("您要删除学生的学号：");
                    input.nextLine();
                    String id = input.nextLine();
                    studentsList = fileUtils.readFile();
                    boolean flag_delete = false;
                    for (int i = 0; i < studentsList.size(); i++) {
                        // 若有该学生信息
                        if(id.equals(studentsList.get(i).getId())){
                            studentsList.remove(i);
                            fileUtils.writeFile(studentsList);
                            flag_delete = true;
                            System.out.println("删除成功！！！");
                            break;
                        }
                    }
                    if(!flag_delete){
                        System.out.println("无该学生信息！！！");
                    }
                    break;

                case 3:
                    System.out.print("您要修改学生的学号：");
                    input.nextLine();
                    String id1 = input.nextLine();
                    boolean flag_edit = false;
                    studentsList = fileUtils.readFile();
                    for (int i = 0; i < studentsList.size(); i++) {
                        // 若有该学生信息
                        if(id1.equals(studentsList.get(i).getId())){
                            Student student1 = editInformation(studentsList.get(i));
                            studentsList.set(i, student1);
                            fileUtils.writeFile(studentsList);
                            flag_edit = true;
                            System.out.println("修改成功！！！");
                            break;
                        }
                    }

                    if(!flag_edit){
                        System.out.println("无该学生信息！！！");
                    }
                    break;

                case 4:
                    System.out.print("您要查找的学生的学号：");
                    input.nextLine();
                    String id2 = input.nextLine();
                    boolean flag_search = false;
                    studentsList = fileUtils.readFile();
                    for (int i = 0; i < studentsList.size(); i++) {
                        // 若有该学生信息
                        if(id2.equals(studentsList.get(i).getId())){
                            Student student2 = editInformation(studentsList.get(i));
                            flag_search = true;
                            print_one(student2);
                            break;
                        }
                    }

                    if(!flag_search){
                        System.out.println("无该学生信息！！！");
                    }
                    break;

                case 5:
                    studentsList = fileUtils.readFile();
                    if (studentsList != null && studentsList.size() > 0) {
                        printAll(studentsList);
                    }else{
                        System.out.println("无学生信息！！！");
                    }
                    break;

                case 6:
                    deleteAll();
                    System.out.println("删除成功！！!");
                    break;

                case 7:
                    // 退出系统
                    System.exit(0);
                    break;
            }
        }

    }

    /**
     * 打印操作选项
     */
    public static void printChoice() {

        System.out.println("\n----------学生信息管理系统----------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生信息");
        System.out.println("4.根据学号查找学生");
        System.out.println("5.查看所有学生信息");
        System.out.println("6.删除所有学生信息");
        System.out.println("7.退出系统");
        System.out.print("您的选择：");
    }

    /**
     * 添加学生信息
     */
    public static Student addStudent() {
        String id, name, address, phoneNum;
        int age;

        Scanner input = new Scanner(System.in);

        System.out.print("请输入学生学号：");
        id = input.nextLine();
        System.out.print("请输入学生姓名：");
        name = input.nextLine();
        System.out.print("请输入学生年龄：");
        age = input.nextInt();
        // 吞掉多余的回车
        input.nextLine();
        System.out.print("请输入学生居住地址：");
        address = input.nextLine();
        System.out.print("请输入学生联系方式：");
        phoneNum = input.nextLine();

        // 返回学生对象
        return new Student(id, name, address, phoneNum, age);
    }

    /**
     * 查询所有学生信息
     * @return 返回学生列表
     */
    public static ArrayList<Student> searchAll() {

        return fileUtils.readFile();
    }

    /**
     * 控制台输出所有学生信息
     * @param list 学生信息列表
     */
    public static void printAll(ArrayList<Student> list) {

        System.out.println("学号\t\t\t\t姓名\t\t\t联系方式\t\t\t年龄\t\t\t居住地址");
        for (Student student: list) {
            System.out.println(student.toString());
        }

    }

    /**
     * 删除所有学生信息
     */
    public static void deleteAll() {
        studentsList.clear();
        fileUtils.writeFile(studentsList);
    }

    /**
     * 修改学生信息
     * @param student 待修改的学生
     * @return 返回修改后的学生信息
     */
    public static Student editInformation(Student student) {
       // 调用添加学生方法即可
       student = addStudent();
       return student;
    }

    /**
     * 输出一个学生的信息
     * @param student 学生对象
     */
    public static void print_one(Student student) {
        System.out.println("学号\t\t\t\t姓名\t\t\t联系方式\t\t\t年龄\t\t\t居住地址");
        System.out.println(student.toString());

    }

}
