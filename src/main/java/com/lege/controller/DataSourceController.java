package com.lege.controller;

import com.lege.datasource.DataSourceType;
import com.lege.model.User;
import com.lege.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-06-08 14:34
 */
@RestController
public class DataSourceController {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceController.class);


    @Autowired
    private UserService userService;

    /**
     * 修改数据源接口
     *
     * @param dsType
     * @param session
     */
    @PostMapping("/dstype")
    public void setDsType(String dsType, HttpSession session) {
        session.setAttribute(DataSourceType.DS_SESSION_KEY, dsType);
        logger.info("数据源切换为 {}", dsType);
    }


    @GetMapping("/users")
    public List<User> getAllUser() {
       return userService.getAllUser();
    }
}
