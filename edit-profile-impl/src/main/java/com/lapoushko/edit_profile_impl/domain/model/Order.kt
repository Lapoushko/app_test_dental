package com.lapoushko.edit_profile_impl.domain.model

data class Order(
    val status: Status = Status.NONE,
    val idOrder: Int = 0,
    val date: String = "30 окт. 11:47",
    val products: List<Product> = emptyList(),
){
    enum class Status(val title: String){
        NONE("Нет статуса"),
        IN_PROCESSING("В обработке"),
        ACCEPTED("Принят"),
        COMPLETED("Выполнен"),
        CANCELLED("Отменен")
    }
}