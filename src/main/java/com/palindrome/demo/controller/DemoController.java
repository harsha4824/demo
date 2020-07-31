package com.palindrome.demo.controller;

import com.palindrome.demo.dao.DataTable;
import com.palindrome.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping("/string/{input}")
    public DataTable getInput(@PathVariable @NotBlank String input){
        String output = demoService.getLongestPalindrome(input);
        return demoService.saveToDatabase(output);
    }

    @GetMapping("/find")
    public List<DataTable> getAll(){
        return demoService.retrieveAll();
    }
}
