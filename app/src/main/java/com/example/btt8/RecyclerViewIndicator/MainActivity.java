package com.example.btt8.RecyclerViewIndicator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btt8.R;
import com.example.btt8.RecyclerViewIndicator.Adapter.IconAdapter;
import com.example.btt8.RecyclerViewIndicator.Decoration.LinePagerIndicatorDecoration;
import com.example.btt8.RecyclerViewIndicator.Model.IconModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcIcon;
    private IconAdapter iconAdapter;
    private List<IconModel> arrayList1;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rcIcon = findViewById(R.id.rcIcon);
        searchView = findViewById(R.id.searchView);

        if (searchView != null) {
            searchView.clearFocus();
        } else {
            Log.e("MainActivity", "SearchView is null");
        }

        arrayList1 = new ArrayList<>();
        int[] icons = {
                R.drawable.ic_cal, R.drawable.ic_baseline_call_24, R.drawable.ic_baseline_chat_24,
                R.drawable.ic_baseline_camera_alt_24, R.drawable.ic_baseline_person_24, R.drawable.img_plus, R.drawable.ic_launcher_foreground
        };

        for (int i = 0; i < icons.length; i++) {
            arrayList1.add(new IconModel(icons[i], "Item " + (i + 1)));
        }


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);

        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> filteredList = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(iconModel);
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(filteredList);
        }
    }
}