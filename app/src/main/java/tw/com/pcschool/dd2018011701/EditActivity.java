package tw.com.pcschool.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tw.com.pcschool.dd2018011701.data.Student;

public class EditActivity extends AppCompatActivity {
    int id;
    Student s;
    TextView tv4;
    EditText ed4, ed5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getStudent(id);
        tv4 = findViewById(R.id.textView4);
        ed4 = findViewById(R.id.editText4);
        ed5 = findViewById(R.id.editText5);

        tv4.setText(String.valueOf(s.id));
        ed4.setText(s.name);
        ed5.setText(String.valueOf(s.score));
    }
    public void clickBack(View v)
    {
        finish();
    }
    public void clickUpdate(View v)
    {
        Student s = new Student(id, ed4.getText().toString(), Integer.valueOf(ed5.getText().toString()));
        MainActivity.dao.update(s);
        finish();
    }
}
