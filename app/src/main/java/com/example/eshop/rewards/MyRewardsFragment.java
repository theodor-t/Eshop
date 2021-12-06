package com.example.eshop.rewards;

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


public class MyRewardsFragment extends Fragment {

    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardsRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));
        rewardModelList.add(new RewardModel("Cashback","till 2nd,June 2022","GET 20% CASHBACK on any product above MDL 200 and below MDL 3000."));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList);
        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();
        return view;
    }
}