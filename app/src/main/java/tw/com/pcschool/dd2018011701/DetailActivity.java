package tw.com.pcschool.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tw.com.pcschool.dd2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv1, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getStudent(id);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv1.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));
    }
}
