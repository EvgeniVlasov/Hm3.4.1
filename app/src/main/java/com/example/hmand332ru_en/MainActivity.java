package com.example.hmand332ru_en;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button buttonOk;
    TextView txtView;
    Spinner spinnerTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.onActivityCreateSetTheme(this);
        spinner = findViewById(R.id.spinner);
        buttonOk = findViewById(R.id.buttonOk);
        txtView = findViewById(R.id.textView);
        spinnerTheme = findViewById(R.id.spinnerTheme);
        initSpinner();
        initThemeSpinner();
        initBtnOk(this,buttonOk);
        initView();

    }

    private void initView() {

    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.spinnerLang, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterLang);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initThemeSpinner() {
        ArrayAdapter<CharSequence> adapterTheme = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        adapterTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheme.setAdapter(adapterTheme);

        spinnerTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    private void initBtnOk(final Activity activity, Button button) {

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale;
                if (((int) spinner.getSelectedItemPosition()) == 0)
                    locale = new Locale("ru");
                else locale = new Locale("en");

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                int pos = spinnerTheme.getSelectedItemPosition();
                switch (pos) {
                    case 1:
                        Utils.changeToTheme(activity, Utils.THEME_GREEN);
                        break;
                    case 2:
                        Utils.changeToTheme(activity, Utils.THEME_BLUE);
                        break;
                    default:
                        Utils.changeToTheme(activity, Utils.THEME_DEFAULT);
                        break;
                }

            }
        };

        buttonOk.setOnClickListener(onClickListener);
    }




}