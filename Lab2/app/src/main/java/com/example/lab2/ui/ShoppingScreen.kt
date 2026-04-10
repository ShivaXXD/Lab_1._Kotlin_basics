package com.example.lab2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lab2.viewmodel.ShoppingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingScreen(viewModel: ShoppingViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val items by viewModel.items.collectAsStateWithLifecycle()
    val remaining by viewModel.remainingItemsCount.collectAsStateWithLifecycle()
    var inputText by remember { mutableStateOf("") }
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF1F3F5)).statusBarsPadding().padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Rounded.ShoppingCart, null, tint = Color(0xFF4C6EF5), modifier = Modifier.size(32.dp))
            Spacer(Modifier.width(12.dp))
            Text("Smart Buy", fontSize = 28.sp, fontWeight = FontWeight.Black, color = Color(0xFF212529))
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { showSheet = true }) {
                Icon(Icons.Rounded.Delete, null, tint = Color(0xFFFA5252))
            }
        }

        Text("Залишилось: $remaining", color = Color(0xFF4C6EF5), fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))

        Row(Modifier.fillMaxWidth().padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = inputText, onValueChange = { inputText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Що купимо?") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent)
            )
            Spacer(Modifier.width(12.dp))
            Button(
                onClick = { viewModel.addItem(inputText); inputText = "" },
                enabled = inputText.isNotBlank(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C6EF5))
            ) { Text("OK", fontWeight = FontWeight.Bold) }
        }

        LazyColumn {
            items(items, key = { it.id }) { item ->
                ShoppingItemCard(item, viewModel::toggleItemStatus, viewModel::incrementQuantity, viewModel::decrementQuantity)
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(onDismissRequest = { showSheet = false }, sheetState = sheetState) {
            Column(Modifier.fillMaxWidth().padding(24.dp)) {
                Text("Очистити список", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(16.dp))
                DeleteOption("Видалити куплені") { viewModel.clearBought(); showSheet = false }
                DeleteOption("Видалити некуплені") { viewModel.clearToBuy(); showSheet = false }
                DeleteOption("Видалити ВСЕ", Color(0xFFFA5252)) { viewModel.clearAll(); showSheet = false }
                Spacer(Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun DeleteOption(label: String, color: Color = Color(0xFF212529), onClick: () -> Unit) {
    TextButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(label, color = color, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}