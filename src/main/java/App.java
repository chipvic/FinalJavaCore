import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class App {

    //Bài 1
    public static void main(String[] args) throws IOException {


        //Bài 1.1. Đọc danh sách sinh viên từ tập tin data.csv được cung cấp
        List<Student> list = readData("data.csv");
        System.out.println("------------" + list.toString());

        List<Student> list1 = readData("data.csv");
        //Bài 1.2. Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất
        System.out.println("Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất");
        sortLTDesc(list);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }

        //Bài 1.4. Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết thấp nhất
        System.out.println("Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết thấp nhất");
        sortLTAsc(list);
        for (int j = 0; j < 10; j++) {
            System.out.println(list.get(j));
        }

        //Bài 2:
        //2.1 Cho biết chuỗi regular-expression để capture được các địa chỉ gmail và outlook
        System.out.println("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@(gmail|outlook).[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");
        Pattern patternGmail = Pattern.compile("\\b[a-zA-Z][\\w\\-\\.]{0,63}\\@(gmail|outlook)." +
                "[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?\\b");

        //2.2 Xây dựng hàm liệt kê thông tin các sinh viên có email là gmail
        List<Student> listStudentGMail = getSVGmail(list, patternGmail);
        System.out.println(listStudentGMail);

        Pattern patternOutlook = Pattern.compile("^(.+)@outlook(.+)$");
        List<Student> listStudentOutlook = getSVGmail(list, patternOutlook);


    }


    public static List<Student> readData(String filePath) throws IOException {
        List<Student> st = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            //Skip header
            if (line.contains("ID,Name,Email,Bonus,Report,App,LT"))
                continue;
            else {
                List<String> data = Arrays.asList(line.split(","));
                Student s1 = new Student();
                s1.setId(data.get(0));
                s1.setName(data.get(1));
                s1.setEmail(data.get(2));
                s1.setBonus(Float.parseFloat(data.get(3)));
                s1.setReport(Float.parseFloat(data.get(4)));
                s1.setApp(Float.parseFloat(data.get(5)));
                s1.setLt(Float.parseFloat(data.get(6)));
                st.add(s1);
            }
        }
        return st;
    }


    //Swap DESC
    public static void sortLTDesc(List<Student> studentList) {
        int n = studentList.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (studentList.get(j - 1).getLt() < studentList.get(j).getLt()) {
                    temp = studentList.get(j - 1);
                    studentList.set(j - 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }

    }

    //Swap ASC
    public static void sortLTAsc(List<Student> studentList) {
        int n = studentList.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (studentList.get(j - 1).getLt() > studentList.get(j).getLt()) {
                    temp = studentList.get(j - 1);
                    studentList.set(j - 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }

    }


}

