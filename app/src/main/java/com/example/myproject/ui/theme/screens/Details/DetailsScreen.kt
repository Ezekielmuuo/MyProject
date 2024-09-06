package com.example.myproject.ui.theme.screens.Details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.navigation.ROUT_HOME
import com.example.myproject.ui.theme.newPurple
import com.example.myproject.ui.theme.screens.home.bottomNavItems

@Composable
fun DetailScreen(navController: NavController){

    Column (modifier = Modifier
        .fillMaxSize()
       ){


        Spacer(modifier = Modifier.height(50.dp))


        Column(modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(newPurple)){

            //search bar
            var search by remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = search ,
                onValueChange ={ search = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                placeholder = { Text(text = "Search your favourite book")}

            )
//end of searchbar
        }

        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Row (modifier = Modifier.padding(20.dp)){

                //end of card
                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column (modifier = Modifier.padding(bottom = 5.dp)){
                        Spacer(modifier = Modifier
                            .width(10.dp)
                            .padding(start = 20.dp, end = 40.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book1),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "The Race of My Life ",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black,
                            textAlign = TextAlign.Center

                        )
                        Text(
                            text = "Author: Milkha Singh ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            textAlign = TextAlign.Center

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                //end of card

                Spacer(modifier = Modifier.width(20.dp))

                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column  (modifier = Modifier.padding(bottom = 5.dp)){
                        Spacer(modifier = Modifier.width(10.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                            contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book2),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "My Life in Full ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Text(
                            text = "Author: Indra        Nooyi ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                //end of card


            }
            //End of row 1
            Row (modifier = Modifier.padding(20.dp)){

                //end of card
                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column  (modifier = Modifier.padding(bottom = 5.dp)){
                        Spacer(modifier = Modifier
                            .width(10.dp)
                            .padding(start = 20.dp, end = 40.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book3),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "The India Story ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Text(
                            text = "Author: Bimal       Jalan ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                //end of card
                Spacer(modifier = Modifier.width(20.dp))

                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column  (modifier = Modifier.padding(bottom = 5.dp)){
                        Spacer(modifier = Modifier.width(10.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book4),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "We are Displaced ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black

                        )
                        Text(
                            text = "Author:Malala Yousafzai ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                //end of card


            }
            //End of row 1
            Row (modifier = Modifier.padding(20.dp)){

                //end of card
                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column (modifier = Modifier.padding(bottom = 5.dp)) {
                        Spacer(modifier = Modifier
                            .width(10.dp)
                            .padding(start = 20.dp, end = 40.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book5),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "And Then One Day ",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Text(
                            text = "Author: Naseeruddin Shah ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                Spacer(modifier = Modifier.width(20.dp))

                //end of card
                Card (modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_HOME)
                    },
                    elevation = CardDefaults.cardElevation(10.dp)){

                    Column (modifier = Modifier.padding(bottom = 5.dp)) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), contentAlignment = Alignment.Center){
                            Image(
                                painter = painterResource(id = R.drawable.book6),
                                contentDescription ="book 1",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Guns and Thighs",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center

                        )
                        Text(
                            text = "Author: Ram Gopal Varmae ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black

                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(start = 20.dp, end = 20.dp),
                            colors = ButtonDefaults.buttonColors(newPurple),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Read")

                        }


                    }

                }
                //end of card



            }


        }


    }






}


val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Details",
        route="details",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Property",
        route="property",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=1
    ),
    BottomNavItem(
        title = "About",
        route="about",
        selectedIcon=Icons.Filled.ShoppingCart,
        unselectedIcon=Icons.Outlined.ShoppingCart,
        hasNews = true,
        badges=1
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
@Preview(showBackground = true)
fun DetailScreenPreview(){
    DetailScreen(rememberNavController())
}

