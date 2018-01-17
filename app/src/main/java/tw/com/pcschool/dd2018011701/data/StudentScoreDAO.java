package tw.com.pcschool.dd2018011701.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentScoreDAO {
    public ArrayList<Student> mylist;
    public StudentScoreDAO()
    {
        mylist = new ArrayList<>();
    }
    public void add(Student s)
    {
        mylist.add(s);
    }
    public ArrayList<Student> getList()
    {
        return mylist;
    }
}
