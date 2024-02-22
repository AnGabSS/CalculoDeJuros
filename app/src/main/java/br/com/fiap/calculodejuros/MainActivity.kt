package br.com.fiap.calculodejuros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.calculodejuros.components.FormularioJuros
import br.com.fiap.calculodejuros.ui.theme.CalculoDeJurosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoDeJurosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JurosScreen()
                }
            }
        }
    }
}

@Composable
fun JurosScreen() {

    var capital by remember { mutableStateOf("") }
    var taxa by remember { mutableStateOf("") }
    var tempo by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
        FormularioJuros(
            capital = capital,
            taxa = taxa,
            tempo = tempo,
            estadoCapital = {capital = it},
            estadoTaxa = {taxa = it},
            estadoTempo = {tempo = it}
        )
    }
}