package com.example.postpc_ongoingapp;


import android.app.Application;
import android.util.Log;

public class TodoApp extends Application
{

    public TodosListManager todos;
    @Override
    public void onCreate()
    {
        super.onCreate();
        todos = new TodosListManager(this);
        Log.d("The list is size of", Integer.toString(todos.length()));
    }

}