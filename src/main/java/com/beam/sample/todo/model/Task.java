package com.beam.sample.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Task")
@TypeAlias(".Task")
@Accessors(chain = true)
public class Task {
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date start;

    @Getter
    @Setter
    private Date end;

    @Getter
    @Setter
    private boolean done = false;
}