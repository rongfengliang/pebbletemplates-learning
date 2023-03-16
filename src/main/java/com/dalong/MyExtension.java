package com.dalong;

import io.pebbletemplates.pebble.extension.AbstractExtension;
import io.pebbletemplates.pebble.extension.Filter;
import io.pebbletemplates.pebble.extension.Function;
import io.pebbletemplates.pebble.tokenParser.TokenParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyExtension extends AbstractExtension {

    @Override
    public Map<String, Filter> getFilters() {
        Map<String, Filter> filters = new HashMap<>();
        filters.put("rongfengliang",new LoginFilter());
        return  filters;
    }

    @Override
    public List<TokenParser> getTokenParsers() {
        List<TokenParser> parsers = new ArrayList<>();
        parsers.add(new MyTokenParser());
        return parsers;
    }

    @Override
    public Map<String, Function> getFunctions() {
        Map<String, Function> functionMap = new HashMap<>();
        functionMap.put("rongfengliang",new MyFunction());
        return  functionMap;
    }
}
