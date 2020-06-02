package com.example.postpc_ongoingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
//import java.sql.Timestamp;
//import com.google.firebase.Timestamp;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.gson.Gson;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TodosListManager
{
    public ArrayList<Todo> todos ;
    private FirebaseFirestore db;
    private int todoIndex;

    private static final String KEY_CONTENT = "content";
    private static final String KEY_ISDONE = "isDone";
    private static final String KEY_INDEX = "index";
    private static final String COLLECTION = "todos";
    private static final String KEY_CREATION = "time of creation";
    private static final String KEY_MODIFICATION = "time of modification";
    private CollectionReference todosRef = db.collection(COLLECTION);

    public TodosListManager(Context context)

    {
        this.todos = new ArrayList<>();
        this.db = FirebaseFirestore.getInstance();
        this.todoIndex = 0;
    }

    int length()
    {
        return todos.size();
    }
    void remove_todo(String documentID)
    {
        //Map<String,Object> data = todosRef.document(documentID);
        DocumentReference docref = db.collection(COLLECTION).document(documentID);
        



    }


    public void loadTodos()
    {
        Task<QuerySnapshot> TodoDB = todosRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && task.getResult() != null)
                        {
                            todos.clear();
                            for (QueryDocumentSnapshot doc: task.getResult())
                            {
                                Map<String, Object> currentTodo = doc.getData();
                                todos.add(new Todo((int)currentTodo.get(KEY_INDEX),
                                        (String)currentTodo.get(KEY_CONTENT),
                                        (Boolean)currentTodo.get(KEY_ISDONE),(Timestamp)currentTodo.get(KEY_CREATION),
                                        (Timestamp)currentTodo.get(KEY_MODIFICATION)));
                            }

                        }
                        else
                        {
                            Toast.makeText(db.getApp().getApplicationContext(),
                                    "CONNECTION FAILD",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void addTodo(String content)
    {
        //int currentId = todoIndex;


        addTodoToDB(content);


    }
    public void addTodoToDB(String content)
    {
        final Timestamp time = Timestamp.now();
        final Todo todo = new Todo (todoIndex, content, false,time,time);
        Map<String,Object> todoToAdd = new HashMap<>();
        todoToAdd.put(KEY_CONTENT, todo.getContent());
        todoToAdd.put(KEY_ISDONE, todo.getIsDone());
        todoToAdd.put(KEY_INDEX, todo.getId());
        //todoToAdd.put(KEY_CREATION, todo.getTimOfCreation());
        //todoToAdd.put(KEY_MODIFICATION, todo.getLastTimeEdited());

        todoToAdd.put(KEY_CREATION, time);
        todoToAdd.put(KEY_MODIFICATION, time);
        db.collection("Todos").add(todoToAdd).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                todoIndex ++;
                todos.add(todo);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR","failed to update DB");

            }
        });


    }








}
