package com.example.lab2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab2.model.ShoppingItem
import kotlinx.coroutines.flow.*

class ShoppingViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<ShoppingItem>>(emptyList())
    val items: StateFlow<List<ShoppingItem>> = _items.asStateFlow()

    val remainingItemsCount = _items.map { list -> list.count { !it.isBought } }
        .stateIn(kotlinx.coroutines.MainScope(), SharingStarted.WhileSubscribed(5000), 0)

    fun addItem(name: String) {
        if (name.isNotBlank()) _items.update { it + ShoppingItem(name = name.trim()) }
    }

    fun toggleItemStatus(id: String) {
        _items.update { list -> list.map { if (it.id == id) it.copy(isBought = !it.isBought) else it } }
    }

    fun incrementQuantity(id: String) {
        _items.update { list -> list.map { if (it.id == id) it.copy(quantity = it.quantity + 1) else it } }
    }

    fun decrementQuantity(id: String) {
        _items.update { list ->
            val item = list.find { it.id == id } ?: return@update list
            if (item.quantity > 1) {
                list.map { if (it.id == id) it.copy(quantity = it.quantity - 1) else it }
            } else {
                list.filter { it.id != id } // Видалення, якщо 0
            }
        }
    }

    fun clearAll() = _items.update { emptyList() }
    fun clearBought() = _items.update { it.filter { !it.isBought } }
    fun clearToBuy() = _items.update { it.filter { it.isBought } }
}