package io.keepcoding.todo.ui.tasks

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillId
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.keepcoding.todo.R
import io.keepcoding.todo.data.model.Task
import io.keepcoding.todo.ui.DetailTask
import io.keepcoding.todo.util.Navigator
import io.keepcoding.todo.util.bottomsheet.BottomMenuItem
import io.keepcoding.todo.util.bottomsheet.BottomSheetMenu
import kotlinx.android.synthetic.main.abc_activity_chooser_view_list_item.*
import kotlinx.android.synthetic.main.abc_select_dialog_material.*
import kotlinx.android.synthetic.main.fragment_tasks.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskFragment : Fragment(), TaskAdapter.Listener {

    val taskViewModel: TaskViewModel by viewModel()
    val adapter: TaskAdapter by lazy {
        TaskAdapter(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //taskViewModel.sssssss = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUp()
    }

    private fun setUp() {
        setUpRecycler()

        //----->

        //<-----


        with (taskViewModel) {
            tasksEvent.observe(this@TaskFragment, Observer { tasks ->
                adapter.submitList(tasks)
            })
        }
    }

    private fun setUpRecycler() {
        recyclerTasks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerTasks.itemAnimator = DefaultItemAnimator()
        recyclerTasks.adapter = adapter
    }

    override fun onTaskClicked(task: Task) {
        Navigator.navigateToViewTaskActivity(task, context!!)
    }

    override fun onTaskLongClicked(task: Task) {
        val items = arrayListOf(
            BottomMenuItem(R.drawable.ic_edit, getString(R.string.edit)) {
                Navigator.navigateToEditTaskFragment(task, childFragmentManager)
            },
            BottomMenuItem(R.drawable.ic_delete, getString(R.string.delete)) {
                showConfirmDeleteTaskDialog(task)
            }
        )

        BottomSheetMenu(activity!!, items).show()
    }

    private fun showConfirmDeleteTaskDialog(task: Task) {
        AlertDialog.Builder(activity!!)
            .setTitle(R.string.delete_task_title)
            .setMessage(R.string.delete_task_message)
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                taskViewModel.deleteTask(task)
            }
            .setNegativeButton(getString(R.string.no), null)
            .create()
            .show()
    }

    override fun onTaskMarked(task: Task, isDone: Boolean) {
        if (isDone) {
            taskViewModel.markAsDone(task)
        } else {
            taskViewModel.markAsNotDone(task)
        }
    }

    override fun onTaskHighPriorityMarked(task: Task, isHighPriority: Boolean) {
        taskViewModel.markHighPriority(task, isHighPriority)
    }
/*
     fun showDetails(taskId: String){
        val intentToDetails = Intent(this, DetailTask::class.java)
        intentToDetails.putExtra("id", taskId)
        startActivity(intentToDetails)
    }
*/
}
