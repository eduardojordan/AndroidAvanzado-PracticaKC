package io.keepcoding.todo.data.repository

import io.keepcoding.todo.data.model.Task
import io.reactivex.Flowable
import io.reactivex.Single

interface TaskRepository {

    fun getAll(): Single<List<Task>>

    fun observeAll(): Flowable<List<Task>>

    fun getTaskById(taskId: Long): Single<Task>

    fun insert(task: Task)

    fun delete(task: Task)

    fun update(task: Task)

}