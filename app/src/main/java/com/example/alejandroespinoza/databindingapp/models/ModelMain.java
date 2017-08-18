package com.example.alejandroespinoza.databindingapp.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.alejandroespinoza.databindingapp.BR;

import java.util.Date;

/**
 * Created by AlejandroEspinoza on 8/4/17.
 */

public class ModelMain extends BaseObservable {
    private String AwesomeName;
    private String description;
    private Date date;

    public ModelMain(String name, String description) {
        this.AwesomeName = name;
        this.description = description;
    }

    @Bindable
    public String getName() {
        return AwesomeName;
    }

    public void setName(String name) {
        if (AwesomeName == null || !AwesomeName.equals(name)) {
            this.AwesomeName = name;
            notifyPropertyChanged(BR.name);
        }
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
