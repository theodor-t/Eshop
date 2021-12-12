package com.example.eshop.viewall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.example.eshop.R;
import com.example.eshop.product.GridProductViewLayoutAdapter;
import com.example.eshop.product.HorizontalProductScrollModel;
import com.example.eshop.wishlist.WishlistAdapter;
import com.example.eshop.wishlist.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;
    public static List<HorizontalProductScrollModel> horizontalProductScrollModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code", -1);

        if (layout_code == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 0, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 4, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 1, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 0, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 4, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 1, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.product_image, "Iphone X", 2, "4.9", 29, "MDL 32400", "MDL 38000", "Cash on delivery"));

            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if(layout_code == 1) {

            gridView.setVisibility(View.VISIBLE);

            GridProductViewLayoutAdapter gridProductViewLayoutAdapter = new GridProductViewLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductViewLayoutAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}