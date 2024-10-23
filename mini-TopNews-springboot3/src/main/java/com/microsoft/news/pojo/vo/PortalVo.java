package com.microsoft.news.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortalVo {
        private String keyWords;
        private Integer type;
        private Integer pageNum = 1;
        private Integer pageSize =10;
}
