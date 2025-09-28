package com.unimib.ilovedevelopers.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.unimib.ilovedevelopers.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.preferenceJobFragment, R.id.statisticsJobFragment, R.id.searchJobFragment, R.id.favoriteJobFragment
        ).build();

        NavigationUI.setupWithNavController(bottomNav, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

}