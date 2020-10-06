package com.rbkmoney.threeds.server.domain.device;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.domain.sdk.SdkInterface;
import com.rbkmoney.threeds.server.domain.sdk.SdkUiType;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.ListWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.SdkInterfaceDeserializer;
import com.rbkmoney.threeds.server.serialization.deserializer.SdkUiTypeDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.SdkInterfaceSerializer;
import com.rbkmoney.threeds.server.serialization.serializer.SdkUiTypeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class DeviceRenderOptionsWrapper {

    @JsonProperty("sdkInterface")
    @JsonDeserialize(using = SdkInterfaceDeserializer.class)
    @JsonSerialize(using = SdkInterfaceSerializer.class)
    private EnumWrapper<SdkInterface> sdkInterface;
    @JsonProperty("sdkUiType")
    @JsonDeserialize(using = SdkUiTypeDeserializer.class)
    @JsonSerialize(using = SdkUiTypeSerializer.class)
    private ListWrapper<EnumWrapper<SdkUiType>> sdkUiType;

}
