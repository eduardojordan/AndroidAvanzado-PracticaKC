package io.keepcoding.todo.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import io.keepcoding.todo.data.model.Task
import io.keepcoding.todo.ui.DetailTask
import io.keepcoding.todo.ui.edittask.EditTaskFragment
import io.keepcoding.todo.ui.newtask.NewTaskActivity

object Navigator {

    fun navigateToNewTaskActivity(context: Context) {
        val intent = Intent(context, NewTaskActivity::class.java)
        context.startActivity(intent)
    }

    fun navigateToEditTaskFragment(task: Task, fragmentManager: FragmentManager) {
        val fragment = EditTaskFragment.newInstance(task)
        fragment.show(fragmentManager, null)
    }


    fun navigateToViewTaskActivity(task: Task, context: Context) {
        val intent = Intent(context, DetailTask::class.java)
        intent.putExtra("task", task)
        context.startActivity(intent)
    }

}