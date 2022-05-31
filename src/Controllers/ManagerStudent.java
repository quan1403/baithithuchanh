package Controllers;

import jdk.nashorn.internal.ir.Symbol;
import models.SortTangDan;
import models.Student;

import java.util.ArrayList;
import java.util.Collections;
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
                sort();
                break;
            case 6:
            case 7:
            case 8:
                System.exit(0);
                break;
        }
    }

    public void addStudents() {
        try {
            System.out.println("Nhập mã sinh viên:");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập tên sinh viên:");
            String name = sc.nextLine();
            System.out.println("Nhập tuổi sinh sinh viên:");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập giới tính của sinh viên:");
            String gender = sc.nextLine();
            System.out.println("Nhập địa chỉ:");
            String address = sc.nextLine();
            System.out.println("Nhập điểm trung bình");
            double mediumscore = Double.parseDouble(sc.nextLine());
            Student student = new Student(id, name, age, gender, address, mediumscore);
            students.add(student);

        } catch (NumberFormatException e) {
            System.out.println("Nhập lại đi sai cụ m rồi");
            ;
        }

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
                students.get(i).setName(sc.nextLine());
                students.get(i).setAge(Integer.parseInt(sc.nextLine()));
                students.get(i).setGender(sc.nextLine());
                students.get(i).setAddress(sc.nextLine());
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

    public void sort() {
        System.out.println("Chọn chức năng:");
        System.out.println("1.Sắp xếp điểm trung bình tăng dần:");
        System.out.println("2.Sắp xếp điểm giảm dần:");
        System.out.println("3.Thoát");
        int choice1 = Integer.parseInt(sc.nextLine());
        if (choice1 == 1) {
            students.sort(new SortTangDan());
        } else if  (choice1 == 2) {
            Collections.sort(students);
        }

    }


}
