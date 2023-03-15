package org.example.entity;

import org.example.annotation.ORMColumn;
import org.example.annotation.ORMEntity;
import org.example.annotation.ORMId;

@ORMEntity("user")
public class User {
    @ORMId
    @ORMColumn("id")
    private Long id;
    @ORMColumn("name")
    private String name;
    @ORMColumn("username")
    private String userName;
}
