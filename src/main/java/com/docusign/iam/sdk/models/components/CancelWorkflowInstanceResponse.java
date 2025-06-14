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
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public class CancelWorkflowInstanceResponse {

    /**
     * A message confirming the instance was canceled, including the instance and workflow IDs
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("message")
    private Optional<String> message;

    @JsonCreator
    public CancelWorkflowInstanceResponse(
            @JsonProperty("message") Optional<String> message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
    }
    
    public CancelWorkflowInstanceResponse() {
        this(Optional.empty());
    }

    /**
     * A message confirming the instance was canceled, including the instance and workflow IDs
     */
    @JsonIgnore
    public Optional<String> message() {
        return message;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * A message confirming the instance was canceled, including the instance and workflow IDs
     */
    public CancelWorkflowInstanceResponse withMessage(String message) {
        Utils.checkNotNull(message, "message");
        this.message = Optional.ofNullable(message);
        return this;
    }

    /**
     * A message confirming the instance was canceled, including the instance and workflow IDs
     */
    public CancelWorkflowInstanceResponse withMessage(Optional<String> message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
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
        CancelWorkflowInstanceResponse other = (CancelWorkflowInstanceResponse) o;
        return 
            Objects.deepEquals(this.message, other.message);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            message);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CancelWorkflowInstanceResponse.class,
                "message", message);
    }
    
    public final static class Builder {
 
        private Optional<String> message = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * A message confirming the instance was canceled, including the instance and workflow IDs
         */
        public Builder message(String message) {
            Utils.checkNotNull(message, "message");
            this.message = Optional.ofNullable(message);
            return this;
        }

        /**
         * A message confirming the instance was canceled, including the instance and workflow IDs
         */
        public Builder message(Optional<String> message) {
            Utils.checkNotNull(message, "message");
            this.message = message;
            return this;
        }
        
        public CancelWorkflowInstanceResponse build() {
            return new CancelWorkflowInstanceResponse(
                message);
        }
    }
}
