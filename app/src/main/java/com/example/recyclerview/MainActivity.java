package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private int num = 1;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private LinkedList<String> mWordList = new LinkedList<>();
    private FloatingActionButton mAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddButton = findViewById(R.id.add_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.getAdapter().notifyItemInserted(mWordList.size());
        mRecyclerView.smoothScrollToPosition(mWordList.size());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWordList.add("Word: " + num);
                num++;
                mAdapter = new WordListAdapter(MainActivity.this, mWordList);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.getAdapter().notifyItemInserted(mWordList.size());
                mRecyclerView.smoothScrollToPosition(mWordList.size());

            }
        });
    }
}