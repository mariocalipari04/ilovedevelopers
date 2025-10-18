package com.unimib.ilovedevelopers.ui.welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.unimib.ilovedevelopers.R;
import com.unimib.ilovedevelopers.ui.home.HomeActivity;
import com.unimib.ilovedevelopers.util.SharedPreferencesUtil;

import java.io.File;

public class LauncherActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        File prefsFile = new File(getApplicationContext().getFilesDir().getParent()
                + "/shared_prefs/com.unimib.ilovedevelopers.preferences.xml");

        if(prefsFile.exists()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_launcher);
        }
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

    }

}