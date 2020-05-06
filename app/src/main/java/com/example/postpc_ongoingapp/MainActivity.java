package com.example.postpc_ongoingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.postpc_ongoingapp.TodoKt.createTodo;

public class MainActivity extends AppCompatActivity {


    List<Todo>  listOfTodos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) { // if bundle not null insert the parcebel list
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //final TextView textView1 =  findViewById(R.id.textView1);
        final EditText input_text = (EditText) findViewById(R.id.input_text);
        final todoAdapter adapter = new todoAdapter();
        final RecyclerView recyclerView = findViewById(R.id.RecycleView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, recyclerView.VERTICAL,
                false));
        listOfTodos = createTodo();
        adapter.setTodos(listOfTodos);
        final TextView adButton =  (Button) findViewById(R.id.button);
        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToView = input_text.getText().toString();
                input_text.setText("");
                if (textToView.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"EMPTY TEXT", Toast.LENGTH_SHORT).show();
                    return;
                }

//                textView1.setText(textToView);
//
//                textView1.setVisibility(View.VISIBLE);

                listOfTodos.add(new Todo(textToView,false));
                adapter.setTodos(listOfTodos);


            }
        });


        adapter.setTodoclickListener(new TodoClickListener() {
            @Override
            public void onTodoClicked(Todo todo) {
                Toast.makeText(getApplicationContext(),"clickedddd", Toast.LENGTH_SHORT).show();

            }
        });






    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("key",new ArrayList<>(listOfTodos));
    }
}
