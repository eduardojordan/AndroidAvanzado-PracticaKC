package io.keepcoding.todo.di.koin

import androidx.room.Room
import io.keepcoding.todo.data.model.mapper.TaskEntityMapper
import io.keepcoding.todo.data.model.mapper.TaskMapper
import io.keepcoding.todo.data.repository.TaskRepository
import io.keepcoding.todo.data.repository.TaskRepositoryImpl
import io.keepcoding.todo.data.repository.datasource.local.LocalDataSource
import io.keepcoding.todo.data.repository.datasource.local.TodoDatabase
import io.keepcoding.todo.ui.tasks.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { TaskMapper() }

    single { TaskEntityMapper() }

    single<TodoDatabase> {
        Room.databaseBuilder(androidContext(), TodoDatabase::class.java, "todo.db")
            .build()
    }

    single { LocalDataSource(get(), get(), get()) }

    single<TaskRepository> { TaskRepositoryImpl(get()) }

    viewModel { TaskViewModel(get()) }

}