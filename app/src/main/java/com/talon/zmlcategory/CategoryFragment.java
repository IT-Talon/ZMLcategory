package com.talon.zmlcategory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private MyGridView mGridView1;
    private MyGridView mGridView2;
    private List<String> itemData;
    private List<String> gv1_data;
    private List<String> gv2_data;
    private final int SHOW_LIMIT_NUMBER = 6;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mGridView1 = (MyGridView) view.findViewById(R.id.item_gridview1);
        mGridView2 = (MyGridView) view.findViewById(R.id.item_gridview2);
        initData();
        return view;
    }

    private void initData() {
        itemData = new ArrayList<>();
        gv1_data = new ArrayList<>();
        gv2_data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            itemData.add("grid" + i);
        }
        if (itemData.size() > SHOW_LIMIT_NUMBER) {
            for (int i = 0; i < SHOW_LIMIT_NUMBER - 1; i++) {
                gv1_data.add(itemData.get(i));
            }
            gv1_data.add("+");
            mGridView1.setAdapter(new GridViewAdapter(getContext(), gv1_data));
            for (int i = SHOW_LIMIT_NUMBER; i < itemData.size(); i++) {
                gv2_data.add(itemData.get(i));
            }
            gv2_data.add("-");
            mGridView2.setAdapter(new GridViewAdapter(getContext(), gv2_data));
            mGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (itemData.size() > SHOW_LIMIT_NUMBER && position == itemData.size() - SHOW_LIMIT_NUMBER) {
                        //若点击末尾的“-”，则将gridview折叠，并修改第一部分最后位置为“+”（可展开状态）
                        View rel = mGridView1.getChildAt(SHOW_LIMIT_NUMBER - 1);
                        TextView tv = (TextView) rel.findViewById(R.id.gv_btn);
                        tv.setText("+");
                        mGridView2.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(getContext(), "grid position:" + (position + SHOW_LIMIT_NUMBER), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            mGridView1.setAdapter(new GridViewAdapter(getContext(), itemData));
        }

        mGridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (itemData.size() > SHOW_LIMIT_NUMBER && position == SHOW_LIMIT_NUMBER - 1) {
                    TextView tv = (TextView) view.findViewById(R.id.gv_btn);
                    String content = tv.getText().toString();
                    if (content.equals("+")) {
                        //若点击“+”，则进行展开操作，即显示第二部分gridview，并修改最后位置为“+”
                        tv.setText(itemData.get(SHOW_LIMIT_NUMBER - 1));
                        mGridView2.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(getContext(), "grid position:" + position, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "grid position:" + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
