package io.keepcoding.todo.data.model.mapper

import io.keepcoding.todo.data.model.Task
import io.keepcoding.todo.data.repository.datasource.local.TaskEntity

class TaskEntityMapper : Mapper<Task, TaskEntity> {

    override fun transform(input: Task): TaskEntity =
        TaskEntity(
            input.id,
            input.content,
            input.createdAt,
            input.isDone,
            input.isHighPriority
        )

    override fun transformList(input: List<Task>): List<TaskEntity> =
            input.map { transform(it) }

}