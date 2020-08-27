package com.catalog.client.business.controllers;

import com.catalog.client.dto.PathDto;
import com.catalog.client.services.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Igor on 8/25/2020.
 */
@Controller
public class PathController {

    @Autowired
    PathService pathService;

    @RequestMapping(value="getFolderContent", method= RequestMethod.POST)
    @ResponseBody
    public List<String> getFolderContent(@RequestBody PathDto dto){
        return pathService.getFolderContent(dto);
    }

    @RequestMapping(value="test", method= RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "Usao!";
    }
}
