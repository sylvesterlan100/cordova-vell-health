package org.apache.cordova.health;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.records.metadata.Metadata;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.time.TimeRangeFilter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import kotlin.reflect.KClass;

public class VO2MaxFunctions {
    public static KClass<? extends Record> dataTypeToClass() {
        return kotlin.jvm.JvmClassMappingKt.getKotlinClass(Vo2MaxRecord.class);
    }

    public static void populateFromQuery(Record datapoint, JSONObject obj) throws JSONException {
        Vo2MaxRecord voDP = (Vo2MaxRecord) datapoint;
        obj.put("startDate", voDP.getTime().toEpochMilli());
        obj.put("endDate",  voDP.getTime().toEpochMilli());

        double vo = voDP.getVo2MillilitersPerMinuteKilogram();
        obj.put("value", vo);
        obj.put("unit", "ml/kg/min");
        
    }

    // public static void prepareStoreRecords(JSONObject storeObj, long st, long et, List<Record> data) throws JSONException {
    //     long bt = storeObj.getLong("value");
    //     // TODO: we could add meta data when storing, including entry method, client ID and device
    //     BodyTemperatureRecord record = new BodyTemperatureRecord(
    //             Instant.ofEpochMilli(st), null,
    //             Instant.ofEpochMilli(et), null,
    //             bt,
    //             Metadata.EMPTY
    //     );
    //     data.add(record);
    // }
}
