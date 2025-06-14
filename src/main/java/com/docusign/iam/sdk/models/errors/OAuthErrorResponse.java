/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.docusign.iam.sdk.models.errors;

import com.docusign.iam.sdk.utils.Utils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

@SuppressWarnings("serial")
public class OAuthErrorResponse extends RuntimeException {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("error")
    private JsonNullable<String> error;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("error_description")
    private JsonNullable<String> errorDescription;

    @JsonCreator
    public OAuthErrorResponse(
            @JsonProperty("error") JsonNullable<String> error,
            @JsonProperty("error_description") JsonNullable<String> errorDescription) {
        Utils.checkNotNull(error, "error");
        Utils.checkNotNull(errorDescription, "errorDescription");
        this.error = error;
        this.errorDescription = errorDescription;
    }
    
    public OAuthErrorResponse() {
        this(JsonNullable.undefined(), JsonNullable.undefined());
    }

    @JsonIgnore
    public JsonNullable<String> error() {
        return error;
    }

    @JsonIgnore
    public JsonNullable<String> errorDescription() {
        return errorDescription;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public OAuthErrorResponse withError(String error) {
        Utils.checkNotNull(error, "error");
        this.error = JsonNullable.of(error);
        return this;
    }

    public OAuthErrorResponse withError(JsonNullable<String> error) {
        Utils.checkNotNull(error, "error");
        this.error = error;
        return this;
    }

    public OAuthErrorResponse withErrorDescription(String errorDescription) {
        Utils.checkNotNull(errorDescription, "errorDescription");
        this.errorDescription = JsonNullable.of(errorDescription);
        return this;
    }

    public OAuthErrorResponse withErrorDescription(JsonNullable<String> errorDescription) {
        Utils.checkNotNull(errorDescription, "errorDescription");
        this.errorDescription = errorDescription;
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
        OAuthErrorResponse other = (OAuthErrorResponse) o;
        return 
            Objects.deepEquals(this.error, other.error) &&
            Objects.deepEquals(this.errorDescription, other.errorDescription);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            error,
            errorDescription);
    }
    
    @Override
    public String toString() {
        return Utils.toString(OAuthErrorResponse.class,
                "error", error,
                "errorDescription", errorDescription);
    }
    
    public final static class Builder {
 
        private JsonNullable<String> error = JsonNullable.undefined();
 
        private JsonNullable<String> errorDescription = JsonNullable.undefined();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder error(String error) {
            Utils.checkNotNull(error, "error");
            this.error = JsonNullable.of(error);
            return this;
        }

        public Builder error(JsonNullable<String> error) {
            Utils.checkNotNull(error, "error");
            this.error = error;
            return this;
        }

        public Builder errorDescription(String errorDescription) {
            Utils.checkNotNull(errorDescription, "errorDescription");
            this.errorDescription = JsonNullable.of(errorDescription);
            return this;
        }

        public Builder errorDescription(JsonNullable<String> errorDescription) {
            Utils.checkNotNull(errorDescription, "errorDescription");
            this.errorDescription = errorDescription;
            return this;
        }
        
        public OAuthErrorResponse build() {
            return new OAuthErrorResponse(
                error,
                errorDescription);
        }
    }
}

