package com.github.pettyfer.basic.common.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Petty
 * @date 2018/4/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceInfo implements Serializable {
    private static final long serialVersionUID = 7593984561438329435L;
    private String resourceCode;
    private String resourceName;
    private String requestUrl;
    private String requestMethod;
    private String remark;
}
