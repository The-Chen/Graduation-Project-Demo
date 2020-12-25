package com.thechen.bishe.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

/**
 * @Author : thechen
 * @Date : 11:26 2020/12/23
 * @Description
 * @Param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Task {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String phone;
    private String address;
    private Date time;
    private String description;
    private String status;
}
