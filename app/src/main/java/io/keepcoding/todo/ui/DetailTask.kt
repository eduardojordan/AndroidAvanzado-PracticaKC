package io.keepcoding.todo.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.keepcoding.todo.R
import io.keepcoding.todo.data.model.Task


class DetailTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_task)
        var task: Task? = null


        task = intent.getParcelableExtra("task")
        if (task == null) {
            setResult(Activity.RESULT_OK)
            finish()
        }


    }
}
