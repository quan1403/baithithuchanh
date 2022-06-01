package Controllers;


import models.SortGiamDan;
import models.SortTangDan;
import models.Student;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class ManagerStudent {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();

    public void Menu() {
        System.out.println("Menu");
        System.out.println("1.Xem danh sách sinh viên:");
        System.out.println("2.Thêm mới:");
        System.out.println("3.Cập Nhật:");
        System.out.println("4.Xóa:");
        System.out.println("5.Sắp xếp:");
        System.out.println("6.Đọc từ file:");
        System.out.println("7.Ghi từ file:");
        System.out.println("8.Thoát:");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                showAll();
                break;
            case 2:
                addStudents();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                System.out.println("Chọn chức năng:");
                System.out.println("1.Sắp xếp điểm trung bình tăng dần:");
                System.out.println("2.Sắp xếp điểm giảm dần:");
                System.out.println("3.Thoát");
                int choice1 = Integer.parseInt(sc.nextLine());
                switch (choice1) {
                    case 1:
                    students.sort(new SortTangDan());
                    break;
                    case 2:
                    students.sort(new SortGiamDan());
                    break;
                    case 3:
                    default:
                        System.out.println("lựa chọn sai");
                }
                break;
            case 6:

                students=Reader();
                break;
            case 7:
                write();
                break;
            case 8:
                System.exit(0);
                break;
        }
    }

    public Student creatStudents() {
        String gender = null;
        int id = 0;
        String name = null;
        int age = 0;
        String address = null;
        double mediumscore = 0;
        try {
            System.out.println("Nhập mã sinh viên:");
            id = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập tên sinh viên:");
            name = sc.nextLine();
            System.out.println("Nhập tuổi sinh sinh viên:");
            age = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập giới tính của sinh viên:");
            gender = sc.nextLine();
            System.out.println("Nhập địa chỉ:");
            address = sc.nextLine();
            System.out.println("Nhập điểm trung bình");
            mediumscore = Double.parseDouble(sc.nextLine());


        } catch (NumberFormatException e) {
            System.out.println("Nhập lại đi sai cụ m rồi");

        }

        return new Student(id, name, age, gender, address, mediumscore);
    }
    public void addStudents(){
        students.add(creatStudents());
    }

    public void showAll() {
        for (Student a : students
        ) {
            System.out.println(a);

        }
    }

    public void edit() {
        System.out.println("Nhập id muốn sửa:");
        int id = Integer.parseInt(sc.nextLine());
        boolean isExisted = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                isExisted = true;
                students.remove(i);
               addStudents();
                break;

            }
        }
        if (!isExisted) {
            System.out.println("id không tồn tại");

        }
    }

    public void delete() {
        System.out.println("Nhập id muốn xóa:");
        int id = Integer.parseInt(sc.nextLine());
        Student student = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
                break;
            }
        }
        if (student != null) {
            students.remove(student);
        } else {
            System.out.println("không có id ");
        }
    }
    public void write(){
        ObjectOutputStream output = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\weed4-module2\\baithithuchanh1\\src\\danhsachSV.csv");
            output = new ObjectOutputStream(fileOutputStream);

            output.writeObject(students);
            output.flush();
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ghi file thành công");
    }
    ArrayList<Student> Reader()  {
        ObjectInputStream inputStream;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\weed4-module2\\baithithuchanh1\\src\\danhsachSV.csv");
            inputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Student>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }




}
