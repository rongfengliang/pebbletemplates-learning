package com.dalong;

import io.pebbletemplates.pebble.extension.Function;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.PebbleTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyFunction implements Function {
    private final List<String> argumentNames = new ArrayList<>();


    public MyFunction() {
        this.argumentNames.add("name");
    }
    @Override
    public Object execute(Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
        String name = (String) args.get("name");
        return  name;
    }

    @Override
    public List<String> getArgumentNames() {
      return this.argumentNames;
    }
}
