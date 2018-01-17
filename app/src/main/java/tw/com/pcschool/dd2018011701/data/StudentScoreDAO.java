package tw.com.pcschool.dd2018011701.data;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentScoreDAO {
    public ArrayList<Student> mylist;
    public StudentScoreDAO()
    {
        mylist = new ArrayList<>();
    }
    public boolean add(Student s)
    {
        mylist.add(s);
        return true;
    }
    public ArrayList<Student> getList()
    {
        return mylist;
    }
    public Student getStudent(int id)
    {
        for (Student s : mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }
}
