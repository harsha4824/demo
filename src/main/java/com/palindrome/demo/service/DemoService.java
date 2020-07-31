package com.palindrome.demo.service;

import com.palindrome.demo.dao.DataTable;
import com.palindrome.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public String getLongestPalindrome(String source) {
        String temp, temp2, resSub = "", res ="";
        for (int i = 0; i < source.length()-1; i++) {
            temp = getPalindrome(source, i, i);
            temp2 = getPalindrome(source, i ,i+1);
            if (temp.length()>temp2.length()) resSub = temp;
            else resSub = temp2;
            res = resSub.length()>res.length()?resSub:res;
        }
        return res;
    }

    private String getPalindrome(String source, int leftIndex, int rightIndex){
        for(;leftIndex>=0 && rightIndex<= source.length()-1 && source.charAt(leftIndex) == source.charAt(rightIndex);leftIndex--,rightIndex++){}
        return source.substring(leftIndex+1,rightIndex);
    }

    public DataTable saveToDatabase(String response){
        DataTable dataTable = new DataTable();
        dataTable.setName(response);
        return demoRepository.save(dataTable);
    }

    public List<DataTable> retrieveAll(){
        return demoRepository.findAll();
    }
}
