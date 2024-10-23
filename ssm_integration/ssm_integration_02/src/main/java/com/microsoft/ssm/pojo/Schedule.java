package com.microsoft.ssm.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule  {
    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Boolean completed;
}
