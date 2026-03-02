package com.lapoushko.edit_profile_impl.domain.model

/**
 * @author Lapoushko
 */
internal data class Profile(
    val name: String = "",
    val whoAreYou: WhoAreYou = WhoAreYou.NONE,
    val jobTitle: JobTitle = JobTitle.NONE,
    val speciality: Speciality = Speciality.NONE,
    val imageUrl: String = ""
){
    sealed interface ProfileOption {
        val title: String
        val isSelectable: Boolean
            get() = true
    }

    internal enum class WhoAreYou(override val title: String): ProfileOption {
        NONE("Не выбрано") {
            override val isSelectable = false
        },
        DOCTOR_FOR_RENT("Врач на аренде"),
        COSMETOLOGY("Косметология"),
        BEAUTY_SALON("Салон красоты"),
        DENTISTRY("Стоматология"),
        TRADING_ORGANIZATION("Торгующая организация"),
        LABORATORY("Лаборатория"),
        PATIENT("Я пациент")
    }

    internal enum class JobTitle(override val title: String): ProfileOption {
        NONE("Не выбрано") {
            override val isSelectable = false
        },
        ASSISTANT("Ассистент"),
        SENIOR_NURSE("Старшая медсестра"),
        PROCUREMENT_MANAGER("Менеджер по закупкам"),
        CHIEF_DOCTOR("Главный врач"),
        OWNER("Владелец"),
        MANAGER("Управляющая"),
        DENTIST("Врач стоматолог"),
        ADMINISTRATOR("Администратор")
    }

    internal enum class Speciality(override val title: String): ProfileOption {
        NONE("Не выбрано") {
            override val isSelectable = false
        },
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