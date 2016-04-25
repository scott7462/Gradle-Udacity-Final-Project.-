package com.proggmail.jud.jokeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView tVJoke;

    public static String JOKE_TEXT = JokeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        tVJoke = (TextView) findViewById(R.id.tVJoke);
        if (getIntent() != null && getIntent().getExtras().containsKey(JOKE_TEXT)) {
            tellJoke(getIntent().getExtras().getString(JOKE_TEXT));
        }
    }

    public void tellJoke(String text) {
        assert tVJoke != null;
        tVJoke.setText(text);
    }
}
