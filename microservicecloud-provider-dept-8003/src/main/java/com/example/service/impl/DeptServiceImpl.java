package com.example.service.impl;

import com.example.dao.DeptMapper;
import com.example.entity.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "DeptService")
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
