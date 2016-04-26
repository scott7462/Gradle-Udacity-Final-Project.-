package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.rest.ResultJokeListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by scott7462 on 4/25/16.
 */
public class ServiceTest extends AndroidTestCase implements ResultJokeListener {
    CountDownLatch signal;
    String joke ="";

    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException
    {
        new EndpointsAsyncTask(this).execute();
        signal.await(30, TimeUnit.SECONDS);
        assertTrue("Service completed, the result are here!", joke !=null);
    }

    @Override
    public void getJokeResult(String result) {
        joke = result;
        signal.countDown();

    }
}