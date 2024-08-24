package cholwell.dev.kotlinx_datetime_misc

import kotlinx.datetime.LocalTime

/**
 * @return [LocalTime] of this Int as the hour in UTC
 */
fun Int.toUtcTime(): LocalTime = LocalTime(this, 0, 0, 0)

/**
 * @return [LocalTime] of this Int as the hour in UK
 */
fun Int.toUkTime(): LocalTime = LocalTime(this, 0, 0, 0)
