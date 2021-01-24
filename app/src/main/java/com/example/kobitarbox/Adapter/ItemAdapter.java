package com.example.kobitarbox.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kobitarbox.Fragment.CategoryFragment;
import com.example.kobitarbox.Fragment.PoemListFragment;
import com.example.kobitarbox.Model.CategoryItem;
import com.example.kobitarbox.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Context context;
    private List<CategoryItem> categoryItemList;
    private LayoutInflater inflater;
    int categoryId;

    public ItemAdapter(Context context, List<CategoryItem> categoryItemList, int categoryId) {
        this.context = context;
        this.categoryItemList = categoryItemList;
        this.categoryId=categoryId;
    }

    @Override
    public int getCount() {
        return categoryItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_item_list, parent, false);
        }
        LinearLayout list1 = convertView.findViewById(R.id.list1);
        list1.setBackgroundResource(categoryItemList.get(position).getImage());
        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                PoemListFragment poemFragment = new PoemListFragment(position, categoryItemList, categoryId);
                activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top).replace(R.id.poem_fragment, poemFragment).addToBackStack(null).commit();
            }
        });
        return convertView;
    }
}
