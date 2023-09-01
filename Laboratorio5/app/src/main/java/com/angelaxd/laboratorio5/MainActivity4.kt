package com.angelaxd.laboratorio5

import android.R
import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelaxd.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnaPrincipal3();
                }
            }
        }
    }
}

@Composable
fun ColumnaPrincipal3(){
    //columna principal
    val scrollState= rememberScrollState()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .verticalScroll(state = scrollState)){
        //funcion xd
        BoxFun();
        Rows()

    }


}

@Composable
fun BoxFun(){
    Box(modifier= Modifier
        .fillMaxWidth()
        .background(Color(0xC1D0B9F0))
        .height(400.dp)

    ){
        //Spacer(modifier =Modifier.width(100.dp))
        Imagen2("https://static.vecteezy.com/system/resources/previews/000/597/915/original/sweet-color-blurred-background-set-pastel-color-design-vector.jpg", 10000000, 1000000);
        Column(modifier = Modifier.padding(top = 100.dp, bottom = 20.dp,start=130.dp)){//top = 315.dp, bottom = 2.dp,start=10.dp

            Imagen2("https://www.leadsourcing.co.in/images/user.png", 350, 350);
            Spacer(modifier =Modifier.height(10.dp))
            Text(text = "Cecilia Castillo")
        }
    }
}


@Composable
fun Imagen2(link: String,width: Int,height: Int){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(link)
            //.transformations(CircleCropTransformation())
            .transformations()
            .size(width,height)
            .build(),

        contentDescription = null)
}

@Composable
fun Rows(){
    val link2= "https://th.bing.com/th/id/R.44db2f77ec881db721ba62f4301951ea?rik=Ig0N5HY6LsUccQ&riu=http%3a%2f%2fcdn.onlinewebfonts.com%2fsvg%2fimg_93150.png&ehk=P1t%2fPGt3Ow97cmF3qJeSPcz%2f%2b8kRKjo%2bfPLq5yRUx0M%3d&risl=&pid=ImgRaw&r=0"
    Rowfun2("Edit Profile", "https://www.leadsourcing.co.in/images/user.png",link2);
    Rowfun2("Reset Password","https://static.vecteezy.com/system/resources/previews/000/581/808/non_2x/lock-icon-vector-illustration.jpg","Switch");
    Rowfun2("Notifications","https://www.leadsourcing.co.in/images/user.png",link2);
    Rowfun2("Favorites","https://th.bing.com/th/id/R.2fbb988f573f5b5a2f6ffec738b5cf05?rik=TENoIJPNwOQ4kg&riu=http%3a%2f%2fpluspng.com%2fimg-png%2fstar-png-star-icon-1600.png&ehk=w%2buR8esLZsa%2f81YqoT4HTF09Zc3aGJSyWGWd204WWno%3d&risl=&pid=ImgRaw&r=0",link2);
}

@Composable
fun Rowfun2(string1: String, link1: String, link2: String){
    Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()){
        Imagen(link1, 50, 50);
        Spacer(modifier =Modifier.width(50.dp))
        Texto2(string1);
        Spacer(modifier =Modifier.width(50.dp))
        if (link2!= "Switch"){
            Imagen(link2, 50,50);
        }else{
            BotonSwitch();
        }


    }


}

@Composable
fun Texto2(string1: String){
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = string1,
            fontSize = 20.sp,
            color = Color(0xFF6200EE),
            fontWeight= FontWeight.Bold, //grosor del texto
            fontStyle = FontStyle.Normal, //estilo (normal, cursiva..)
            lineHeight = 20.sp, //altura de linea del texto
            overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
        )

    }

}

@Composable
fun BotonSwitch(){
    //valor predeterminado
    val isPushEnable = remember{ mutableStateOf(false)}
    Switch(checked = isPushEnable.value,
        //actualizar mutableState value
        onCheckedChange = {isPushEnable.value= it
        }
    )
}


@Composable
fun ImagenEstrella(){
    Image(
        painter = painterResource(id = R.drawable.star_off),
        contentDescription = "agenda",
        alignment = Alignment.BottomStart,
        modifier = Modifier
            .padding(3.dp)
            .width(40.dp)
            .height(40.dp),
        contentScale = ContentScale.Crop
    )
}