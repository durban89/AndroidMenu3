package com.gowhich.androidmenu3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) this.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(adapter);

        //给ListView添加Menu上下文
        registerForContextMenu(listView);
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 8; i++){
            list.add("peng"+i);
        }

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.delete:
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onContextItemSelected(item);
    }
}
