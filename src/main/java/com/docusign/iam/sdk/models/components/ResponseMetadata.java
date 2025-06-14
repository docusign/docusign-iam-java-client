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

/**
 * ResponseMetadata
 * 
 * <p>Control information and metadata for the response.
 */
public class ResponseMetadata {

    /**
     * The maximum number of items that can be returned in a single page.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("page_limit")
    private JsonNullable<Integer> pageLimit;

    /**
     * The continuation token used to retrieve a page in a paginated response.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("page_token_next")
    private JsonNullable<String> pageTokenNext;

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
    public ResponseMetadata(
            @JsonProperty("page_limit") JsonNullable<Integer> pageLimit,
            @JsonProperty("page_token_next") JsonNullable<String> pageTokenNext,
            @JsonProperty("request_id") JsonNullable<String> requestId,
            @JsonProperty("response_timestamp") JsonNullable<OffsetDateTime> responseTimestamp,
            @JsonProperty("response_duration_ms") JsonNullable<Integer> responseDurationMs) {
        Utils.checkNotNull(pageLimit, "pageLimit");
        Utils.checkNotNull(pageTokenNext, "pageTokenNext");
        Utils.checkNotNull(requestId, "requestId");
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        Utils.checkNotNull(responseDurationMs, "responseDurationMs");
        this.pageLimit = pageLimit;
        this.pageTokenNext = pageTokenNext;
        this.requestId = requestId;
        this.responseTimestamp = responseTimestamp;
        this.responseDurationMs = responseDurationMs;
    }
    
    public ResponseMetadata() {
        this(JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The maximum number of items that can be returned in a single page.
     */
    @JsonIgnore
    public JsonNullable<Integer> pageLimit() {
        return pageLimit;
    }

    /**
     * The continuation token used to retrieve a page in a paginated response.
     */
    @JsonIgnore
    public JsonNullable<String> pageTokenNext() {
        return pageTokenNext;
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
     * The maximum number of items that can be returned in a single page.
     */
    public ResponseMetadata withPageLimit(int pageLimit) {
        Utils.checkNotNull(pageLimit, "pageLimit");
        this.pageLimit = JsonNullable.of(pageLimit);
        return this;
    }

    /**
     * The maximum number of items that can be returned in a single page.
     */
    public ResponseMetadata withPageLimit(JsonNullable<Integer> pageLimit) {
        Utils.checkNotNull(pageLimit, "pageLimit");
        this.pageLimit = pageLimit;
        return this;
    }

    /**
     * The continuation token used to retrieve a page in a paginated response.
     */
    public ResponseMetadata withPageTokenNext(String pageTokenNext) {
        Utils.checkNotNull(pageTokenNext, "pageTokenNext");
        this.pageTokenNext = JsonNullable.of(pageTokenNext);
        return this;
    }

    /**
     * The continuation token used to retrieve a page in a paginated response.
     */
    public ResponseMetadata withPageTokenNext(JsonNullable<String> pageTokenNext) {
        Utils.checkNotNull(pageTokenNext, "pageTokenNext");
        this.pageTokenNext = pageTokenNext;
        return this;
    }

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    public ResponseMetadata withRequestId(String requestId) {
        Utils.checkNotNull(requestId, "requestId");
        this.requestId = JsonNullable.of(requestId);
        return this;
    }

    /**
     * Unique identifier for the request, useful for tracking and debugging.
     */
    public ResponseMetadata withRequestId(JsonNullable<String> requestId) {
        Utils.checkNotNull(requestId, "requestId");
        this.requestId = requestId;
        return this;
    }

    /**
     * The timestamp indicating when the response was generated.
     */
    public ResponseMetadata withResponseTimestamp(OffsetDateTime responseTimestamp) {
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        this.responseTimestamp = JsonNullable.of(responseTimestamp);
        return this;
    }

    /**
     * The timestamp indicating when the response was generated.
     */
    public ResponseMetadata withResponseTimestamp(JsonNullable<OffsetDateTime> responseTimestamp) {
        Utils.checkNotNull(responseTimestamp, "responseTimestamp");
        this.responseTimestamp = responseTimestamp;
        return this;
    }

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    public ResponseMetadata withResponseDurationMs(int responseDurationMs) {
        Utils.checkNotNull(responseDurationMs, "responseDurationMs");
        this.responseDurationMs = JsonNullable.of(responseDurationMs);
        return this;
    }

    /**
     * The duration of time, in milliseconds, that the server took to process and respond 
     * to the request. This is measured from the time the server received the request 
     * until the time the response was sent.
     */
    public ResponseMetadata withResponseDurationMs(JsonNullable<Integer> responseDurationMs) {
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
        ResponseMetadata other = (ResponseMetadata) o;
        return 
            Objects.deepEquals(this.pageLimit, other.pageLimit) &&
            Objects.deepEquals(this.pageTokenNext, other.pageTokenNext) &&
            Objects.deepEquals(this.requestId, other.requestId) &&
            Objects.deepEquals(this.responseTimestamp, other.responseTimestamp) &&
            Objects.deepEquals(this.responseDurationMs, other.responseDurationMs);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            pageLimit,
            pageTokenNext,
            requestId,
            responseTimestamp,
            responseDurationMs);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ResponseMetadata.class,
                "pageLimit", pageLimit,
                "pageTokenNext", pageTokenNext,
                "requestId", requestId,
                "responseTimestamp", responseTimestamp,
                "responseDurationMs", responseDurationMs);
    }
    
    public final static class Builder {
 
        private JsonNullable<Integer> pageLimit = JsonNullable.undefined();
 
        private JsonNullable<String> pageTokenNext = JsonNullable.undefined();
 
        private JsonNullable<String> requestId = JsonNullable.undefined();
 
        private JsonNullable<OffsetDateTime> responseTimestamp = JsonNullable.undefined();
 
        private JsonNullable<Integer> responseDurationMs = JsonNullable.undefined();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The maximum number of items that can be returned in a single page.
         */
        public Builder pageLimit(int pageLimit) {
            Utils.checkNotNull(pageLimit, "pageLimit");
            this.pageLimit = JsonNullable.of(pageLimit);
            return this;
        }

        /**
         * The maximum number of items that can be returned in a single page.
         */
        public Builder pageLimit(JsonNullable<Integer> pageLimit) {
            Utils.checkNotNull(pageLimit, "pageLimit");
            this.pageLimit = pageLimit;
            return this;
        }

        /**
         * The continuation token used to retrieve a page in a paginated response.
         */
        public Builder pageTokenNext(String pageTokenNext) {
            Utils.checkNotNull(pageTokenNext, "pageTokenNext");
            this.pageTokenNext = JsonNullable.of(pageTokenNext);
            return this;
        }

        /**
         * The continuation token used to retrieve a page in a paginated response.
         */
        public Builder pageTokenNext(JsonNullable<String> pageTokenNext) {
            Utils.checkNotNull(pageTokenNext, "pageTokenNext");
            this.pageTokenNext = pageTokenNext;
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
        
        public ResponseMetadata build() {
            return new ResponseMetadata(
                pageLimit,
                pageTokenNext,
                requestId,
                responseTimestamp,
                responseDurationMs);
        }
    }
}
