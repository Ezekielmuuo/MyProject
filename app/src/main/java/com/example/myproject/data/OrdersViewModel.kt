package com.example.myproject.data

import com.example.myproject.models.Orders



import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.myproject.navigation.ADD_ORDERS_URL
import com.example.myproject.navigation.VIEW_ORDERS_URL


import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class OrdersViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)

        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadOrder(name:String, currentlocation:String, date: String,phone: String,filePath: Uri){
        val orderId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Orders/$orderId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var order = Orders(name,currentlocation,date,phone,imageUrl,orderId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Orders/$orderId")
                    databaseRef.setValue(order).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_ORDERS_URL)
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allOrders(
        order: MutableState<Orders>,
        orders: SnapshotStateList<Orders>
    ):SnapshotStateList<Orders>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Orders")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                orders.clear()
                for (snap in snapshot.children){
                    var retrievedOrders = snap.getValue(Orders::class.java)
                    order.value = retrievedOrders!!
                    orders.add(retrievedOrders)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB inaccessible", Toast.LENGTH_SHORT).show()
            }
        })
        return orders
    }

    fun updateOrders(orderId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Orders/$orderId")
        ref.removeValue()
        navController.navigate(ADD_ORDERS_URL)
    }


    fun deleteOrders(orderId: String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Orders/$orderId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}