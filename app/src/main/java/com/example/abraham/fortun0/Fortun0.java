package com.example.abraham.fortun0;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import 	android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;



public class Fortun0 extends ActionBarActivity {
    private int index = 1;
    Boolean Bnormal;
    Boolean Boffensive;
    Boolean Bh2g2;
    Boolean Bdiscworld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fortun0);
        setoptions();
    }

    public void splitcookies(List<String> filename, View v) {

        getSupportActionBar().hide();
        StringBuilder splitter = new StringBuilder();
        String str;
        for(int i =0; i < filename.size(); i++) {
            InputStream fortune = null;
            try {

                fortune = getAssets().open(filename.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader in = null;
            try {
                assert fortune != null;
                in = new BufferedReader(new InputStreamReader(fortune, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                assert in != null;
                while ((str = in.readLine()) != null) {
                    splitter.append(str);
                    splitter.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        getRandFort(splitter, v);
    }

    public void getRandFort(StringBuilder splitter, View v) {

        Button Prev = (Button) findViewById(R.id.prev);
        Button Next = (Button) findViewById(R.id.next);
        String[] say = splitter.toString().trim().split("%");
        if (v.equals(Prev)) {
            if (index == 0) {
                index = 1;
            }
            ((TextView) findViewById(R.id.ohfortunate)).setText(say[index--]);
        } else if (v.equals(Next)) {
            if (index == say.length) {
                index = 0;
            }
            ((TextView) findViewById(R.id.ohfortunate)).setText(say[index++]);
        } else {
            Random r = new Random();
            int rand = r.nextInt(say.length);
            ((TextView) findViewById(R.id.ohfortunate)).setText(say[rand]);
            index = rand;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fortun0, menu);
        return true;
    }

    public void GoGo(View v) {
        List<String> fortunes = new ArrayList<String>();
        if(Boffensive) {
            ((TextView)findViewById (R.id.Sfortune)).setText ("@localhost# fortune -o");
            fortunes.add("offensive.txt");
        }
        if(Bnormal) {
            ((TextView)findViewById (R.id.Sfortune)).setText ("@localhost# fortune");
            fortunes.add("safe.txt");
        }

       if(Bdiscworld){
           ((TextView)findViewById (R.id.Sfortune)).setText ("@localhost# fortune");
           fortunes.add("discworld.txt");
       }
        if(Bh2g2){
            ((TextView)findViewById (R.id.Sfortune)).setText ("@localhost# fortune");
            fortunes.add("hitchhiker.txt");
        }
        if(!Boffensive && !Bnormal && !Bh2g2 && !Bdiscworld){
            ((TextView)findViewById (R.id.Sfortune)).setText ("@localhost# fortune");
            fortunes.add("safe.txt");
        }

splitcookies(fortunes, v);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mconf) {
            Intent intent = new Intent(this, conf.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goConf(View v){
        Intent intent = new Intent(this, conf.class);
        startActivity(intent);
    }

public void setoptions(){
    SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
    Bnormal = sharedPref.getBoolean("normal", false);
    Boffensive = sharedPref.getBoolean("offensive", false);
    Bh2g2 = sharedPref.getBoolean("h2g2", false);
    Bdiscworld = sharedPref.getBoolean("discworld", false);
    int textsize = sharedPref.getInt("textsize",18);
    String textcolour = sharedPref.getString("textcolour", "#00FF00");
    String bgcolour = sharedPref.getString("bgcolour", "#ff303030");
    ((TextView)findViewById (R.id.ohfortunate)).setTextSize(TypedValue.COMPLEX_UNIT_SP,textsize);
    ((TextView)findViewById (R.id.ohfortunate)).setTextColor(Color.parseColor(textcolour));
    ((TextView)findViewById (R.id.ohfortunate)).setBackgroundColor(Color.parseColor(bgcolour));

}
    @Override
    protected void onRestart() {
        super.onRestart();
setoptions();

    }
}