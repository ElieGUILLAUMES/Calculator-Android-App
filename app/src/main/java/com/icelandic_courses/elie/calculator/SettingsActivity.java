package com.icelandic_courses.elie.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class SettingsActivity extends Activity {

    private static boolean allowToVibrate;
    private CheckBox checkBoxVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        checkBoxVibration = (CheckBox) findViewById(R.id.vibrateCheckBox);

        // Get the message from the intent
        Intent intent = getIntent();
        boolean allowToVibrate = intent.getBooleanExtra(MainActivity.EXTRA_VIBRATION, false);

        if(allowToVibrate){
            checkBoxVibration.setChecked(allowToVibrate);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    /**
     * @param view
     */
    public void setAllowToVibrate(View view){
        CheckBox checkbox = (CheckBox) findViewById(R.id.vibrateCheckBox);
        if(checkbox.isChecked()){
            MainActivity.allowVibration();
        } else {
            MainActivity.disableVibration();
        }

    }

}