package com.lapoushko.profile_impl.domain

data class Order(
    val status: Status = Status.NONE,
    val idOrder: Int = 0,
    val date: String = "data",
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