/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.docusign.iam.sdk.models.components;

import com.docusign.iam.sdk.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

public class ResourceMetadata {

    /**
     * Timestamp when the agreement document was created.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_at")
    private JsonNullable<OffsetDateTime> createdAt;

    /**
     * User ID of the person who created the agreement document.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_by")
    private JsonNullable<String> createdBy;

    /**
     * Timestamp when the agreement document was last modified.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("modified_at")
    private JsonNullable<OffsetDateTime> modifiedAt;

    /**
     * User ID of the person who last modified the agreement document.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("modified_by")
    private JsonNullable<String> modifiedBy;

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("request_id")
    private JsonNullable<String> requestId;

    /**
     * The timestamp indicating when the response was generated.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("response_timestamp")
    private JsonNullable<OffsetDateTime> responseTimestamp;

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("response_duration_ms")
    private JsonNullable<Integer> responseDurationMs;

    @JsonCreator
    public ResourceMetadata(
            @JsonProperty("created_at") JsonNullable<OffsetDateTime> createdAt,
            @JsonProperty("created_by") JsonNullable<String> createdBy,
            @JsonProperty("modified_at") JsonNullable<OffsetDateTime> modifiedAt,
            @JsonProperty("modified_by") JsonNullable<String> modifiedBy,
            @JsonProperty("request_id") JsonNullable<String> requestId,
            @JsonProperty("response_timestamp") JsonNullable<OffsetDateTime> responseTimestamp,
            @JsonProperty("response_duration_ms") JsonNullable<Integer> responseDurationMs) {
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(createdBy, "createdBy");
        Utils.checkNotNull(modifiedAt, "modifiedAt");
        Utils.checkNotNull(modifiedBy, "modifiedBy");
        Utils.checkNotNull(requestId, "requestId");
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        Utils.checkNotNull(responseDurationMs, "responseDurationMs");
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
        this.requestId = requestId;
        this.responseTimestamp = responseTimestamp;
        this.responseDurationMs = responseDurationMs;
    }
    
    public ResourceMetadata() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Timestamp when the agreement document was created.
     */
    @JsonIgnore
    public JsonNullable<OffsetDateTime> createdAt() {
        return createdAt;
    }

    /**
     * User ID of the person who created the agreement document.
     */
    @JsonIgnore
    public JsonNullable<String> createdBy() {
        return createdBy;
    }

    /**
     * Timestamp when the agreement document was last modified.
     */
    @JsonIgnore
    public JsonNullable<OffsetDateTime> modifiedAt() {
        return modifiedAt;
    }

    /**
     * User ID of the person who last modified the agreement document.
     */
    @JsonIgnore
    public JsonNullable<String> modifiedBy() {
        return modifiedBy;
    }

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    @JsonIgnore
    public JsonNullable<String> requestId() {
        return requestId;
    }

