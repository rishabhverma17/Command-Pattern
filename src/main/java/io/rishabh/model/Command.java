package io.rishabh.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Command {
    String name;
    List<String> params;
}
