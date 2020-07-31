package com.palindrome.demo.repository;

import com.palindrome.demo.dao.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DataTable,String> {
}

