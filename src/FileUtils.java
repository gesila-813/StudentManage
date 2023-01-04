import java.io.*;
import java.util.ArrayList;

/**
 * 文件读取工具类
 * 封装了文件操作相关的函数
 */
public class FileUtils {

    private String file_path;

    /**
     * 构造函数
     * @param file_path 文件地址
     */
    public FileUtils(String file_path) {
        this.file_path = file_path;
    }


    /**
     * 写文件 采用序列化操作读写对象
     * @param studentList 学生对象列表
     */
    public void writeFile(ArrayList<Student> studentList){
        // 输出流
        try {
            File file = new File(this.file_path);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 读取文件
     * @return 返回学生信息列表
     */
    public ArrayList<Student> readFile() {

        try {
            File file = new File(this.file_path);
            if (!file.exists()) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.file_path));
            ArrayList<Student> studentList = (ArrayList<Student>) objectInputStream.readObject();
            return studentList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
