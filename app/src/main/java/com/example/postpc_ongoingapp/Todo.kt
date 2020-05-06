package com.example.postpc_ongoingapp

import android.os.Parcel
import android.os.Parcelable

data class Todo( val message: String, var isDone: Boolean):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
        parcel.writeByte(if (isDone) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun setDone() {
        this.isDone;

    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }

}





fun createTodo(): List<Todo>
{
    val list = mutableListOf<Todo>()
    list += Todo (message = "finish ex2", isDone = false)
    list += Todo (message = "finish ex3", isDone = false)
    list += Todo (message = "finish ex4", isDone = false)

    return list
}




