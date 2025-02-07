package com.example.myproject.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.AuthViewModel
import com.example.myproject.navigation.ROUT_LOGIN
import com.example.myproject.navigation.ROUT_SIGNUP
import com.example.myproject.ui.theme.newPurple
import com.example.myproject.ui.theme.newPurple1


@Composable
fun LoginScreen(navController: NavController){


    Column (modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()
        .background(newPurple),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Spacer(modifier = Modifier.height(80.dp))

        Image(
            painter = painterResource(id = R.drawable.img_7),
            contentDescription = "property",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))


        Column {
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp)
                    .padding(top = 40.dp),
                shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp),
                colors = CardDefaults.cardColors(newPurple1)

            ){

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "LOGIN INTO BOOKCHOR!",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )

                Spacer(modifier = Modifier.height(30.dp))


                var email by remember { mutableStateOf("")}
                var password by remember { mutableStateOf("")}


                TextField(
                    value = email ,
                    onValueChange = {email = it},
                    label = { Text(text = "Email Address")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "" , tint = newPurple)},
                    keyboardOptions = KeyboardOptions(  keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = password ,
                    onValueChange = {password = it},
                    label = { Text(text = "Password")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "" , tint = newPurple)},
                    keyboardOptions = KeyboardOptions(  keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(10.dp))




                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)

                Button(onClick = {  authViewModel.login(email, password) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 20.dp, end = 20.dp),
                    colors = ButtonDefaults.buttonColors(newPurple),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "LOGIN")
                }

                Spacer(modifier = Modifier.height(20.dp))



                Text(
                    text = "Don't have an account? Register",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .clickable { navController.navigate(ROUT_SIGNUP) }
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }





    }

}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}

