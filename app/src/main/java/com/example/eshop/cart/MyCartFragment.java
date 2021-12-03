package com.example.eshop.cart;

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

public class MyCartFragment extends Fragment {

    public MyCartFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.product_image,"Iphone XR",2,"MDL 8999","MDL 13000",1,0,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.product_image,"Iphone XR",0,"MDL 8999","MDL 13000",1,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.product_image,"Iphone XR",2,"MDL 8999","MDL 13000",1,2,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items)","MDL 48000","Free","MDL 34000","5000"));

       CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
       cartItemsRecyclerView.setAdapter(cartAdapter);
       cartAdapter.notifyDataSetChanged();
        return view;
    }
}