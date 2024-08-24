package cholwell.dev.kotlinx_datetime_misc

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.hours

/**
 * @return [LocalTime] at this [Instant] in UTC.
 */
fun Instant.toUtcTime(): LocalTime = toLocalDateTime(TimeZone.UTC).time

/**
 * @return [LocalTime] at this [Instant] in the UK.
 */
fun Instant.toUkTime(): LocalTime = toLocalDateTime(TimeZone.of("Europe/London")).time

/**
 * @return the second of the minute at this [Instant] in UTC.
 */
val Instant.secondUtc: Int
    get() = toLocalDateTime(TimeZone.UTC).second

/**
 * @return this [Instant] rounded to the nearest second in UTC.
 */
fun Instant.roundToSecondUtc(): Instant {
    val dateTime = toLocalDateTime(TimeZone.UTC)
    val dateTimeRounded = LocalDateTime(dateTime.year, dateTime.month, dateTime.dayOfMonth, dateTime.hour, dateTime.minute, dateTime.second, 0)
    return dateTimeRounded.toInstant(TimeZone.UTC)
}

/**
 * @return the minute of the hour at this [Instant] in UTC.
 */
val Instant.minuteUtc: Int
    get() = toLocalDateTime(TimeZone.UTC).minute

/**
 * @return this [Instant] rounded to the nearest minute in UTC.
 */
fun Instant.roundToMinuteUtc(): Instant {
    val dateTime = toLocalDateTime(TimeZone.UTC)
    val dateTimeRounded = LocalDateTime(dateTime.year, dateTime.month, dateTime.dayOfMonth, dateTime.hour, dateTime.minute, 0)
    return dateTimeRounded.toInstant(TimeZone.UTC)
}

/**
 * @return the hour of the day at this [Instant] in UTC.
 */
val Instant.hourUtc: Int
    get() = toLocalDateTime(TimeZone.UTC).hour

/**
 * @return this [Instant] rounded to the nearest hour in UTC.
 */
fun Instant.roundToHourUtc(): Instant {
    val dateTime = toLocalDateTime(TimeZone.UTC)
    val dateTimeRounded = LocalDateTime(dateTime.year, dateTime.month, dateTime.dayOfMonth, dateTime.hour, 0)
    return dateTimeRounded.toInstant(TimeZone.UTC)
}

/**
 * @return [List]<[Instant]> rounded to the hour between this [Instant] and another [Instant] in UTC.
 */
fun Instant.hoursBetweenUtc(other: Instant): List<Instant> {
    val first = this
    val last = other.roundToHourUtc()
    val hours = generateSequence(first) { prev ->
        if (prev == last) null else prev + 1.hours
    }
    return hours.toList()
}
