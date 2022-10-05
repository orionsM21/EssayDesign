package com.example.essaydesign.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.example.essaydesign.R;

public class Dashboard extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Assign variable
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        //redirect activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public  void ClickDashboard(View view){
        //Recreate activity
        recreate();
    }

    public  void  ClickAboutUS(View view){
        //Redirect activity to about us
        MainActivity.redirectActivity(this,AboutUS.class);
    }
    public  void  ClickLogout(View view){
        //Close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}