package com.dalong;

import io.pebbletemplates.pebble.error.PebbleException;
import io.pebbletemplates.pebble.extension.NodeVisitor;
import io.pebbletemplates.pebble.node.AbstractRenderableNode;
import io.pebbletemplates.pebble.node.expression.Expression;
import io.pebbletemplates.pebble.node.expression.MapExpression;
import io.pebbletemplates.pebble.template.EvaluationContextImpl;
import io.pebbletemplates.pebble.template.PebbleTemplateImpl;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Map;

public class MyIncludeNode extends AbstractRenderableNode {
    private final Expression<?> includeExpression;


    public MyIncludeNode(int lineNumber, Expression<?> includeExpression) {
        super(lineNumber);
        this.includeExpression = includeExpression;
    }

    @Override
    public void render(PebbleTemplateImpl self, Writer writer, EvaluationContextImpl context)
            throws IOException {
        String templateName = (String) this.includeExpression.evaluate(self, context);
        Map<?, ?> map = Collections.emptyMap();
        if (templateName == null) {
            throw new PebbleException(
                    null,
                    "The template name in an include tag evaluated to NULL. If the template name is static, make sure to wrap it in quotes.",
                    this.getLineNumber(), self.getName());
        }
        self.includeTemplate(writer, context, templateName, map);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expression<?> getIncludeExpression() {
        return this.includeExpression;
    }

}
