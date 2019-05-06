package com.kmt.jobschedulerdemo;

import android.app.Activity;
import android.app.job.JobInfo;
//import android.app.job.JobScheduler;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

import static com.kmt.jobschedulerdemo.Constants.IMAGE_MANIPULATION_WORK_NAME;

public class MainActivity extends AppCompatActivity {

//    public static final String TAG = "my_firebase_job_dispatcher";
//    JobScheduler mJobScheduler;
//    FirebaseJobDispatcher jobDispatcher;

    private WorkManager mWorkManager;

    private static final String TAG = MainActivity.class.getSimpleName();

    public static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting an instance of the system service JOB_SCHEDULER_SERVICE
//        mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);


        // To create our scheduled task, we can use the JobInfo.Builder
        // The parameters that are passed into the builder are :
        // (1) identifier of the job that we will run
        // (2) component name of the service that we will use with the JobScheduler API
//        JobInfo.Builder builder = new JobInfo.Builder(1,
//                new ComponentName(getPackageName(),
//                        JobSchedulerService.class.getName()));

        // allows us to set many different options for controlling when our job will execute.
        // builder.setPeriodic( 3000 ); --> like this
        // builder.setMinimumLatency(long minLatencyMillis) --> This makes our job not launch until the stated number of milliseconds have passed
        // builder.setOverrideDeadline(long maxExecutionDelayMillis) --> This will set a deadline for our job
        // builder.setPersisted(boolean isPersisted) --> This function tells the system whether our task should continue to exist after the device has been rebooted.
        // builder.setRequiredNetworkType(int networkType) --> This function will tell our job that it can only start if the device is on a specific kind of network.
        // builder.setRequiresCharging(boolean requiresCharging) --> Using this function will tell our application that the job should not start until the device has started charging.
        // builder.setRequiresDeviceIdle(boolean requiresDeviceIdle) --> This tells our job to not start unless the user is not using their device and they have not used it for some time.

//        if (mJobScheduler.schedule(builder.build()) <= 0) {
            //If something goes wrong
//        }


//        mJobScheduler.cancel(1);// If our application requires that we stop a specific job
//        mJobScheduler.cancelAll();// cancels all jobs

//        jobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));

        mWorkManager = WorkManager.getInstance();

        mActivity = this;

    }


    public void startJob(View view) {

        WorkerUtils.makeStatusNotification( "started the job", this);
        WorkContinuation continuation = mWorkManager
                .beginWith(OneTimeWorkRequest.from(ToastWorker.class));

        continuation.enqueue();

//        Job job = jobDispatcher.newJobBuilder()
//                .setService(MyJobService.class)
//                .setLifetime(Lifetime.FOREVER)
//                .setRecurring(true)
//                .setTag(TAG)
//                .setTrigger(Trigger.executionWindow(10, 10))
//                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
//                .setReplaceCurrent(false)
//                .setConstraints(Constraint.ON_ANY_NETWORK)
//                .build();
//
//        jobDispatcher.mustSchedule(job);
//        Toast.makeText(this, "Job Scheduled", Toast.LENGTH_SHORT).show();
    }

    public void stopJob(View view) {
//        jobDispatcher.cancel(TAG);//for a specific tag
//        Toast.makeText(this, "Job Canceled", Toast.LENGTH_SHORT).show();


        mWorkManager.cancelUniqueWork(IMAGE_MANIPULATION_WORK_NAME);
    }

    public static Activity getActivity(){
        return mActivity;
    }
}
