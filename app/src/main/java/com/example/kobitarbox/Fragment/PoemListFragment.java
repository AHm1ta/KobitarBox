package com.example.kobitarbox.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kobitarbox.GetCategoryItem;
import com.example.kobitarbox.Model.CategoryItem;
import com.example.kobitarbox.R;

import java.util.List;

public class PoemListFragment extends Fragment {

    ImageView home,prev_btn,next_btn;
    TextView categoryName, poemName,writerName,poem,poem_number;
    int categoryId;
    int poemPosition = 0;
    List<CategoryItem> categoryItems;

    public PoemListFragment(int poemPosition, List<CategoryItem> categoryItems, int categoryId) {
        this.poemPosition = poemPosition;
        this.categoryItems = categoryItems;
        this.categoryId = categoryId;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poem_list, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        home = view.findViewById(R.id.home_btn);
        categoryName = view.findViewById(R.id.category_name_poem);
        poemName = view.findViewById(R.id.poem_name);
        writerName = view.findViewById(R.id.writer_name);
        poem = view.findViewById(R.id.poem);
        poem_number=view.findViewById(R.id.poem_number);
        prev_btn=view.findViewById(R.id.prev_btn);
        next_btn=view.findViewById(R.id.next_btn);

        switch (categoryId){
            case 1:
                categoryItems = GetCategoryItem.getCategory1();
                break;
            case 2:
                categoryItems = GetCategoryItem.getCategory2();
                break;
            case 3:
                categoryItems = GetCategoryItem.getCategory3();
                break;
            case 4:
                categoryItems = GetCategoryItem.getCategory4();
                break;
            case 5:
                categoryItems = GetCategoryItem.getCategory5();
                break;
            case 6:
                categoryItems = GetCategoryItem.getCategory6();
                break;
        }

        poem_number.setText(poemPosition +1+"/10");
        categoryName.setText(categoryItems.get(poemPosition).getCategoryName());
        poemName.setText(categoryItems.get(poemPosition).getPoemName());
        writerName.setText(categoryItems.get(poemPosition).getWriterName());
        poem.setText(categoryItems.get(poemPosition).getPoem());

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null)
                        .remove(PoemListFragment.this).commit();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poemPosition<9){
                    poemPosition++;
                }
                if (poemPosition<=9){
                    poem_number.setText(poemPosition+1+"/10");
                    categoryName.setText(categoryItems.get(poemPosition).getCategoryName());
                    poemName.setText(categoryItems.get(poemPosition).getPoemName());
                    writerName.setText(categoryItems.get(poemPosition).getWriterName());
                    poem.setText(categoryItems.get(poemPosition).getPoem());
                }
            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poemPosition > 0){
                    poemPosition--;
                }
                if (poemPosition>=0){
                    poem_number.setText(poemPosition+1+"/10");
                    categoryName.setText(categoryItems.get(poemPosition).getCategoryName());
                    poemName.setText(categoryItems.get(poemPosition).getPoemName());
                    writerName.setText(categoryItems.get(poemPosition).getWriterName());
                    poem.setText(categoryItems.get(poemPosition).getPoem());
                }
            }
        });

        return view;
    }

}