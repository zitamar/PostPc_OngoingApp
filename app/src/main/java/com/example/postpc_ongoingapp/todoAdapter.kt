package com.example.postpc_ongoingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView




class todoAdapter: RecyclerView.Adapter<TodoHolder>() {

    var todoclickListener: TodoClickListener? = null






    private val _todos : MutableList<Todo> = ArrayList()



    fun setTodos(todos: List<Todo>)
    {
        _todos.clear()
        _todos.addAll(todos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int
    {
        return _todos.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder
    {
        val context = parent.context
        val view = LayoutInflater.from(context)
                .inflate(R.layout.item_one_todo,parent,false)
        return TodoHolder(view)
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int)
    {

        val todo = _todos[position]
        holder.text.setText(todo.message)
//        holder.text.setTextSize(if (todo.isDone)  0.7f
//                else 1.0f);
        holder.itemView.setOnClickListener{
            todoclickListener?.onTodoClicked(todo)

        }
        }



    }







