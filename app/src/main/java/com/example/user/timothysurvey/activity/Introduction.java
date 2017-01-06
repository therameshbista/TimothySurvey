package com.example.user.timothysurvey.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.timothysurvey.R;
import com.example.user.timothysurvey.activity.adapter.NothingSelectedSpinnerAdapter;

public class Introduction extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    TextView instructions,cont;
    ImageView back;
    Spinner education_level,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        back= (ImageView) findViewById(R.id.back);
        cont= (TextView) findViewById(R.id.cont);

        back.setOnClickListener(this);
        cont.setOnClickListener(this);

        instructions= (TextView) findViewById(R.id.instructions);
        instructions.setText(Html.fromHtml("<font color='#494e51'><b>Instructions:</b></font><small>Therameshbista Therameshbista Therameshbista Therameshbista Therameshbista Therameshbista Therameshbista</small>"));


        education_level = (Spinner) findViewById(R.id.edu_level);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.array_education_level, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        education_level.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter1,
                        R.layout.spinner_education_level,
                        this));

        country = (Spinner) findViewById(R.id.country);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.array_country, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        country.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter2,
                        R.layout.spinner_country,
                        this));
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
            case R.id.cont:
                startActivity(new Intent(Introduction.this,Questions.class));
        }
    }
}
