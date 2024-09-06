package com.example.myproject.models

class Orders {

    var name:String = ""
    var currentlocation:String = ""
    var date:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, currentlocation: String,date: String,phone: String,  imageUrl: String, id: String) {
        this.name = name
        this.currentlocation = currentlocation
        this.date = date
        this.currentlocation = currentlocation
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}