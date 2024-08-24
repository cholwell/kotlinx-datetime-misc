package cholwell.dev.kotlinx_datetime_misc

import kotlinx.datetime.TimeZone

/**
 * @return [TimeZone] of the UK
 */
val TimeZone.Companion.UK: TimeZone get() = of("Europe/London")
