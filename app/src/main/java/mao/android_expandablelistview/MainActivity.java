package mao.android_expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

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


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
            {
                toastShow("点击了第" + (groupPosition + 1) + "个组");
                return false;
            }
        });

//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
//        {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
//            {
//                toastShow("点击了第" + (groupPosition + 1) + "个组的第" + (childPosition + 1) + "项");
//                return false;
//            }
//        });

//        expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
//        {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                toastShow("长按：" + (position + 1));
//                return true;
//            }
//        });

    }

    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}