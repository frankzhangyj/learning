package com.microsoft.spring5.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Book {
    private Integer bId;
    private Integer uId;
    private String bName;
}
