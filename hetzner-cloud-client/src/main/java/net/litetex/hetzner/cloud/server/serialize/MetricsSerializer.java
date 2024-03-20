package net.litetex.hetzner.cloud.server.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class MetricsSerializer extends JsonSerializer<Object>
{
    @Override
    public void serialize(
        final Object object,
        final JsonGenerator jsonGenerator,
        final SerializerProvider serializerProvider)
        throws IOException
    {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField(jsonGenerator.getOutputContext().getCurrentName(), object);
        jsonGenerator.writeEndObject();
    }
}
