package tw.com.pcschool.dd2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tw.com.pcschool.dd2018011701.data.DBType;
import tw.com.pcschool.dd2018011701.data.Student;
import tw.com.pcschool.dd2018011701.data.StudentDAO;
import tw.com.pcschool.dd2018011701.data.StudentDAOFactory;
import tw.com.pcschool.dd2018011701.data.StudentFileDAO;
import tw.com.pcschool.dd2018011701.data.StudentScoreDAO;

public class MainActivity extends AppCompatActivity {
    public static StudentDAO dao;
    DBType dbType;
    ListView lv;
    ArrayList<String> studentNames;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbType = DBType.CLOUD;
        dao = StudentDAOFactory.getDAOInstance(this, dbType);
        studentNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentNames);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }
    public void refreshData()
    {
        studentNames.clear();
        for (Student s : dao.getList())
        {
            studentNames.add(s.name);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
