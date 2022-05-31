package models;

import java.io.Serializable;


public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double mediumscore;

    public Student() {
    }

    public Student(int id, String name, int age, String gender, String address, double mediumscore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumscore = mediumscore;
    }

    public int getId() {
        return id;
    }

    public void setMsv(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumscore() {
        return mediumscore;
    }

    public void setMediumscore(double mediumscore) {
        this.mediumscore = mediumscore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mediumscore=" + mediumscore +
                '}';
    }


}