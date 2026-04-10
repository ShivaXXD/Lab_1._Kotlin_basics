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
    val isBought = item.isBought

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onToggle(item.id) },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isBought) Color(0xFFF8F9FA) else Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isBought) 0.dp else 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Стилізований чекбокс
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(if (isBought) Color(0xFF4CAF50) else Color(0xFFEDF2F7)),
                    contentAlignment = Alignment.Center
                ) {
                    if (isBought) {
                        Icon(Icons.Rounded.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                    }
                }

                Text(
                    text = item.name,
                    modifier = Modifier.padding(start = 14.dp, end = 8.dp),
                    color = if (isBought) Color(0xFFA0AEC0) else Color(0xFF2D3748),
                    fontSize = 17.sp,
                    fontWeight = if (isBought) FontWeight.Normal else FontWeight.Medium,
                    textDecoration = if (isBought) TextDecoration.LineThrough else TextDecoration.None
                )
            }

            if (!isBought) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFF7FAFC), RoundedCornerShape(12.dp))
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "−",
                        fontSize = 24.sp,
                        color = Color(0xFF667EEA),
                        modifier = Modifier
                            .clickable { onDecrement(item.id) }
                            .padding(horizontal = 12.dp)
                    )
                    Text(
                        text = item.quantity.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D3748)
                    )
                    Text(
                        text = "+",
                        fontSize = 24.sp,
                        color = Color(0xFF667EEA),
                        modifier = Modifier
                            .clickable { onIncrement(item.id) }
                            .padding(horizontal = 12.dp)
                    )
                }
            } else {
                Text(
                    text = "${item.quantity} шт",
                    color = Color(0xFFA0AEC0),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
        }
    }
}