package com.example.eshop.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.category.CategoryAdapter;
import com.example.eshop.category.CategoryModel;
import com.example.eshop.product.HorizontalProductScrollModel;
import com.example.eshop.slider.SliderModel;
import com.example.eshop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Electronics"));
        categoryModelList.add(new CategoryModel("link", "Appliances"));
        categoryModelList.add(new CategoryModel("link", "Furniture"));
        categoryModelList.add(new CategoryModel("link", "Fashion"));
        categoryModelList.add(new CategoryModel("link", "Toys"));
        categoryModelList.add(new CategoryModel("link", "Sports"));
        categoryModelList.add(new CategoryModel("link", "Wall Arts"));
        categoryModelList.add(new CategoryModel("link", "Books"));
        categoryModelList.add(new CategoryModel("link", "Shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

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
        testing = view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"#Trending",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////////////////////////
        return view;
    }

}