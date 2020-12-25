package com.thechen.bishe.service.impl;

import com.thechen.bishe.mapper.TaskMapper;
import com.thechen.bishe.pojo.Task;
import com.thechen.bishe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author : thechen
 * @Date : 11:35 2020/12/23
 * @Description
 * @Param
 * @return
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public Page<Task> getPageTasks(int index) {
        Page<Task> page = new Page<Task>(index,5);
        return  taskMapper.selectPage(page,null);
    }

    @Override
    public List<Task> getTasks() {
        return taskMapper.selectList(null);
    }

    @Override
    public Task getTask(int id) {
        return taskMapper.selectById(id);
    }

    @Override
    public int addTask(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateById(task);
    }

    @Override
    public int deleteTask(int id) {
        return taskMapper.deleteById(id);
    }

    @Override
    public List<Task> selectTasksByMap(Map map) {
        return taskMapper.selectByMap(map);
    }
}
