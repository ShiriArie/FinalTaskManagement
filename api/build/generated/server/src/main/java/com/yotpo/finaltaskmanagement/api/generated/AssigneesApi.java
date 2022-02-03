/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.yotpo.finaltaskmanagement.api.generated;

import com.yotpo.finaltaskmanagement.api.generated.model.AssigneeRequest;
import com.yotpo.finaltaskmanagement.api.generated.model.AssigneeResponse;
import com.yotpo.finaltaskmanagement.api.generated.model.AssigneesResponse;
import com.yotpo.finaltaskmanagement.api.generated.model.TasksResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "Assignees", description = "the Assignees API")
public interface AssigneesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Create a new assignee", nickname = "create", notes = "", response = AssigneeResponse.class, authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The create assignee", response = AssigneeResponse.class) })
    @RequestMapping(value = "/assignees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<AssigneeResponse> create(@ApiParam(value = "" ,required=true )  @Valid @RequestBody AssigneeRequest assigneeRequest) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Delete assignee by id", nickname = "delete", notes = "", authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The assignee was deleted"),
        @ApiResponse(code = 404, message = "Not found") })
    @RequestMapping(value = "/assignees/{assignee_id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> delete(@ApiParam(value = "The assignee id",required=true) @PathVariable("assignee_id") Long assigneeId) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Get assignee by internal id", nickname = "findById", notes = "", response = AssigneeResponse.class, authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Assignee", response = AssigneeResponse.class),
        @ApiResponse(code = 400, message = "The request contains illegal argument/s"),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 404, message = "Assignee was not found") })
    @RequestMapping(value = "/assignees/{assignee_id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<AssigneeResponse> findById(@ApiParam(value = "The assignee id",required=true) @PathVariable("assignee_id") Long assigneeId) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Get all assignee's tasks by id", nickname = "getAllTasks", notes = "", response = TasksResponse.class, authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The requested tasks of assignee", response = TasksResponse.class),
        @ApiResponse(code = 400, message = "The request contains illegal argument/s"),
        @ApiResponse(code = 401, message = "Access token is missing or invalid"),
        @ApiResponse(code = 404, message = "Not found") })
    @RequestMapping(value = "/assigneeTasks/{assignee_id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<TasksResponse> getAllTasks(@ApiParam(value = "The assignee id",required=true) @PathVariable("assignee_id") Long assigneeId) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"tasks\" : [ { \"task\" : { \"due_date\" : \"2000-01-23\", \"task_id\" : 0, \"assignee\" : { \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }, \"title\" : \"title\", \"status\" : \"status\" } }, { \"task\" : { \"due_date\" : \"2000-01-23\", \"task_id\" : 0, \"assignee\" : { \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }, \"title\" : \"title\", \"status\" : \"status\" } } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Get all assignees", nickname = "index", notes = "", response = AssigneesResponse.class, authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The requested assignee", response = AssigneesResponse.class),
        @ApiResponse(code = 404, message = "Not found") })
    @RequestMapping(value = "/assignees",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<AssigneesResponse> index() throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assignees\" : [ { \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }, { \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Updating existing assignee", nickname = "update", notes = "", response = AssigneeResponse.class, authorizations = {
        @Authorization(value = "bearer")
    }, tags={ "assignees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The updated assignee", response = AssigneeResponse.class),
        @ApiResponse(code = 404, message = "Not found") })
    @RequestMapping(value = "/assignees/{assignee_id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<AssigneeResponse> update(@ApiParam(value = "The assignee id",required=true) @PathVariable("assignee_id") Long assigneeId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody AssigneeRequest assigneeRequest) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assignee\" : { \"last_name\" : \"last_name\", \"first_name\" : \"first_name\", \"assignee_id\" : 6 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
