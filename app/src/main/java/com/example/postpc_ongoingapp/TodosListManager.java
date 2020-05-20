package com.example.postpc_ongoingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TodosListManager
{
    public ArrayList<Todo> todos ;
    private String KeyForEntireList = "Entire list";
    private Gson gson;

    public TodosListManager(Context context)

    {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String currentList = sp.getString(KeyForEntireList, "");
        gson = new Gson();
        if (currentList.equals(""))
        {
            todos = new ArrayList<>();
        }
        else
        {

            todos = gson.fromJson(currentList,new TypeToken<ArrayList<Todo>>(){}.getType());
        }



    }
    void saveListToSP(Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KeyForEntireList, gson.toJson(todos));
        editor.apply();
    }

    void addTodo (String desc)
    {
        todos.add(new Todo(desc,false));
    }
    void removeFromList(Todo todo)
    {
        todos.remove(todo);
    }


    ArrayList<Todo> getList()
    {
        return todos;
    }


    int length()
    {
        return todos.size();
    }





}
