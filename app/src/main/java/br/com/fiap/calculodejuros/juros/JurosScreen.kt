package br.com.fiap.calculodejuros.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculodejuros.components.FormularioJuros
import br.com.fiap.calculodejuros.components.Resultado

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    val capital by jurosScreenViewModel.capital.observeAsState("")
    val taxa by jurosScreenViewModel.taxa.observeAsState("")
    val tempo by jurosScreenViewModel.tempo.observeAsState("")
    val juros by jurosScreenViewModel.juros.observeAsState(0.0)
    val montante by jurosScreenViewModel.montate.observeAsState(0.0)

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )
                    FormularioJuros(
                        capital = capital,
                        taxa = taxa,
                        tempo = tempo,
                        estadoCapital = { jurosScreenViewModel.onCapitalChanged(it) },
                        estadoTaxa = { jurosScreenViewModel.onTaxaChanged(it) },
                        estadoTempo = { jurosScreenViewModel.onTempoChanged(it) },
                    )

                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosViewModel()
                            jurosScreenViewModel.calcularMontanteViewModel()

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp)

                    ) {
                        Text(text = "CALCULAR")
                    }


                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação
            Resultado(juros = juros, montante = montante)
        }
    }
}