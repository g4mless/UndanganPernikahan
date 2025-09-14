package com.undangan.pernikahan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage // Example using Coil
import com.undangan.pernikahan.ui.theme.UndanganPernikahanTheme
import com.undangan.pernikahan.ui.theme.greatVibesFamily
import com.undangan.pernikahan.ui.theme.loraFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UndanganPernikahanTheme {
                @OptIn(ExperimentalMaterial3Api::class)
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Undangan Pernikahan",
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    WeddingInvitationScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WeddingInvitationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        //Text(
        //    text = "Bersama Ini Kami Mengundang Anda",
        //    style = MaterialTheme.typography.headlineSmall,
        //    textAlign = TextAlign.Center
        //)

        AsyncImage(
            model = R.drawable.ic_launcher_foreground, // Replace with your actual image
            contentDescription = "Couple Photo",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Nama Anda\n&\nNama Istri Anda",
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = greatVibesFamily
            ),
            textAlign = TextAlign.Center,
            lineHeight = MaterialTheme.typography.displaySmall.fontSize * 1.2
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = DividerDefaults.Thickness,
            color = DividerDefaults.color
        )

        EventDetailItem(label = "Tanggal Acara:", value = "Minggu, 21 September 2025")
        EventDetailItem(label = "Waktu:", value = "10:00 WIB - Selesai")
        EventDetailItem(label = "Lokasi:", value = "Gedung Serbaguna ABC\nJl. Merdeka No. 1, Jakarta")

        Text(
            text = "Atas kehadiran dan doa restunya, kami ucapkan terima kasih.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun EventDetailItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = loraFamily
            ),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = loraFamily
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeddingInvitationPreview() {
    UndanganPernikahanTheme {
        WeddingInvitationScreen()
    }
}