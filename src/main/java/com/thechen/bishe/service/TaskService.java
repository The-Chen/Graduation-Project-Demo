package com.thechen.bishe.service;

import com.thechen.bishe.pojo.Task;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author : thechen
 * @Date : 11:33 2020/12/23
 * @Description
 * @Param
 * @return
 */
public interface TaskService {

   Page<Task> getPageTasks(int index);

   List<Task> getTasks();

    Task getTask(int id);

    int addTask(Task task);

    int updateTask(Task task);

    int deleteTask(int id);

    List<Task> selectTasksByMap(Map map);
}
