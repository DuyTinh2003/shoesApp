package com.example.shoesapp.layout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.R;
import com.example.shoesapp.adapter.NewShoeAdapter;
import com.example.shoesapp.adapter.PopularShoeAdapter;
import com.example.shoesapp.model.Shoe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewPopularShoe;
    RecyclerView recyclerViewNewShoe;
    PopularShoeAdapter popularShoeAdapter;
    NewShoeAdapter newShoeAdapter;
    ArrayList<Shoe> listShoe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        recyclerViewPopularShoe = findViewById(R.id.recycle_shoe);
        recyclerViewNewShoe = findViewById(R.id.recyclerNewShoes);

        //set data and layout to recyclerViewShoe
        listShoe = new ArrayList();
        getList();
        popularShoeAdapter = new PopularShoeAdapter(this, listShoe);

        LinearLayoutManager layoutPopularShoe
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularShoe.setLayoutManager(layoutPopularShoe);
        recyclerViewPopularShoe.setAdapter(popularShoeAdapter);

        //set data and layout to recyclerNewViewShoe
        newShoeAdapter = new NewShoeAdapter(this, listShoe);

        LinearLayoutManager layoutNewShoe
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNewShoe.setLayoutManager(layoutNewShoe);
        recyclerViewNewShoe.setAdapter(newShoeAdapter);
    }

    private void getList() {
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
        listShoe.add(new Shoe("nike","https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/585e2cd2-4f2a-408c-a8ba-f89952cdf332/revolution-6-next-nature-road-running-shoes-NC0P7k.png",55.5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                // Perform action for menu item 1
                return true;
            case R.id.menu_item2:
                // Perform action for menu item 2
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}