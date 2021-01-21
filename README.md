AsyncTaskNeo
============

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/17f88018afbc490b8b8f8be31778ab5b)](https://app.codacy.com/gh/alibardide5124/AsyncTaskNeo?utm_source=github.com&utm_medium=referral&utm_content=alibardide5124/AsyncTaskNeo&utm_campaign=Badge_Grade)
[![Version](https://jitpack.io/v/alibardide5124/AsyncTaskNeo.svg)](https://jitpack.io/#alibardide5124/AsyncTaskNeo)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)

Android AsyncTask using kotlin Coroutines
<br/>
After AsyncTask deprecated on API 29, I was looking for something to replace it with. And i found this soloution using `Kotlin Coroutins` on StackOverflow. So i decided to publish it as a library. Maybe someone needs this.

Implement
---------
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Then Add the dependency
```groovy
dependencies {
    implementation 'com.github.alibardide5124:AsyncTaskNeo:LEAST_VERSION'
}
```
Usage
-----
You can use this library by typing `AsyncTaskNeo.executeAsyncTask<Output, Progress>()`
This function needs three input, and all of them are functions... `onPreExecute`, `doInBackground`, `onProgressUpdate` and `onPostExecute`.Just like the original AsyncTask.
Here is an example of using:
```kotlin
AsyncTaskNeo.executeAsyncTask<Boolean, Int> (
    onPreExecute = {
        // Do something before heavy task
    },
    doInBackground = { publishProgress ->
        // Do some heavy works. Dont update ui here. Call publish progress for updating ui.
        true // Then return a Boolean (for example)
    },
    onProgressUpdate = {
        // Update ui here
        textview.text = it.toString()
    },
    onPostExecute = {
        // Do something on the end
    }
)
```

How was it? I hope you use it if you needs this.

License
-------
AsyncTaskNeo created by [Ali Bardide](https://github.com/alibardide5124) and it's licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
