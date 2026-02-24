package com.lapoushko.profile_impl.presentation

/**
 * @author Lapoushko
 */
internal data class ProfileScreenState(
    val name: String = "Нет имени",
    val whoAreYou: WhoAreYou = WhoAreYou.NONE,
    val jobTitle: JobTitle = JobTitle.NONE,
    val speciality: Speciality = Speciality.NONE,
    val bonus: Int = 0,
    val countFeaturedProducts: Int = 0,
    val countOrders: Int = 0,
    val countProductComparisons: Int = 0,
    val moneyInWallet: Int = 0,
    val unreadMessages: Int = 0,
    val currentOrders: List<String> = emptyList(),
    val historyOrders: List<String> = emptyList()
){
    internal enum class WhoAreYou(val title: String) {
        NONE("Не выбрано"),
        DOCTOR_FOR_RENT("Врач на аренде"),
        COSMETOLOGY("Косметология"),
        BEAUTY_SALON("Салон красоты"),
        DENTISTRY("Стоматология"),
        TRADING_ORGANIZATION("Торгующая организация"),
        LABORATORY("Лаборатория"),
        PATIENT("Я пациент")
    }

    internal enum class JobTitle(val title: String) {
        NONE("Не выбрано"),
        ASSISTANT("Ассистент"),
        SENIOR_NURSE("Старшая медсестра"),
        PROCUREMENT_MANAGER("Менеджер по закупкам"),
        CHIEF_DOCTOR("Главный врач"),
        OWNER("Владелец"),
        MANAGER("Управляющая"),
        DENTIST("Врач стоматолог"),
        ADMINISTRATOR("Администратор")
    }

    internal enum class Speciality(val title: String) {
        NONE("Не выбрано"),
        THERAPIST("Терапевт"),
        ORTHOPEDIST("Ортопед"),
        SURGEON("Хирург"),
        ORTHODONTIST("Ортодонт"),
        IMPLANTOLOGIST("Имплантолог"),
        ENDODONTIST("Эндодонт"),
        HYGIENIST("Гигиенист"),
        OTHER("Другое")
    }
}