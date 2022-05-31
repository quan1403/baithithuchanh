package models;

import java.util.Comparator;

public class SortTangDan implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getMediumscore() > o2.getMediumscore()) {
            return 1;
        } else {
            return -1;
        }

    }
}
