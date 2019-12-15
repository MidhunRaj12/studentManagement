package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Schedule
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T18:21:33.809Z")

public class Schedule   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("list")
  private LocalDate list = null;

  public Schedule name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Course
   * @return name
  **/
  @ApiModelProperty(value = "Course")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Schedule list(LocalDate list) {
    this.list = list;
    return this;
  }

  /**
   * dates
   * @return list
  **/
  @ApiModelProperty(value = "dates")

  @Valid

  public LocalDate getList() {
    return list;
  }

  public void setList(LocalDate list) {
    this.list = list;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Schedule schedule = (Schedule) o;
    return Objects.equals(this.name, schedule.name) &&
        Objects.equals(this.list, schedule.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Schedule {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
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

