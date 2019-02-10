package com.kurstestowania.mailchimpapispringboot.mailchimp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FNAME",
        "LNAME"
})
public class MergeFields {

    @JsonProperty("FNAME")
    private String fNAME;
    @JsonProperty("LNAME")
    private String lNAME;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FNAME")
    public String getFNAME() {
        return fNAME;
    }

    @JsonProperty("FNAME")
    public void setFNAME(String fNAME) {
        this.fNAME = fNAME;
    }

    @JsonProperty("LNAME")
    public String getLNAME() {
        return lNAME;
    }

    @JsonProperty("LNAME")
    public void setLNAME(String lNAME) {
        this.lNAME = lNAME;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}