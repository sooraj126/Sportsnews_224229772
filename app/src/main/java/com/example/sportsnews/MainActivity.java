package com.example.sportsnews;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btnHome, btnBookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btnHome);
        btnBookmarks = findViewById(R.id.btnBookmarks);

        // Load HomeFragment first when app opens
        loadFragment(new HomeFragment());

        btnHome.setOnClickListener(v -> loadFragment(new HomeFragment()));

        btnBookmarks.setOnClickListener(v -> loadFragment(new BookmarksFragment()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}