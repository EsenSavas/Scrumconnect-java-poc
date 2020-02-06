package com.makeitconsulting.scrumconnectapipoc.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponse {

    @ApiModelProperty
    private String name;

}