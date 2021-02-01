package com.krishna.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CityName> cityList;
    CityName cityName;

    Button btnAdd;
    EditText edtName;
    AdapterCity adapterCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        edtName = findViewById(R.id.edtName);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new AddCityClickListener());
        cityList = new ArrayList<>();
        adapterCity = new AdapterCity(this, cityList);
        recyclerView.setAdapter(adapterCity);
    }

    class AddCityClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            cityName = new CityName();
            cityName.setName(edtName.getText().toString().trim());
            cityList.add(cityName);

            adapterCity.notifyDataSetChanged();

        }
    }
}