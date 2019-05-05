# JobSchedulerDemo
Practicing the JobScheduler for managing a JobService.

### Implemented while reading this blog. from - Using the JobScheduler API on Android Lollipop
https://code.tutsplus.com/tutorials/using-the-jobscheduler-api-on-android-lollipop--cms-23562


### Consider reading and wathing about Doze mode which is a new feature introduced in API level 23.
watch this:
- https://www.youtube.com/watch?v=N72ksDKrX6c
and read this:
- https://medium.com/mindorks/you-have-to-know-more-about-doze-mode-3d80f016f8ad

### Firebase Dispatcher
execute our job in JobScheduler for devices with API level 21+ and will switch our implementation to Alarm Manager for devices with lower API level than 21. That kinda makes it very cool feature.
