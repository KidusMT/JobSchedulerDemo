package com.kmt.jobschedulerdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ToastWorker extends Worker {

    public ToastWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

    }

    @NonNull
    @Override
    public Result doWork() {

        WorkerUtils.toastText(MainActivity.getActivity());

        return Worker.Result.success();
    }
}
