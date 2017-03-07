package com.mpp.project.datasource.borrowerEntity;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class BorrowerEntity {
    private String name;
    private List<Record> records;

    public BorrowerEntity(String name, List<Record> records) {
        this.name = name;
        this.records = records;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BorrowerEntity{" +
                "name='" + name + '\'' +
                ", records=" + records +
                '}';
    }
}
