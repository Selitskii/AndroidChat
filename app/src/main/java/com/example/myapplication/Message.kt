package com.example.myapplication

import java.util.*


data class Message(
    val id:Int,
    val senderId:Int=0,
    var text:String,
    val date: Date=Date()
)
{
    operator  fun plus(message: Message):Message{
        return  this.copy(text= this.text+"\n"+message.text)
    }

    override fun toString(): String {
        return "Id: $id, SenderId: $senderId, Time: $date, Text $text\n"
    }
    fun Lower(){
        text=text.toLowerCase()
    }
    fun NoDigit(){
        text=text.filterNot { it.isDigit() }
    }
    fun WordFilter(filterList:List<String>){
        filterList.forEach {
            text=text.replace(it,"******",true)
        }
    }
}
