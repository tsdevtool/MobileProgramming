package com.crissiiu.sqliteex;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;


public class MainActivity extends ListActivity {

    private PeopleDataSource dataSource;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        dataSource = new PeopleDataSource(this);
        dataSource.open();

        //use the SimpleCursorAdapter to show
        //elements in a ListView
        List<Person> values = dataSource.getALlPeople();
        ArrayAdapter<Person> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    //Create event to click buttons in activity_main.xml
    public void onClick(View view ){
        @SuppressWarnings("unchecked")
        ArrayAdapter<Person> adapter = (ArrayAdapter<Person>) getListAdapter();
        Person person = null;
        switch (view.getId()){
            //Them nguoi vao danh sach
            case R.id.add:
                String[] people = new String[] {"Alice", "Bob", "Mallory"};
                int nextInt = new Random().nextInt(3);
                person = dataSource.createPerson(people[nextInt]);
                adapter.add(person);
                break;
            //Xoa nguoi dau tien ra khoi danh sach
            case R.id.delete:
                if (getListAdapter().getCount() > 0){
                    person = (Person) getListAdapter().getItem(0);
                    dataSource.deletePerson(person);
                    adapter.remove(person);
                }
                break;

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume(){
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause(){
        dataSource.close();
        super.onPause();
    }



}