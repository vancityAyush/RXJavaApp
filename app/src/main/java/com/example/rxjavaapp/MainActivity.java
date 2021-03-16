package com.example.rxjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.Date;

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

//        Observable.just("Ayush","Monica", "Jack Sparrow", "Robert Downey Jr.", "Tom Crusie").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                rvCustomAdapter.addStringToList(s);
//
//            }
//        });

        Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500),new Date());
        Entry entry2 = new Entry("PS5", BigDecimal.valueOf(4500),new Date());
        Entry entry3 = new Entry("X-Box ONE", BigDecimal.valueOf(1600),new Date());
        Entry entry4 = new Entry("Nintendo", BigDecimal.valueOf(1300),new Date());
        Observable.just(entry1,entry2,entry3,entry4).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {
                rvCustomAdapter.addEntry(entry);
            }
        });


    }
}