package com.udacity.gradle.builditbigger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.proggmail.jud.jokeandroid.JokeActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.ResultJokeListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class MainActivityFragment extends Fragment implements ResultJokeListener {


    @Bind(R.id.pBMain)
    RelativeLayout pBMain;

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
        pBMain.setVisibility(View.VISIBLE);
        tellJoke();

    }

    @Override
    public void getJokeResult(String result) {
        pBMain.setVisibility(View.GONE);
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_TEXT, result);
        getActivity().startActivity(intent);
    }
}
