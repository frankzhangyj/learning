package com.microsoft.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Pet {
private String name;
private Double weight;
}
