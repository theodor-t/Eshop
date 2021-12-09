package com.example.eshop.wishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eshop.R;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistFragment extends Fragment {

    public MyWishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",2,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",0,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",2,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",4,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",1,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.product_image,"Iphone X",2,"4.9",29,"MDL 32400","MDL 38000","Cash on delivery"));


        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList,true);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;
    }
}