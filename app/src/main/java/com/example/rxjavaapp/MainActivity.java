package com.example.rxjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Observable.just("How are you").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                txtHi.setText(s);
            }
        });
        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);

        Observable.just("Ayush","Monica", "Jack Sparrow", "Robert Downey Jr.", "Tom Crusie").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                rvCustomAdapter.addStringToList(s);

            }
        });


    }
}