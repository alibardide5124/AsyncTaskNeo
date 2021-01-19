package com.alibardide.asynctaskneo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.helloWorld)
        AsyncTaskNeo.executeAsyncTask<Boolean, Int>(
            onPreExecute = {},
            doInBackground = { publishProgress ->
                for (i in 1..5) {
                    TimeUnit.SECONDS.sleep(5)
                    publishProgress(i)
                }
                true
            },
            onProgressUpdate = {
                text.text = it.toString()
            },
            onPostExecute = {
                Toast.makeText(this, "Async finished", Toast.LENGTH_SHORT).show()
            }
        )
    }
}