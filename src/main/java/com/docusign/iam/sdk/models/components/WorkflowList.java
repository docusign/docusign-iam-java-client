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
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * WorkflowList
 * 
 * <p>A list of workflows
 */
public class WorkflowList {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("workflows")
    private Optional<? extends List<Workflow>> workflows;

    @JsonCreator
    public WorkflowList(
            @JsonProperty("workflows") Optional<? extends List<Workflow>> workflows) {
        Utils.checkNotNull(workflows, "workflows");
        this.workflows = workflows;
    }
    
    public WorkflowList() {
        this(Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Workflow>> workflows() {
        return (Optional<List<Workflow>>) workflows;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public WorkflowList withWorkflows(List<Workflow> workflows) {
        Utils.checkNotNull(workflows, "workflows");
        this.workflows = Optional.ofNullable(workflows);
        return this;
    }

    public WorkflowList withWorkflows(Optional<? extends List<Workflow>> workflows) {
        Utils.checkNotNull(workflows, "workflows");
        this.workflows = workflows;
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
        WorkflowList other = (WorkflowList) o;
        return 
            Objects.deepEquals(this.workflows, other.workflows);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            workflows);
    }
    
    @Override
    public String toString() {
        return Utils.toString(WorkflowList.class,
                "workflows", workflows);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<Workflow>> workflows = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder workflows(List<Workflow> workflows) {
            Utils.checkNotNull(workflows, "workflows");
            this.workflows = Optional.ofNullable(workflows);
            return this;
        }

        public Builder workflows(Optional<? extends List<Workflow>> workflows) {
            Utils.checkNotNull(workflows, "workflows");
            this.workflows = workflows;
            return this;
        }
        
        public WorkflowList build() {
            return new WorkflowList(
                workflows);
        }
    }
}
