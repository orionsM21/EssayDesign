package com.example.essaydesign.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.essaydesign.R;

public class MainActivity extends AppCompatActivity {
    //Initialize Variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public  void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer Layout
        drawerLayout.openDrawer((GravityCompat.START));
    }
    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public  void ClickDashboard(View view){
        //Redirect activity to Dashboard
        redirectActivity(this,Dashboard.class);
    }

    public void ClickAboutUS(View view){
        //Redirect activity to about us
        redirectActivity(this,AboutUS.class);
    }

    public void ClickLogout(View view){
        //Close app
        logout(this);
    }

    public static void logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout ?");
        //Positive yes button
        builder.setPositiveButton("yes", (dialog, which) -> {
            //Finish activity
            activity.finishAffinity();
            //Exit app
            System.exit(0);
        });
        //Negative no button
        builder.setNegativeButton("No", (dialog, which) -> {
            //Dismiss Dialog
            dialog.dismiss();
        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent =new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}