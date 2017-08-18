package com.example.alejandroespinoza.databindingapp;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alejandroespinoza.databindingapp.databinding.ActivityMainBinding;
import com.example.alejandroespinoza.databindingapp.models.ModelMain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ModelMain model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        model = new ModelMain("Training",  "What an awesome training!");

        model.setDate(new Date());

        binding.setModel(model);

        new AsyncTask<Void, Integer, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    for (int i = 0 ; i < 10 ; i++) {
                        Thread.sleep(3000);
                        publishProgress(i);
                    }
                } catch (Exception ex) {

                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                model.setName(model.getName() + " " + values[0]);
            }
        }.execute();
    }

    @BindingAdapter(value = {"android:date",  "android:thing"}, requireAll=true)
    public static void setDate(TextView view, Date date, String thing) {
        String dateFormat = "yyyy/MM/dd hh";

        try {
            view.setText(thing + " --- " + new SimpleDateFormat(dateFormat).format(date));
        } catch (Exception ex) {
        }
    }
}