package org.jetbrains.kotlinconf

import io.ktor.util.date.*
import org.jetbrains.kotlinconf.utils.*

data class SessionCardView(
    val id: SessionId,
    val title: String,
    val speakerLine: String,
    val locationLine: String,
    val startsAt: GMTDate,
    val endsAt: GMTDate,
    val isLive: Boolean,
    val speakerIds: List<SpeakerId>,
    val vote: Score?,
    val timeLine: String = buildString {
        append(startsAt.dayAndMonth())
        append(", ")
        append(startsAt.time())
        append("-")
        append(endsAt.time())
    },
    val isFavorite: Boolean,
    val isFinished: Boolean,
    val isUpcoming: Boolean,
    val description: String,
    val tags: List<String>,
    val badgeTimeLine: String = buildString {
        append(startsAt.time())
        append("-")
        append(endsAt.time())
    },
    val isLightning: Boolean = endsAt.timestamp - startsAt.timestamp <= 15 * 60 * 1000,
    val startsInMinutes: Int?,
)

val Session.isLightning: Boolean get() = endsAt.timestamp - startsAt.timestamp <= 15 * 60 * 1000
