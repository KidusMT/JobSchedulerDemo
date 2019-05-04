package com.kmt.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;

public class JobSchedulerService extends JobService {

    private Handler mJobHandler;

    public JobSchedulerService(){

    }

    // passing the Handler from the activity it being called
    // since the jobScheduler should run on a different thread than the main
    // the Handler required to run the JobService is passed through the constructor
    public JobSchedulerService(Handler mJobHandler) {
        this.mJobHandler = mJobHandler;
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        mJobHandler.sendMessage( Message.obtain( mJobHandler, 1, params ) );
        return true;// because, the handler could take longer to finish than
        // the onStartJob(JobParameters params)
        // NOTE: the number 1 is identifier that we're going to use for referencing the job.
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        mJobHandler.removeMessages( 1 );
        return false;
    }
}
