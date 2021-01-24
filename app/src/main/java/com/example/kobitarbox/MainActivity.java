package com.example.kobitarbox;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.kobitarbox.Fragment.CategoryFragment;
import com.example.kobitarbox.Model.CategoryItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    LinearLayout cat1,cat2,cat3,cat4,cat5,cat6;
     private List<CategoryItem> categoryItemList;
     int categoryId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        cat1=findViewById(R.id.cat1);
        cat2=findViewById(R.id.cat2);
        cat3=findViewById(R.id.cat3);
        cat4=findViewById(R.id.cat4);
        cat5=findViewById(R.id.cat5);
        cat6=findViewById(R.id.cat6);

        cat1.setOnClickListener(this);
        cat2.setOnClickListener(this);
        cat3.setOnClickListener(this);
        cat4.setOnClickListener(this);
        cat5.setOnClickListener(this);
        cat6.setOnClickListener(this);
    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();      //recreate Activity
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cat1:
                categoryItemList = GetCategoryItem.getCategory1();
                categoryId = 1;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                        .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
            case R.id.cat2:
                categoryItemList = GetCategoryItem.getCategory2();
                categoryId = 2;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                        .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
            case R.id.cat3:
                categoryItemList = GetCategoryItem.getCategory3();
                categoryId = 3;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                        .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
            case R.id.cat4:
                categoryItemList = GetCategoryItem.getCategory4();
                categoryId = 4;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                    .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
            case R.id.cat5:
                categoryItemList = GetCategoryItem.getCategory5();
                categoryId = 5;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                        .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
            case R.id.cat6:
                categoryItemList = GetCategoryItem.getCategory6();
                categoryId = 6;
                getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.top_to_down, R.anim.down_to_top)
                        .replace(R.id.category_fragment, new CategoryFragment(categoryItemList, categoryId)).commit();
                break;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}