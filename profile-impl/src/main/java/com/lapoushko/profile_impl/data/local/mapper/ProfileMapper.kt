package com.lapoushko.profile_impl.data.local.mapper

import com.lapoushko.database.dto.ProfileDto
import com.lapoushko.profile_impl.domain.model.Profile

/**
 * @author Lapoushko
 */
internal fun ProfileDto.toDomain() = Profile(
    name = name,
    whoAreYou = Profile.WhoAreYou.valueOf(whoAreYou),
    jobTitle = Profile.JobTitle.valueOf(jobTitle),
    speciality = Profile.Speciality.valueOf(speciality)
)

internal fun Profile.toDto() = ProfileDto(
    name = name,
    whoAreYou = whoAreYou.name,
    jobTitle = jobTitle.name,
    speciality = speciality.name
)