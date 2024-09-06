package com.example.myproject.ui.theme.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController){
    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser
    val email = remember { mutableStateOf(user?.email ?: "") }

    Column (modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(com.example.myproject.R.drawable.background), contentScale = ContentScale.FillBounds)

        ,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text("Profile")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Email: ${email.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            auth.signOut()
            navController.navigate("login") {
                popUpTo("login") { inclusive = true }
            }
        }) {
            Text("Logout")
        }

    }


}
@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview(){
    ProfileScreen(rememberNavController())

}