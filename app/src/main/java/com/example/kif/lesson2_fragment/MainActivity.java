package com.example.kif.lesson2_fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox cbR, cbG, cbB;
    TextView text;
    RFragment rFragment;
    GFragment gFragment;
    BFragment bFragment;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        cbR = (CheckBox) findViewById(R.id.checkBoxR);
        cbG = (CheckBox) findViewById(R.id.checkBoxG);
        cbB = (CheckBox) findViewById(R.id.checkBoxB);
        // text = (TextView) findViewById(R.id.text);
        rFragment = new RFragment();
        gFragment = new GFragment();
        bFragment = new BFragment();

        cbR.setOnCheckedChangeListener(this);
        cbG.setOnCheckedChangeListener(this);
        cbB.setOnCheckedChangeListener(this);


    }
/*
    public void Checkone(View v){
        ft =  getSupportFragmentManager().beginTransaction();


        if (cbR.isChecked()) {

            ft.replace(R.id.baselayout, rFragment);


        }
      *//*  else if (!cbR.isChecked()) {

            ft.remove(rFragment);
            ft.addToBackStack(null);

        }*//*
        else if (cbG.isChecked()) {

            ft.replace(R.id.baselayout, gFragment);

        }

        else if (cbB.isChecked()) {


            ft.replace(R.id.baselayout, bFragment);
            }
        ft.addToBackStack(null);

        ft.commit();



    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ft =  getSupportFragmentManager().beginTransaction();
        if(isChecked){
            switch(buttonView.getId()){
                case R.id.checkBoxR:
                    ft.add(R.id.baselayout, rFragment);
                    break;
                case R.id.checkBoxG:
                    ft.add(R.id.baselayout, gFragment);
                    break;
                case R.id.checkBoxB:
                    ft.add(R.id.baselayout, bFragment);
                    break;

            }
        }
        else{
            switch(buttonView.getId()){
                case R.id.checkBoxR:

                    ft.remove(rFragment);
                    break;
                case R.id.checkBoxG:


                    ft.remove(gFragment);
                    break;
                case R.id.checkBoxB:


                    ft.remove(bFragment);
                    break;

            }
        }
        ft.addToBackStack(null);

        ft.commit();

    }
}
