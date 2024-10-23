package com.example.sayfalararasigecis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun IkinciSayfa(navController: NavController,
                name:String,
                age:Int){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = name)
        Text(text = age.toString())



        Text(text = "İkinci Sayfa")
        Button(
            onClick = {navController.navigate("ucuncu_sayfa")}
        ) {
            Text(text = "İleri")
        }

        Button(
            onClick = {navController.popBackStack()}
        ) {
            Text(text = "Geri")
        }
    }
}