package com.yotpo.finaltaskmanagement.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.yotpo.finaltaskmanagement.api.generated.model.AssigneeRequestAssignee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssigneeRequest
 */

public class AssigneeRequest   {
  @JsonProperty("assignee")
  private AssigneeRequestAssignee assignee;

  public AssigneeRequest assignee(AssigneeRequestAssignee assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * Get assignee
   * @return assignee
  */
  @ApiModelProperty(value = "")

  @Valid

  public AssigneeRequestAssignee getAssignee() {
    return assignee;
  }

  public void setAssignee(AssigneeRequestAssignee assignee) {
    this.assignee = assignee;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssigneeRequest assigneeRequest = (AssigneeRequest) o;
    return Objects.equals(this.assignee, assigneeRequest.assignee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssigneeRequest {\n");
    
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
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

