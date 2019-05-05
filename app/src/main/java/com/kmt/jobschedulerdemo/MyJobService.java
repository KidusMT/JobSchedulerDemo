package com.kmt.jobschedulerdemo;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class MyJobService extends JobService {


    MyBackgroundTask myBackgroundTask;

    @SuppressLint("StaticFieldLeak")
    @Override
    public boolean onStartJob(@NonNull final JobParameters job) {

        myBackgroundTask = new MyBackgroundTask() {
            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                jobFinished(job, false);
            }
        };
        return true;
    }

    @Override
    public boolean onStopJob(@NonNull JobParameters job) {
        return true;
    }

    public static class MyBackgroundTask extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            return "Background Task being executed";
        }
    }
}
