package com.prosoft.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemAdapter extends BaseAdapter {
    private ArrayList<ListItem> items = new ArrayList<>();
    private Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        ListItem listItem = items.get(position);

        //listview_item 을 inflate -> convertView 참조
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        //화면에 보여질 데이터 참조
        TextView nameList = convertView.findViewById(R.id.nameList);
        TextView contentsList = convertView.findViewById(R.id.contentsList);

        // data 를 set
        nameList.setText(listItem.getName());
        contentsList.setText(listItem.getContentsList());

        return convertView;
    }

    public void addItem(ListItem item) {
        items.add(item);
        notifyDataSetChanged(); // 데이터 변경을 어댑터에 알려서 리스트뷰 갱신
    }

    public void removeItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
            notifyDataSetChanged(); // 데이터 변경을 어댑터에 알려서 리스트뷰 갱신
        }
    }
}
