package com.crud.crud.param;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class PageableParam {
    @Parameter(hidden = true)
    private Integer pageNo;

    @Parameter(hidden = true)
    private Integer pageSize = 20;

    @Parameter(hidden = true)
    private String sortBy;
}
