package com.dalong;

import io.pebbletemplates.pebble.error.ParserException;
import io.pebbletemplates.pebble.lexer.Token;
import io.pebbletemplates.pebble.lexer.TokenStream;
import io.pebbletemplates.pebble.node.IncludeNode;
import io.pebbletemplates.pebble.node.RenderableNode;
import io.pebbletemplates.pebble.node.expression.Expression;
import io.pebbletemplates.pebble.node.expression.MapExpression;
import io.pebbletemplates.pebble.parser.Parser;
import io.pebbletemplates.pebble.tokenParser.TokenParser;

public class MyTokenParser implements TokenParser {
    @Override
    public String getTag() {
        return "rongfengliang";
    }

    @Override
    public RenderableNode parse(Token token, Parser parser) {
        TokenStream stream = parser.getStream();
        int lineNumber = token.getLineNumber();
        // skip over the 'include' token
        stream.next();
        Expression<?> includeExpression = parser.getExpressionParser().parseExpression();
        stream.expect(Token.Type.EXECUTE_END);
        return new MyIncludeNode(lineNumber, includeExpression);
    }
}
