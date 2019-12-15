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
 * Attendance
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T18:21:33.809Z")

public class Attendance   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("course")
  private String course = null;

  @JsonProperty("day")
  private LocalDate day = null;

  @JsonProperty("status")
  private Boolean status = null;

  public Attendance id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Attendance course(String course) {
    this.course = course;
    return this;
  }

  /**
   * Get course
   * @return course
  **/
  @ApiModelProperty(value = "")


  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public Attendance day(LocalDate day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDate getDay() {
    return day;
  }

  public void setDay(LocalDate day) {
    this.day = day;
  }

  public Attendance status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * Attendance Y/N
   * @return status
  **/
  @ApiModelProperty(value = "Attendance Y/N")


  public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attendance attendance = (Attendance) o;
    return Objects.equals(this.id, attendance.id) &&
        Objects.equals(this.course, attendance.course) &&
        Objects.equals(this.day, attendance.day) &&
        Objects.equals(this.status, attendance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, course, day, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attendance {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    course: ").append(toIndentedString(course)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

