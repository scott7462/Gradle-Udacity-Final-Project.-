package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.ResultJokeListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ServiceTest extends AndroidTestCase implements ResultJokeListener {
    CountDownLatch signal;
    String joke = "";

    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException {
        new EndpointsAsyncTask(this).execute();
        signal.await(30, TimeUnit.SECONDS);
        assertTrue("Service completed, the result are here!", joke != null);
    }

    @Override
    public void getJokeResult(String result) {
        joke = result;
        signal.countDown();

    }
}