package com.example.eshop.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.eshop.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrdersRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        myOrdersRecyclerView = view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.product_image,2,"Iphone 13 PRO MAX","Delivered on Jan 21th 2022"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.forgot_password_image,1,"Iphone 12 PRO MAX","Delivered on Jan 21th 2022"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.product_image,0,"Iphone X PRO MAX","Delivered on Jan 21th 2022"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.happy_shopping_image,4,"Iphone 11 PRO MAX","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.product_image,3,"Iphone 13 PRO MAX","Delivered on Jan 21th 2022"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

        return view;
    }
}