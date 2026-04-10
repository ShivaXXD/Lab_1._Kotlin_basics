package com.example.lab2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.viewmodel.ShoppingViewModel

@Composable
fun ShoppingScreen(viewModel: ShoppingViewModel = viewModel()) {
    val items by viewModel.items.collectAsStateWithLifecycle()
    val remainingCount by viewModel.remainingItemsCount.collectAsStateWithLifecycle()
    var inputText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAFC))
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Список покупок \uD83D\uDED2",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF2D3748)
        )

        Text(
            text = buildAnnotatedString {
                append("Залишилось купити: ")
                withStyle(style = SpanStyle(color = Color(0xFF667EEA), fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append(remainingCount.toString())
                }
            },
            modifier = Modifier.padding(bottom = 24.dp, top = 8.dp),
            color = Color(0xFF718096),
            fontSize = 16.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Наприклад, молоко", color = Color(0xFFA0AEC0)) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF667EEA),
                    unfocusedBorderColor = Color(0xFFE2E8F0),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { viewModel.addItem(inputText); inputText = "" },
                enabled = inputText.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF667EEA),
                    disabledContainerColor = Color(0xFFCBD5E0)
                ),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Text("Додати", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        val toBuy = items.filter { !it.isBought }
        val bought = items.filter { it.isBought }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (toBuy.isNotEmpty()) {
                item { SectionTitle("Потрібно купити") }
                items(items = toBuy, key = { it.id }) { item ->
                    ShoppingItemCard(item, viewModel::toggleItemStatus, viewModel::incrementQuantity, viewModel::decrementQuantity)
                }
            }
            if (bought.isNotEmpty()) {
                item { Spacer(modifier = Modifier.height(20.dp)) }
                item { SectionTitle("Куплено") }
                items(items = bought, key = { it.id }) { item ->
                    ShoppingItemCard(item, viewModel::toggleItemStatus, viewModel::incrementQuantity, viewModel::decrementQuantity)
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title.uppercase(),
        color = Color(0xFFA0AEC0),
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = 1.2.sp,
        modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)
    )
}