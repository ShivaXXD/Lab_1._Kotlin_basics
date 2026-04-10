package com.example.lab2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2.model.ShoppingItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class ShoppingViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<ShoppingItem>>(emptyList())
    val items: StateFlow<List<ShoppingItem>> = _items.asStateFlow()

    val remainingItemsCount: StateFlow<Int> = _items
        .map { list -> list.count { !it.isBought } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    fun addItem(name: String) {
        val trimmedName = name.trim()
        if (trimmedName.isNotEmpty()) {
            _items.update { currentList ->
                currentList + ShoppingItem(name = trimmedName)
            }
        }
    }

    fun toggleItemStatus(id: String) {
        _items.update { currentList ->
            currentList.map { item ->
                if (item.id == id) item.copy(isBought = !item.isBought) else item
            }
        }
    }

    fun incrementQuantity(id: String) {
        _items.update { currentList ->
            currentList.map { item ->
                if (item.id == id) item.copy(quantity = item.quantity + 1) else item
            }
        }
    }

    fun decrementQuantity(id: String) {
        _items.update { currentList ->
            currentList.map { item ->
                if (item.id == id && item.quantity > 1) item.copy(quantity = item.quantity - 1) else item
            }
        }
    }
}