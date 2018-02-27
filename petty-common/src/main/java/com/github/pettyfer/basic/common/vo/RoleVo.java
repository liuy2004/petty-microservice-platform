package com.github.pettyfer.basic.common.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 角色信息
 * @author Petty
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo implements Serializable {
    private String roleId;
    private String roleName;
    private String roleType;
    private BigDecimal status;
    private BigDecimal sortNo;
}
