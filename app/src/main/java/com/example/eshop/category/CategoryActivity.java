package com.example.eshop.category;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eshop.home.HomePageAdapter;
import com.example.eshop.home.HomePageModel;
import com.example.eshop.product.HorizontalProductScrollModel;
import com.example.eshop.slider.SliderModel;
import com.example.eshop.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        ////////////////// Banner Slider
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.mipmap.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.banner1, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.green_email, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.app_round_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.green_email, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email, "#077AE4"));
        ////////////////// Banner Slider

        ////////////////// Horizontal Product Layout
        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
        ////////////////// Horizontal Product Layout

        ////////////////////////////////
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"#Trending",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_search_icon){
            //todo: search
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}