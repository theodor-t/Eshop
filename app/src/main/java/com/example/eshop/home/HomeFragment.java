package com.example.eshop.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.category.CategoryAdapter;
import com.example.eshop.category.CategoryModel;
import com.example.eshop.product.HorizontalProductScrollModel;
import com.example.eshop.slider.SliderModel;
import com.example.eshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerView;
    private HomePageAdapter adapter;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;

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

        categoryModelList = new ArrayList<CategoryModel>();
        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        ////////////////// Horizontal Product Layout
//        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.phone_1,"POCO F1","SD 425 Processor","5000 MDL"));
//        ////////////////// Horizontal Product Layout

        ////////////////////////////////
        homePageRecyclerView = view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList = new ArrayList<>();
        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);

        firebaseFirestore.collection("CATEGORIES")
                .document("HOME")
                .collection("TOP_DEALS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                                if ((long) documentSnapshot.get("view_type") == 0) {

                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long) documentSnapshot.get("no_of_banners");
                                    for (long x = 1; x < no_of_banners + 1; x++) {
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_" + x).toString()
                                                , documentSnapshot.get("banner_" + x + "_background").toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(0, sliderModelList));
                                } else if ((long) documentSnapshot.get("view_type") == 1) {
                                    homePageModelList.add(new HomePageModel(1, documentSnapshot.get("strip_ad_banner").toString()
                                            , documentSnapshot.get("background").toString()));

                                } else if ((long) documentSnapshot.get("view_type") == 2) {

                                } else if ((long) documentSnapshot.get("view_type") == 3) {

                                }
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        ////////////////////////////////
        return view;
    }

}