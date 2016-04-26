package com.udacity.gradle.builditbigger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proggmail.jud.jokeandroid.JokeActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.ResultJokeListener;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  implements ResultJokeListener {



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        return root;
    }



    public void tellJoke() {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.bTJoke)
    public void onClick() {
            tellJoke();

    }

    @Override
    public void getJokeResult(String result) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_TEXT, result);
        getActivity().startActivity(intent);
    }
}
