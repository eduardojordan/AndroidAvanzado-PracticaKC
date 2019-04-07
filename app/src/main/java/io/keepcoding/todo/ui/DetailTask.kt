package io.keepcoding.todo.ui

import android.app.Activity

import android.os.Bundle
import io.keepcoding.todo.R
import io.keepcoding.todo.data.model.Task
import io.keepcoding.todo.ui.base.BaseActivity
import io.keepcoding.todo.ui.tasks.TaskFragment


class DetailTask : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_task)
        var task: Task? = null



   //val objetoIntent:  Intent = intent


        task = intent.getParcelableExtra("task")
        if (task == null) {
            setResult(Activity.RESULT_OK)
            finish()
        }
}





}
