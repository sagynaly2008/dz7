package com.example.androiddz7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initNavController();
    }

    private void initNavController() {
        NavController navController = Navigation.findNavController(this,R.id.nav_host);
        NavigationUI.setupWithNavController(bottomNavigation,navController);
    }
}
