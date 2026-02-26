package com.lapoushko.core_ui.util

/**
 * @author Lapoushko
 * Падежи для городов
 */
data class CityDeclension(
    val nominative: String,
    val genitive: String,
    val dative: String,
    val accusative: String,
    val instrumental: String,
    val prepositional: String
)

fun String.extractCityAndDeclensions(): CityDeclension? {
    val cityRegex = Regex("""г\.\s*([А-ЯЁ][а-яё]+)""", RegexOption.IGNORE_CASE)
    val match = cityRegex.find(this)

    val city = match?.groupValues?.get(1)?.trim()?.capitalize() ?: return null

    return when (city.lowercase()) {
        "москва" -> CityDeclension("Москва", "Москвы", "Москве", "Москву", "Москвой", "Москве")
        "петербург", "санкт-петербург" -> CityDeclension("Санкт-Петербург", "Санкт-Петербурга", "Санкт-Петербургу", "Санкт-Петербург", "Санкт-Петербургом", "Санкт-Петербурге")
        "екатеринбург" -> CityDeclension("Екатеринбург", "Екатеринбурга", "Екатеринбургу", "Екатеринбург", "Екатеринбургом", "Екатеринбурге")
        "новосибирск" -> CityDeclension("Новосибирск", "Новосибирска", "Новосибирску", "Новосибирск", "Новосибирском", "Новосибирске")
        "казань" -> CityDeclension("Казань", "Казани", "Казани", "Казань", "Казанью", "Казани")

        // Общий случай для большинства городов (правило окончания -ов/-ев)
        else -> city.generalCityDeclension()
    }
}

private fun String.generalCityDeclension(): CityDeclension {
    val lowerCity = this.lowercase()
    val stem = if (lowerCity.endsWith("ск")) this.dropLast(2) else this

    return CityDeclension(
        nominative = this,
        genitive = "${stem}а",      // Москва → Москвы (но для общего: Екатеринбург → Екатеринбурга)
        dative = "${stem}у",
        accusative = this,        // одушевленные: кого? город (неодуш.)
        instrumental = "${stem}ом",
        prepositional = "${stem}е"
    )
}