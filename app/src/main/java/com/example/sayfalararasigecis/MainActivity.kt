package com.example.sayfalararasigecis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sayfalararasigecis.ui.theme.SayfalarArasiGecisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SayfalarArasiGecisTheme {
                SayfaGecis()

            }
        }
    }
}
@Composable
fun SayfaGecis(){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = "ilk_sayfa"){

        composable(route = "ilk_sayfa") {
            BirinciSayfa(navController)
        }
        composable(route = "ikinci_sayfa"+"?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name"){
                    type= NavType.StringType
                    defaultValue="isim yok"
                },
                navArgument(name = "age"){
                    type= NavType.IntType
                    defaultValue=0
                }
            )
        ) {
            val name =it.arguments?.getString("name")!!
            val age = it.arguments?.getInt("age")
            if (age != null) {
                IkinciSayfa(navController,name,age)
            }
        }
        composable(route = "ucuncu_sayfa") {
            UcuncuSayfa(navController)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayfalarArasiGecisTheme {
    }
}