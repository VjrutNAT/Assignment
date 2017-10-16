package taro.rikkeisoft.com.assignment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import taro.rikkeisoft.com.assignment.R;
import taro.rikkeisoft.com.assignment.adapter.CustomAdapterGridView;
import taro.rikkeisoft.com.assignment.model.Note;

public class MainActivity extends AppCompatActivity {

    private GridView gvNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvNote = (GridView) findViewById(R.id.gv_note);

        ArrayList<Note> data = new ArrayList<>();
        CustomAdapterGridView customAdapterGridView = new CustomAdapterGridView(MainActivity.this, data);
        gvNote.setAdapter(customAdapterGridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent =  new Intent(MainActivity.this, AddContentActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
