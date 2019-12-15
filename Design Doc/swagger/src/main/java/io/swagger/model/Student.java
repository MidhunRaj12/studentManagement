package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T18:21:33.809Z")

public class Student   {
  @JsonProperty("RegNo.")
  private Long regNo_ = null;

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("Course")
  private String course = null;

  public Student regNo_(Long regNo_) {
    this.regNo_ = regNo_;
    return this;
  }

  /**
   * Get regNo_
   * @return regNo_
  **/
  @ApiModelProperty(value = "")


  public Long getRegNo_() {
    return regNo_;
  }

  public void setRegNo_(Long regNo_) {
    this.regNo_ = regNo_;
  }

  public Student name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student course(String course) {
    this.course = course;
    return this;
  }

  /**
   * Course assigned
   * @return course
  **/
  @ApiModelProperty(value = "Course assigned")


  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.regNo_, student.regNo_) &&
        Objects.equals(this.name, student.name) &&
        Objects.equals(this.course, student.course);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regNo_, name, course);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    regNo_: ").append(toIndentedString(regNo_)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    course: ").append(toIndentedString(course)).append("\n");
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

