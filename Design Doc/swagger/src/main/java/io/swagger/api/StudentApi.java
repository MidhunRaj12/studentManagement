/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Attendance;
import java.util.Map;
import io.swagger.model.Student;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T18:21:33.809Z")

@Api(value = "Student", description = "the Student API")
public interface StudentApi {

    @ApiOperation(value = "Get attendance details by Course ID", nickname = "courseId", notes = "Please provide the valid course", response = Attendance.class, tags={ "Student", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Attendance.class),
        @ApiResponse(code = 400, message = "Invalid Reg.num"),
        @ApiResponse(code = 404, message = "Reg number not found") })
    @RequestMapping(value = "/Student/attendance/{RegNo}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Attendance> courseId(@ApiParam(value = "Reg Number for which attendance needs to be fetched",required=true) @PathVariable("RegNo") Long regNo);


    @ApiOperation(value = "Get student details", nickname = "getInventory", notes = "Returns student details", response = Integer.class, responseContainer = "Map", authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "Student", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Map.class, responseContainer = "Map") })
    @RequestMapping(value = "/Student/details",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Map<String, Integer>> getInventory();


    @ApiOperation(value = "Get Course assigned", nickname = "placeOrder", notes = "", response = Student.class, tags={ "Student", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Student.class),
        @ApiResponse(code = 400, message = "Invalid Student") })
    @RequestMapping(value = "/Student/ViewCourse",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Student> placeOrder(@ApiParam(value = "Course assigned for student" ,required=true )  @Valid @RequestBody Student body);

}