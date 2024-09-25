package com.example.driverapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ImageView btnMenu;
    public CardView ScanQR, Report, Notification;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.main);

        navigationView = findViewById(R.id.navigation_view);

        btnMenu =findViewById(R.id.Menu);
        ScanQR = findViewById(R.id.Scan);
        Report = findViewById(R.id.Issue);
        Notification = findViewById(R.id.Notification);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                return false;
            }
        });



        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        ScanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ScanActivity.class));
            }
        });


        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ReportIssueActivity.class));
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.Scan) {
                    // Handle Register Student action
                    startActivity(new Intent(DashboardActivity.this,ScanActivity.class));
                    Toast.makeText(DashboardActivity.this, "Register Student clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.view_route) {
                    // Handle Generate QR Code action
                    startActivity(new Intent(DashboardActivity.this, ViewRouteActivity.class));
                    Toast.makeText(DashboardActivity.this, "Generate QR Code clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.Issue) {
                    startActivity(new Intent(DashboardActivity.this, ReportIssueActivity.class));
                    Toast.makeText(DashboardActivity.this, "Assign Students clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.notification) {
                    // Handle Manage Accounts action
                    startActivity(new Intent(DashboardActivity.this,NotificationActivity.class));
                    Toast.makeText(DashboardActivity.this, "Manage Accounts clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.profile) {
                    // Handle Profile action
                    Toast.makeText(DashboardActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.about_us) {
                    // Handle About Us action
                    Toast.makeText(DashboardActivity.this, "About Us clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else if (id == R.id.logout) {
                    // Handle Logout action
                    startActivity(new Intent(DashboardActivity.this,MainActivity.class));
                    Toast.makeText(DashboardActivity.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;

                } else {
                    return false;
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}