    /**
     * The timestamp indicating when the response was generated.
     */
    @JsonIgnore
    public JsonNullable<OffsetDateTime> responseTimestamp() {
        return responseTimestamp;
    }

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    @JsonIgnore
    public JsonNullable<Integer> responseDurationMs() {
        return responseDurationMs;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Timestamp when the agreement document was created.
     */
    public ResourceMetadata withCreatedAt(OffsetDateTime createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = JsonNullable.of(createdAt);
        return this;
    }

    /**
     * Timestamp when the agreement document was created.
     */
    public ResourceMetadata withCreatedAt(JsonNullable<OffsetDateTime> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * User ID of the person who created the agreement document.
     */
    public ResourceMetadata withCreatedBy(String createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = JsonNullable.of(createdBy);
        return this;
    }

    /**
     * User ID of the person who created the agreement document.
     */
    public ResourceMetadata withCreatedBy(JsonNullable<String> createdBy) {
        Utils.checkNotNull(createdBy, "createdBy");
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Timestamp when the agreement document was last modified.
     */
    public ResourceMetadata withModifiedAt(OffsetDateTime modifiedAt) {
        Utils.checkNotNull(modifiedAt, "modifiedAt");
        this.modifiedAt = JsonNullable.of(modifiedAt);
        return this;
    }

    /**
     * Timestamp when the agreement document was last modified.
     */
    public ResourceMetadata withModifiedAt(JsonNullable<OffsetDateTime> modifiedAt) {
        Utils.checkNotNull(modifiedAt, "modifiedAt");
        this.modifiedAt = modifiedAt;
        return this;
    }

    /**
     * User ID of the person who last modified the agreement document.
     */
    public ResourceMetadata withModifiedBy(String modifiedBy) {
        Utils.checkNotNull(modifiedBy, "modifiedBy");
        this.modifiedBy = JsonNullable.of(modifiedBy);
        return this;
    }

    /**
     * User ID of the person who last modified the agreement document.
     */
    public ResourceMetadata withModifiedBy(JsonNullable<String> modifiedBy) {
        Utils.checkNotNull(modifiedBy, "modifiedBy");
        this.modifiedBy = modifiedBy;
        return this;
    }

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    public ResourceMetadata withRequestId(String requestId) {
        Utils.checkNotNull(requestId, "requestId");
        this.requestId = JsonNullable.of(requestId);
        return this;
    }

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    public ResourceMetadata withRequestId(JsonNullable<String> requestId) {
        Utils.checkNotNull(requestId, "requestId");
        this.requestId = requestId;
        return this;
    }

    /**
     * The timestamp indicating when the response was generated.
     */
    public ResourceMetadata withResponseTimestamp(OffsetDateTime responseTimestamp) {
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        this.responseTimestamp = JsonNullable.of(responseTimestamp);
        return this;
    }

    /**
     * The timestamp indicating when the response was generated.
     */
    public ResourceMetadata withResponseTimestamp(JsonNullable<OffsetDateTime> responseTimestamp) {
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        this.responseTimestamp = responseTimestamp;
        return this;
    }

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    public ResourceMetadata withResponseDurationMs(int responseDurationMs) {
        Utils.checkNotNull(responseDurationMs, "responseDurationMs");
        this.responseDurationMs = JsonNullable.of(responseDurationMs);
        return this;
    }

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    public ResourceMetadata withResponseDurationMs(JsonNullable<Integer> responseDurationMs) {
        Utils.checkNotNull(responseDurationMs, "responseDurationMs");
        this.responseDurationMs = responseDurationMs;
        return this;
    }

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResourceMetadata other = (ResourceMetadata) o;
        return 
            Objects.deepEquals(this.createdAt, other.createdAt) &&
            Objects.deepEquals(this.createdBy, other.createdBy) &&
            Objects.deepEquals(this.modifiedAt, other.modifiedAt) &&
            Objects.deepEquals(this.modifiedBy, other.modifiedBy) &&
            Objects.deepEquals(this.requestId, other.requestId) &&
            Objects.deepEquals(this.responseTimestamp, other.responseTimestamp) &&
            Objects.deepEquals(this.responseDurationMs, other.responseDurationMs);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            createdAt,
            createdBy,
            modifiedAt,
            modifiedBy,
            requestId,
            responseTimestamp,
            responseDurationMs);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ResourceMetadata.class,
                "createdAt", createdAt,
                "createdBy", createdBy,
                "modifiedAt", modifiedAt,
                "modifiedBy", modifiedBy,
                "requestId", requestId,
                "responseTimestamp", responseTimestamp,
                "responseDurationMs", responseDurationMs);
    }
    
    public final static class Builder {
 
        private JsonNullable<OffsetDateTime> createdAt = JsonNullable.undefined();
 
        private JsonNullable<String> createdBy = JsonNullable.undefined();
 
        private JsonNullable<OffsetDateTime> modifiedAt = JsonNullable.undefined();
 
        private JsonNullable<String> modifiedBy = JsonNullable.undefined();
 
