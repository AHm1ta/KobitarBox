package com.example.kobitarbox.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kobitarbox.Adapter.ItemAdapter;
import com.example.kobitarbox.Model.CategoryItem;
import com.example.kobitarbox.R;

import java.util.List;


public class CategoryFragment extends Fragment {

    TextView categoryName;
    GridView gridView;
    ItemAdapter itemAdapter;

    private List<CategoryItem> categoryItemList;
    int categoryId;

    public CategoryFragment(List<CategoryItem> categoryItemList, int categoryId) {
        this.categoryItemList = categoryItemList;
        this.categoryId = categoryId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        gridView=view.findViewById(R.id.gridView);
        categoryName=view.findViewById(R.id.category_name);

        categoryName.setText(categoryItemList.get(0).getCategoryName());
        itemAdapter= new ItemAdapter(getContext(),categoryItemList, categoryId);
        gridView.setAdapter(itemAdapter);
        return view;
    }


}