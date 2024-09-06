package com.example.myproject.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.navigation.ROUT_DETAILS
import com.example.myproject.ui.theme.newPurple
import com.example.myproject.ui.theme.newPurple1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController){
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
                    containerColor = newPurple1){
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
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                    ,

                    ){
                    //Body of the screen

                    //Column1

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(newPurple)
                            .height(140.dp)
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp)) {

                        Text(
                            text = "Welcome to Bookchor",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold)


                        Spacer(modifier = Modifier.height(20.dp))

                        //Searchbar
                        var search by remember { mutableStateOf("") }
                        TextField(
                            value = search,
                            onValueChange = { search = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            },
                            placeholder = { Text(text = "Search for books") }
                        )

                        //End of searchbar

                    }
                    //Colum1-End


                    Spacer(modifier = Modifier.height(20.dp))


                    Column (modifier = Modifier.padding(start = 20.dp).verticalScroll(rememberScrollState())){
                        Row {

                            Text(
                                text = "Categories",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(
                                text = "View Books",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                                    .clickable { navController.navigate(ROUT_DETAILS) }
                            )

                        }

                        Spacer(modifier = Modifier.height(20.dp))


                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                            //Card 1
                            Card(
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(150.dp)
                            ) {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                    Image(
                                        painter = painterResource(id = R.drawable.book2),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )



                                }

                            }

                            //End of card
                            Spacer(modifier = Modifier.width(20.dp))


                            //Card 2
                            Card(
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(150.dp)
                            ) {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                    Image(
                                        painter = painterResource(id = R.drawable.img_11),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

                                }

                            }

                            //End of card
                            Spacer(modifier = Modifier.width(20.dp))


                            //Card 3
                            Card(
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(150.dp)
                            ) {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                    Image(
                                        painter = painterResource(id = R.drawable.book6),
                                        contentDescription = "home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

                                }

                            }

                            //End of card
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Row {

                            Text(
                                text = "Book Stores",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(
                                text = "View Book Stores",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )

                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        //Card1
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(end = 20.dp)){

                            Row {
                                //Card 3
                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(140.dp)
                                ) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                        Image(
                                            painter = painterResource(id = R.drawable.img_14),
                                            contentDescription = "home",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }

                                }
                                Spacer(modifier = Modifier.width(20.dp))


                                Column {
                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = "Bookchor-Main",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Text(
                                            text = "Westlands",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )

                                    }

                                    Spacer(modifier = Modifier.height(38.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Yellow,modifier = Modifier.padding(top = 14.dp))
                                        Text(
                                            text = "4.1",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            modifier = Modifier.padding(top = 13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Button(onClick = { /*TODO*/ },
                                            shape = RoundedCornerShape(5.dp),
                                            colors = ButtonDefaults.buttonColors(newPurple),
                                            modifier = Modifier
                                                .width(150.dp)
                                                .height(35.dp)
                                        ) {
                                            Text(text = "View")
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(45.dp))



                                }


                            }
                        }
                        //End of card1

                        Spacer(modifier = Modifier.height(20.dp))

                        //Card1
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(end = 20.dp)){

                            Row {
                                //Card 3
                                Card(
                                    modifier = Modifier
                                        .height(160.dp)
                                        .width(140.dp)
                                ) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                        Image(
                                            painter = painterResource(id = R.drawable.img_13),
                                            contentDescription = "home",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }

                                }
                                Spacer(modifier = Modifier.width(20.dp))


                                Column {
                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = "Bookchor-Lavington",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Text(
                                            text = "Lavington",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )

                                    }

                                    Spacer(modifier = Modifier.height(38.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Yellow,modifier = Modifier.padding(top = 14.dp))
                                        Text(
                                            text = "4.1",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            modifier = Modifier.padding(top = 13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Button(onClick = { /*TODO*/ },
                                            shape = RoundedCornerShape(5.dp),
                                            colors = ButtonDefaults.buttonColors(newPurple),
                                            modifier = Modifier
                                                .width(150.dp)
                                                .height(35.dp)
                                        ) {
                                            Text(text = "View")
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(45.dp))



                                }


                            }
                        }
                        //End of card1

                        Spacer(modifier = Modifier.height(20.dp))

                        //Card1
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(end = 20.dp)){

                            Row {
                                //Card 3
                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(140.dp)
                                ) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                        Image(
                                            painter = painterResource(id = R.drawable.img_15),
                                            contentDescription = "home",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }

                                }
                                Spacer(modifier = Modifier.width(20.dp))


                                Column {
                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = "Kitusuru Branch",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Text(
                                            text = "KItusuru",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )

                                    }

                                    Spacer(modifier = Modifier.height(38.dp))

                                    Row {
                                        Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Yellow,modifier = Modifier.padding(top = 14.dp))
                                        Text(
                                            text = "4.1",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            modifier = Modifier.padding(top = 13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(30.dp))

                                        Button(onClick = { /*TODO*/ },
                                            shape = RoundedCornerShape(5.dp),
                                            colors = ButtonDefaults.buttonColors(newPurple),
                                            modifier = Modifier
                                                .width(150.dp)
                                                .height(35.dp)
                                        ) {
                                            Text(text = "View")
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(45.dp))



                                }


                            }
                        }
                        //End of card1

                        Spacer(modifier = Modifier.height(120.dp))



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
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),

    BottomNavItem(
        title = "Other Books",
        route="details",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Star,
        hasNews = false,
        badges=0
    ),

    BottomNavItem(
        title = "Make Order",
        route="add_orders",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Star,
        hasNews = false,
        badges=0
    ),

    BottomNavItem(
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = false,
        badges=0
    ),






    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}