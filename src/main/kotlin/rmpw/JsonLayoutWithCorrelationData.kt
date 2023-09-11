package rmpw

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.contrib.json.classic.JsonLayout

class JsonLayoutWithCorrelationData : JsonLayout() {
    override fun addCustomDataToJsonMap(map: MutableMap<String, Any>, event: ILoggingEvent) {
        val mdc = map["mdc"] as MutableMap<String, String>?
        val correlation = mapOf<String, String?>(
            "request_id" to mdc?.get("correlation.request_id"),
            "user_id" to mdc?.get("correlation.user_id")
        ).filter { it.value != null }.takeUnless { it.isEmpty() }

        if (correlation != null) {
            map["correlation"] = correlation
        }
    }
}