        private JsonNullable<String> requestId = JsonNullable.undefined();
 
        private JsonNullable<OffsetDateTime> responseTimestamp = JsonNullable.undefined();
 
        private JsonNullable<Integer> responseDurationMs = JsonNullable.undefined();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Timestamp when the agreement document was created.
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = JsonNullable.of(createdAt);
            return this;
        }

        /**
         * Timestamp when the agreement document was created.
         */
        public Builder createdAt(JsonNullable<OffsetDateTime> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }

        /**
         * User ID of the person who created the agreement document.
         */
        public Builder createdBy(String createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = JsonNullable.of(createdBy);
            return this;
        }

        /**
         * User ID of the person who created the agreement document.
         */
        public Builder createdBy(JsonNullable<String> createdBy) {
            Utils.checkNotNull(createdBy, "createdBy");
            this.createdBy = createdBy;
            return this;
        }

        /**
         * Timestamp when the agreement document was last modified.
         */
        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            Utils.checkNotNull(modifiedAt, "modifiedAt");
            this.modifiedAt = JsonNullable.of(modifiedAt);
            return this;
        }

        /**
         * Timestamp when the agreement document was last modified.
         */
        public Builder modifiedAt(JsonNullable<OffsetDateTime> modifiedAt) {
            Utils.checkNotNull(modifiedAt, "modifiedAt");
            this.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * User ID of the person who last modified the agreement document.
         */
        public Builder modifiedBy(String modifiedBy) {
            Utils.checkNotNull(modifiedBy, "modifiedBy");
            this.modifiedBy = JsonNullable.of(modifiedBy);
            return this;
        }

        /**
         * User ID of the person who last modified the agreement document.
         */
        public Builder modifiedBy(JsonNullable<String> modifiedBy) {
            Utils.checkNotNull(modifiedBy, "modifiedBy");
            this.modifiedBy = modifiedBy;
            return this;
        }

        /**
         * Unique identifier for the request, useful for tracking and debugging.
         */
        public Builder requestId(String requestId) {
            Utils.checkNotNull(requestId, "requestId");
            this.requestId = JsonNullable.of(requestId);
            return this;
        }

        /**
         * Unique identifier for the request, useful for tracking and debugging.
         */
        public Builder requestId(JsonNullable<String> requestId) {
            Utils.checkNotNull(requestId, "requestId");
            this.requestId = requestId;
            return this;
        }

        /**
         * The timestamp indicating when the response was generated.
         */
        public Builder responseTimestamp(OffsetDateTime responseTimestamp) {
            Utils.checkNotNull(responseTimestamp, "responseTimestamp");
            this.responseTimestamp = JsonNullable.of(responseTimestamp);
            return this;
        }

        /**
         * The timestamp indicating when the response was generated.
         */
        public Builder responseTimestamp(JsonNullable<OffsetDateTime> responseTimestamp) {
            Utils.checkNotNull(responseTimestamp, "responseTimestamp");
            this.responseTimestamp = responseTimestamp;
            return this;
        }

        /**
         * The duration of time, in milliseconds, that the server took to process and respond 
         * to the request. This is measured from the time the server received the request 
         * until the time the response was sent.
         */
        public Builder responseDurationMs(int responseDurationMs) {
            Utils.checkNotNull(responseDurationMs, "responseDurationMs");
            this.responseDurationMs = JsonNullable.of(responseDurationMs);
            return this;
        }

        /**
         * The duration of time, in milliseconds, that the server took to process and respond 
         * to the request. This is measured from the time the server received the request 
         * until the time the response was sent.
         */
        public Builder responseDurationMs(JsonNullable<Integer> responseDurationMs) {
            Utils.checkNotNull(responseDurationMs, "responseDurationMs");
            this.responseDurationMs = responseDurationMs;
            return this;
        }
        
        public ResourceMetadata build() {
            return new ResourceMetadata(
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy,
                requestId,
                responseTimestamp,
                responseDurationMs);
        }
    }
}
