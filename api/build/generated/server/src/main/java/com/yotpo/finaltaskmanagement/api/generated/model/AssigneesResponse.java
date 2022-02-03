package com.yotpo.finaltaskmanagement.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.yotpo.finaltaskmanagement.api.generated.model.AssigneeResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssigneesResponse
 */

public class AssigneesResponse   {
  @JsonProperty("assignees")
  @Valid
  private List<AssigneeResponse> assignees = null;

  public AssigneesResponse assignees(List<AssigneeResponse> assignees) {
    this.assignees = assignees;
    return this;
  }

  public AssigneesResponse addAssigneesItem(AssigneeResponse assigneesItem) {
    if (this.assignees == null) {
      this.assignees = new ArrayList<>();
    }
    this.assignees.add(assigneesItem);
    return this;
  }

  /**
   * Get assignees
   * @return assignees
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<AssigneeResponse> getAssignees() {
    return assignees;
  }

  public void setAssignees(List<AssigneeResponse> assignees) {
    this.assignees = assignees;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssigneesResponse assigneesResponse = (AssigneesResponse) o;
    return Objects.equals(this.assignees, assigneesResponse.assignees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignees);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssigneesResponse {\n");
    
    sb.append("    assignees: ").append(toIndentedString(assignees)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

