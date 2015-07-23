package com.example.abraham.fortun0;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.PopupMenu;




public class conf extends ActionBarActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_conf);

        getInfo();
    }

    public void setsize(int textsize){
        SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("textsize", textsize);
        editor.commit();
    }

    public void setcolour(String textcolour){
        SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("textcolour", textcolour);
        editor.commit();
    }
    public void setbgcolour(String bgcolour){
        SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("bgcolour", bgcolour);
        editor.commit();
    }


    public void showtextsizes(View v){

        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
           public boolean onMenuItemClick(MenuItem item) {

               switch (item.getItemId()) {

                 case R.id.size18_id:
                    setsize(18);
                     break;
                case R.id.size20_id:
                    setsize(20);
                    break;
                case R.id.size22_id:
                    setsize(22);
                    break;
                case R.id.size24_id:
                    setsize(24);
                    break;
                case R.id.size26_id:
                    setsize(26);
                    break;
                case R.id.size28_id:
                    setsize(28);
                    break;
                case R.id.size30_id:
                    setsize(30);
                    break;
                case R.id.size32_id:
                    setsize(32);
                    break;
                default:
                    setsize(18);
           }
           return true;
         }
       });

        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.textsizes, popup.getMenu());
        popup.show();
    }


    public void showtextcolor(View v){

        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                                            @Override
                                             public boolean onMenuItemClick(MenuItem item){

                                                switch(item.getItemId()){
                                                    case R.id.tdef_id:
                                                        setcolour("#ff757575");
                                                        break;
                                                     case R.id.tblack_id:
                                                         setcolour("#000000");
                                                         break;
                                                     case R.id.twhite_id:
                                                         setcolour("#FFFFFF");
                                                         break;
                                                     case R.id.tred_id:
                                                         setcolour("#FF0000");
                                                         break;
                                                     case R.id.tgreen_id:
                                                         setcolour("#00FF00");
                                                         break;
                                                     case R.id.tblue_id:
                                                         setcolour("#0000FF");
                                                         break;
                                                     case R.id.tgrey_id:
                                                         setcolour("#d3d3d3");
                                                         break;
                                                     default:
                                                         setcolour("#00FF00");


                                                 }
return true;
                                             }


                                         });
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.textcolours, popup.getMenu());
        popup.show();
    }

    public void showbgcolor(View v){

        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){

                switch(item.getItemId()){
                    case R.id.tdefBG_id:
                        setbgcolour("#ff303030");
                        break;
                    case R.id.tblack_id:
                        setbgcolour("#000000");
                        break;
                    case R.id.twhite_id:
                        setbgcolour("#FFFFFF");
                        break;
                    case R.id.tred_id:
                        setbgcolour("#FF0000");
                        break;
                    case R.id.tgreen_id:
                        setbgcolour("#00FF00");
                        break;
                    case R.id.tblue_id:
                        setbgcolour("#0000FF");
                        break;
                    case R.id.tgrey_id:
                        setbgcolour("#d3d3d3");
                        break;
                    default:
                        setbgcolour("#00FF00");


                }
                return true;
            }


        });
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.textbgcolours, popup.getMenu());
        popup.show();
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

    public void saveInfo(View v){
        CheckBox offensive =(CheckBox)findViewById(R.id.CKOffensive);
        CheckBox normal = (CheckBox)findViewById(R.id.CKnormal);
        CheckBox h2g2 =(CheckBox)findViewById(R.id.CKh2g2);
        CheckBox discworld = (CheckBox)findViewById(R.id.CKdiscworld);
        SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("offensive",offensive.isChecked());
        editor.putBoolean("normal",normal.isChecked());
        editor.putBoolean("h2g2",h2g2.isChecked());
        editor.putBoolean("discworld",discworld.isChecked());
        editor.commit();
    }

    public void getInfo(){
       CheckBox offensive =(CheckBox)findViewById(R.id.CKOffensive);
       CheckBox   normal = (CheckBox)findViewById(R.id.CKnormal);
        CheckBox h2g2 =(CheckBox)findViewById(R.id.CKh2g2);
        CheckBox   discworld = (CheckBox)findViewById(R.id.CKdiscworld);
        SharedPreferences sharedPref = getSharedPreferences("fortset", Context.MODE_PRIVATE);
        Boolean Bnormal = sharedPref.getBoolean("normal", false);
        Boolean Boffensive = sharedPref.getBoolean("offensive", true);
        Boolean Bh2g2 = sharedPref.getBoolean("h2g2", false);
        Boolean Bdiscworld = sharedPref.getBoolean("discworld", false);
        offensive.setChecked(Boffensive);
        normal.setChecked(Bnormal);
        h2g2.setChecked(Bh2g2);
        discworld.setChecked(Bdiscworld);
    }
}
