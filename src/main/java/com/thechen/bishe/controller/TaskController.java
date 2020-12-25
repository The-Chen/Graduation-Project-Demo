package com.thechen.bishe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thechen.bishe.pojo.Task;
import com.thechen.bishe.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author : thechen
 * @Date : 14:20 2020/12/23
 * @Description
 * @Param
 * @return
 */
@Controller
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping({"/tasks","/"})
    public String getTasks(Model model){
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks",tasks);
        return "task/list";
    }

    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable("id")int id){
        return taskService.getTask(id);
    }

    @GetMapping("/toAddTask")
    public String toaddPage(Model model){

        return "task/add";
    }

    @PostMapping("/toAddTask")
    public String addTask(Task task){
        System.out.println("insert===>"+task);
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/toUpdateTask/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id,Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task",task);
        return "task/update";
    }

    @PostMapping("/toUpdateTask")
    public String updateTask(Task task){
        System.out.println("insert===>"+task);
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/toDeleteTask/{id}")
    public String deleteTask(@PathVariable("id")Integer id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/searchTask")
    public String searchTask(HttpServletRequest request, Model model){
        String result=new String(request.getParameter("result"));
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        //判断是否为整数
        System.out.println(result);
        if(pattern.matcher(result).matches()){
            if(result.length()==11){
                HashMap<String,String> map  = new HashMap<>();
                map.put("phone",result);
                List<Task> tasks = taskService.selectTasksByMap(map);
                model.addAttribute("tasks",tasks);
            }else {
                Task task = taskService.getTask(Integer.parseInt(result));
                model.addAttribute("tasks",task);
            }
        }else{
            HashMap<String,String> map = new HashMap<>();
            map.put("status",result);
            List<Task> tasks = taskService.selectTasksByMap(map);
            model.addAttribute("tasks",tasks);
        }
        return "task/search";
    }

}
