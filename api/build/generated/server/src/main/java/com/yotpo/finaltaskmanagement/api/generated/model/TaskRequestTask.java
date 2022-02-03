package com.yotpo.finaltaskmanagement.api.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.yotpo.finaltaskmanagement.api.generated.model.AssigneeRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TaskRequestTask
 */

public class TaskRequestTask   {
  @JsonProperty("title")
  private String title;

  @JsonProperty("due_date")
  private LocalDate dueDate;

  @JsonProperty("status")
  private String status;

  @JsonProperty("assignee")
  private AssigneeRequest assignee;

  public TaskRequestTask title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskRequestTask dueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  /**
   * Get dueDate
   * @return dueDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public TaskRequestTask status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public TaskRequestTask assignee(AssigneeRequest assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * Get assignee
   * @return assignee
  */
  @ApiModelProperty(value = "")

  @Valid

  public AssigneeRequest getAssignee() {
    return assignee;
  }

  public void setAssignee(AssigneeRequest assignee) {
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
    TaskRequestTask taskRequestTask = (TaskRequestTask) o;
    return Objects.equals(this.title, taskRequestTask.title) &&
        Objects.equals(this.dueDate, taskRequestTask.dueDate) &&
        Objects.equals(this.status, taskRequestTask.status) &&
        Objects.equals(this.assignee, taskRequestTask.assignee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, dueDate, status, assignee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskRequestTask {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

