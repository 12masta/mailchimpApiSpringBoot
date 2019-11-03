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
        "email_address",
        "status",
        "merge_fields"
})
public class Subscribe {

    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("status")
    private String status;
    @JsonProperty("merge_fields")
    private MergeFields mergeFields;
    @JsonProperty("tags")
    private String[] tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("merge_fields")
    public MergeFields getMergeFields() {
        return mergeFields;
    }

    @JsonProperty("merge_fields")
    public void setMergeFields(MergeFields mergeFields) {
        this.mergeFields = mergeFields;
    }

    @JsonProperty("tags")
    public String[] getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String[] tags) {
        this.tags = tags;
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