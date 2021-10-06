package com.zgy.layui.controller;

import com.zgy.layui.streamHandler.KzStreamHandler;
import com.zgy.layui.vo.KzLineVO;
import com.zgy.layui.vo.KzOneLineVO;
import com.zgy.layui.vo.KzScatterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Author Rabindranath Tagore  515783116@qq.com
 * @Date 2021/9/29 21:07
 */
@Controller
@CrossOrigin
@RequestMapping("/stream")
public class StreamController {
    @Autowired(required=true)
    private KzStreamHandler kzStreamHandler;
    @RequestMapping("/line")
    @ResponseBody
    public KzLineVO line() throws IOException {
        return kzStreamHandler.getLineVO();
    }

    @RequestMapping("/scatter")
    @ResponseBody
    public KzScatterVO scatter() throws IOException {
        return kzStreamHandler.getScatterVO();
    }

    @RequestMapping("/allUserCount")
    @ResponseBody
    public Long allUserCount() throws IOException {
        return kzStreamHandler.getAllUserCount();
    }

    @RequestMapping("/oneLineVO")
    @ResponseBody
    public KzOneLineVO oneLineVO() throws IOException {
        return kzStreamHandler.getOneLineVO();
    }

}
