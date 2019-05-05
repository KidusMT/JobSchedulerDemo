package com.kmt.jobschedulerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    JobScheduler mJobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting an instance of the system service JOB_SCHEDULER_SERVICE
        mJobScheduler = (JobScheduler) getSystemService( Context.JOB_SCHEDULER_SERVICE );


        // To create your scheduled task, we can use the JobInfo.Builder
        // The parameters that are passed into the builder are :
        // (1) identifier of the job that we will run
        // (2) component name of the service that we will use with the JobScheduler API
        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName( getPackageName(),
                        JobSchedulerService.class.getName() ) );

        // allows us to set many different options for controlling when your job will execute.
        // builder.setPeriodic( 3000 ); --> like this
        // builder.setMinimumLatency(long minLatencyMillis) --> This makes your job not launch until the stated number of milliseconds have passed
        // builder.setOverrideDeadline(long maxExecutionDelayMillis) --> This will set a deadline for your job
        // builder.setPersisted(boolean isPersisted) --> This function tells the system whether your task should continue to exist after the device has been rebooted.
        // builder.setRequiredNetworkType(int networkType) --> This function will tell your job that it can only start if the device is on a specific kind of network.
        // builder.setRequiresCharging(boolean requiresCharging) --> Using this function will tell your application that the job should not start until the device has started charging.
        // builder.setRequiresDeviceIdle(boolean requiresDeviceIdle) --> This tells your job to not start unless the user is not using their device and they have not used it for some time.
    }
}
