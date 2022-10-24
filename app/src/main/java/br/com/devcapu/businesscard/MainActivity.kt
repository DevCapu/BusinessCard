package br.com.devcapu.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    CardScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        CardScreen()
    }
}

@Composable
private fun CardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF003A49))
            .padding(vertical = 48.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            ImageWithTitleAndSubtitle(
                image = image,
                title = "Felipe Moreno Borges",
                subtitle = "Android Developer Extraordinaire"
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            val modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.White)

            Spacer(modifier = modifier)
            RowWithIconAndText(icon = Icons.Default.Phone, text = "+55 (11) 99999-9999")
            Spacer(modifier = modifier)
            RowWithIconAndText(icon = Icons.Default.Share, text = "@devcapu")
            Spacer(modifier = modifier)
            RowWithIconAndText(icon = Icons.Default.Email, text = "devcapu@gmail.com")
        }
    }
}

@Composable
private fun ImageWithTitleAndSubtitle(image: Painter, title: String, subtitle: String) {
    Image(
        modifier = Modifier.size(96.dp),
        painter = image,
        contentDescription = null
    )
    Text(
        text = title,
        fontSize = 32.sp,
        color = Color.White,
        fontWeight = FontWeight.Light
    )
    Text(
        text = subtitle,
        color = Color(0xFF3ddc84),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
private fun RowWithIconAndText(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84)
        )
        Text(
            text = text,
            color = Color.White
        )
    }
}