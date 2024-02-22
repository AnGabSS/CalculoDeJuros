package br.com.fiap.calculodejuros.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun FormularioJuros(
    capital: String,
    taxa: String,
    tempo: String,
    estadoCapital: (String) -> Unit,
    estadoTaxa: (String) -> Unit,
    estadoTempo: (String) -> Unit,
) {
        CaixaDeEntrada(
            label = "Valor do investimento",
            placeholder = "Quanto deseja investir?",
            value = capital,
            keyboardType = KeyboardType.Decimal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            mudarEstado = estadoCapital
        )
        CaixaDeEntrada(
            label = "Taxa de juros mensal",
            placeholder = "Qual a taxa de juros mensal?",
            value = taxa,
            keyboardType = KeyboardType.Decimal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            mudarEstado = estadoTaxa
        )
        CaixaDeEntrada(
            label = "Período em meses",
            placeholder = "Qual o tempo em meses?",
            value = tempo,
            keyboardType = KeyboardType.Decimal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            mudarEstado = estadoTempo
        )
}