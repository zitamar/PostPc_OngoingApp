package com.example.postpc_ongoingapp;

import java.sql.Time;
//import java.sql.Timestamp;
import com.google.firebase.Timestamp;
public class Todo {

    String id;
    String Content;
    Boolean isDone; // add date
    Timestamp timOfCreation ;
    Timestamp lastTimeEdited;


    public Todo (String id, String content, Boolean isDone, Timestamp timOfCreation, Timestamp lastTimeEdited)
    {
        this.Content = content;
        this.id = id;
        this.isDone = false;
        this.lastTimeEdited = lastTimeEdited;
        this.timOfCreation = timOfCreation;
        //this.timOfCreation = System.currentTimeMillis();
        //this.lastTimeEdited = this.timOfCreation;


    }
    public Timestamp getTimOfCreation() {return this.timOfCreation;}
    public Timestamp getLastTimeEdited() {return this.lastTimeEdited;}


    public String getContent()
    {
        return this.Content;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public void setTodoDone (Boolean isDone)
    {
        this.isDone = isDone;
    }

    public void setLastTimeEdited(Timestamp lastTimeEdited)
    {
        this.lastTimeEdited = lastTimeEdited;
    }
    public void setTimOfCreation( Timestamp timeOfCreation)
    {
        this.timOfCreation = timeOfCreation;
    }
    public void setContent (String content) {this.Content = content;}





}
