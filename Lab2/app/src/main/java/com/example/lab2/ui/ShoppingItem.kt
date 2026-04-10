package com.example.lab2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.model.ShoppingItem

@Composable
fun ShoppingItemCard(
    item: ShoppingItem,
    onToggle: (String) -> Unit,
    onIncrement: (String) -> Unit,
    onDecrement: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = if (item.isBought) Color(0xFFF1F3F5) else Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = if (item.isBought) 0.dp else 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(32.dp).clip(CircleShape)
                    .background(if (item.isBought) Color(0xFF37B24D) else Color(0xFFE9ECEF))
                    .clickable { onToggle(item.id) },
                contentAlignment = Alignment.Center
            ) {
                if (item.isBought) Icon(Icons.Rounded.Check, null, tint = Color.White, modifier = Modifier.size(20.dp))
            }

            Text(
                text = item.name,
                modifier = Modifier.padding(start = 16.dp).weight(1f),
                color = if (item.isBought) Color(0xFFADB5BD) else Color(0xFF212529),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = if (item.isBought) TextDecoration.LineThrough else TextDecoration.None
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color(0xFFF8F9FA), RoundedCornerShape(16.dp)).padding(4.dp)
            ) {
                Text("−", fontSize = 20.sp, color = Color(0xFF4C6EF5),
                    modifier = Modifier.clickable { onDecrement(item.id) }.padding(horizontal = 12.dp))

                Text(item.quantity.toString(), fontWeight = FontWeight.Bold)

                Text("+", fontSize = 20.sp, color = Color(0xFF4C6EF5),
                    modifier = Modifier.clickable { onIncrement(item.id) }.padding(horizontal = 12.dp))
            }
        }
    }
}