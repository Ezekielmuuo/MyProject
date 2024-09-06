package com.example.myproject.ui.theme.screens.Orders

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.data.OrdersViewModel

import com.example.myproject.navigation.VIEW_ORDERS_URL
import com.example.myproject.ui.theme.newPurple
import java.util.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddOrdersScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar (
                    containerColor = Color.LightGray,
                    contentColor = Color.Black){
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge (containerColor = Color.White){
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            }
                        )
                    }
                }
            },


            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "Make An Order!",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif)


                    Spacer(modifier = Modifier.height(10.dp))


              Column(  modifier = Modifier

                  .verticalScroll(rememberScrollState())) {
                  Card(
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(700.dp)
                          .padding(top = 40.dp),
                      shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp),
                      colors = CardDefaults.cardColors(newPurple)
                  ){
                      Spacer(modifier = Modifier.height(30.dp))


                      Column (horizontalAlignment = Alignment.CenterHorizontally){
                          var name by remember { mutableStateOf("") }
                          var clocation by remember { mutableStateOf("") }
                          var phone by remember { mutableStateOf("") }
                          val context = LocalContext.current

                          Text(
                              text = "Enter the required details",
                              fontSize = 20.sp,
                              fontWeight = FontWeight.Bold,
                              fontFamily = FontFamily.SansSerif,
                              color = Color.White)

                          Spacer(modifier = Modifier.height(10.dp))

                          TextField(
                              value = name,
                              onValueChange = { name = it },
                              label = { Text(text = "Your name ") },
                              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(start = 20.dp, end = 20.dp),
                          )

                          Spacer(modifier = Modifier.height(10.dp))

                          TextField(
                              value = clocation,
                              onValueChange = { clocation = it },
                              label = { Text(text = "Current Location ") },
                              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(start = 20.dp, end = 20.dp),
                              trailingIcon = { Icon(imageVector = Icons.Default.LocationOn, contentDescription = "" , tint = newPurple)},

                              )



                          Spacer(modifier = Modifier.height(20.dp))



                          //DateField
                          var selectedDate by remember { mutableStateOf("") }
                          var showDatePicker by remember { mutableStateOf(false) }



                          Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){

                              Button(onClick = {
                                  val calendar = Calendar.getInstance()
                                  val year = calendar.get(Calendar.YEAR)
                                  val month = calendar.get(Calendar.MONTH)
                                  val day = calendar.get(Calendar.DAY_OF_MONTH)

                                  DatePickerDialog(
                                      //Don't forget to create the context variable located just below
                                      //the aboutscreen function
                                      context,
                                      { _, selectedYear, selectedMonth, selectedDay ->
                                          selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                                      },
                                      year,
                                      month,
                                      day
                                  ).show()
                              },
                                  shape = RoundedCornerShape(10.dp),
                                  colors = ButtonDefaults.buttonColors(Color.Gray),
                                  modifier = Modifier
                                      .height(65.dp)
                                      .padding(top = 10.dp)) {
                                  Text(text = "Delivery Date")
                              }
                              Spacer(modifier = Modifier.width(20.dp))

                              OutlinedTextField(
                                  value = selectedDate ?: "",
                                  onValueChange = { /* No-op, as we handle value through date picker */ },
                                  label = { Text("Select Date", color = Color.White) },
                                  readOnly = true,  // Makes the text field non-editable
                                  modifier = Modifier
                                      .padding(bottom = 16.dp)
                                      .width(250.dp),
                                  trailingIcon = {
                                      Text(text = "📅")  // Icon to indicate date picker
                                  },
                                  singleLine = true
                              )


                          }

                          //End of a datefield



                          TextField(
                              value = phone,
                              onValueChange = { phone = it },
                              label = { Text(text = "Phone") },
                              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(start = 20.dp, end = 20.dp),
                          )

                          Spacer(modifier = Modifier.height(20.dp))



                          //---------------------IMAGE PICKER START-----------------------------------//

                          var modifier = Modifier
                          ImagePicker(modifier,context, navController, name.trim(), clocation.trim(),selectedDate.trim(),phone.trim())

                          //---------------------IMAGE PICKER END-----------------------------------//



                      }

                  }
              }


                }



            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)


@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavController, name:String, currentlocation:String, date:String, phone:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = Modifier) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var orderRepository = OrdersViewModel(navController,context)
                orderRepository.uploadOrder(name, currentlocation,date, phone,imageUri!!)


            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.White)) {
                Text(text = "Make Order", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(120.dp))

        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddOrdersScreenPreview(){
    AddOrdersScreen(rememberNavController())
}

