# JobSchedulerDemo
Practicing the JobScheduler for managing a JobService.

### Implemented while reading this blog. from - Using the JobScheduler API on Android Lollipop
https://code.tutsplus.com/tutorials/using-the-jobscheduler-api-on-android-lollipop--cms-23562

### Mentioned Topics
- JobScheduler
- Alarm Manager
- Firebase Dispatcher
- Work Manager
- Doze Mode

### Consider reading and wathing about Doze mode which is a new feature introduced in API level 23.
watch this:
- https://www.youtube.com/watch?v=N72ksDKrX6c
and read this:
- https://medium.com/mindorks/you-have-to-know-more-about-doze-mode-3d80f016f8ad

### Firebase Dispatcher
execute our job in JobScheduler for devices with API level 21+ and will switch our implementation to Alarm Manager for devices with lower API level than 21. That kinda makes it very cool feature.

- https://medium.com/wiselteach/firebase-jobdispatcher-androidmonk-3e6d729ed9ce

### Android Jetpack: Introducing WorkManager
The Android WorkManager library makes it easy to schedule deferrable tasks that are expected to run even if the app exits or the device restarts. Need to sync photos with a server, or do a daily cache clean-up? Then WorkManager is the library for you! Because WorkManager is compatible with API 14+ and follows system health best practices, it is the recommended approach for handling most background execution tasks on Android.

WorkManager supports:
-One-off and periodic tasks
-Constraints, such as network availability
-Chaining tasks, parallel or sequentially
-Observable task state for display in UI
-Customized threading strategy

Video resource about WorkManager
https://www.youtube.com/watch?v=pe_yqM16hPQ
