package com.microsoft.boot3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "user")
public class User {
/*    @Value("user.username")*/
    private String username;
/*    @Value("user.password")*/
    private String password;

    private List<String> gls;
}
