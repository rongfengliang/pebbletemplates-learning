package com.dalong;

import io.pebbletemplates.pebble.error.PebbleException;
import io.pebbletemplates.pebble.extension.Filter;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.PebbleTemplate;

import java.util.List;
import java.util.Map;

public class LoginFilter implements Filter {
    public LoginFilter() {
    }
    @Override
    public Object apply(Object input, Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) throws PebbleException {
        return  "rongfengliang";
    }

    @Override
    public List<String> getArgumentNames() {
        return null;
    }
}
