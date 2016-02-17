package pl.neducatio.myapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import pl.neducatio.myapplication.R;

@EActivity(R.layout.activity_second)
public class SecondActivity extends AppCompatActivity {

    @ViewById(R.id.textViewIP)
    TextView textViewIP;

    @Extra("IP")
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void setText() {
        if(ip != null) {
            textViewIP.setText("Twoje IP:" + ip);
        }
    }
}
