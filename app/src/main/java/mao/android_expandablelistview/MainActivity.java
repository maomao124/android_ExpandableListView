package mao.android_expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mao.android_expandablelistview.adapter.MyBaseExpandableListAdapter;
import mao.android_expandablelistview.entity.Group;
import mao.android_expandablelistview.entity.Item;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView expandableListView = findViewById(R.id.ExpandableListView);

        List<Group> groupList = new ArrayList<>(5);

        groupList.add(new Group("分组一"));
        groupList.add(new Group("分组二"));
        groupList.add(new Group("分组三"));
        groupList.add(new Group("分组四"));
        groupList.add(new Group("分组五"));
        groupList.add(new Group("分组六"));
        groupList.add(new Group("分组七"));
        groupList.add(new Group("分组八"));
        groupList.add(new Group("分组九"));

        List<List<Item>> itemList = new ArrayList<>();

        for (int i = 0; i < groupList.size(); i++)
        {
            List<Item> list = new ArrayList<>(20);
            for (int j = 0; j < 20; j++)
            {
                String name = UUID.randomUUID().toString().substring(0, 6);
                list.add(new Item().setIcon(R.mipmap.ic_launcher).setName(name));
            }
            itemList.add(list);
        }

        BaseExpandableListAdapter baseExpandableListAdapter = new MyBaseExpandableListAdapter(this, groupList, itemList);

        expandableListView.setAdapter(baseExpandableListAdapter);

    }
}