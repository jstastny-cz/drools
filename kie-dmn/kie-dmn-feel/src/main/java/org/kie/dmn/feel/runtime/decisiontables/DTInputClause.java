/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.dmn.feel.runtime.decisiontables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kie.dmn.feel.lang.CompiledExpression;
import org.kie.dmn.feel.runtime.UnaryTest;

public class DTInputClause {
    private final String inputExpression;
    private final CompiledExpression compiledInput;
    private final String inputValuesText;
    private final List<UnaryTest> inputValues;
    private final boolean isCollection;

    public DTInputClause(String inputExpression, String inputValuesText, List<UnaryTest> inputValues, CompiledExpression compiledInput, boolean isCollection) {
        super();
        this.inputExpression = inputExpression;
        this.inputValuesText = inputValuesText;
        if (inputValues != null) {
            this.inputValues = Collections.unmodifiableList(new ArrayList<UnaryTest>(inputValues));
        } else {
            this.inputValues = Collections.emptyList();
        }
        this.compiledInput = compiledInput;
        this.isCollection = isCollection;
    }
   
    public String getInputExpression() {
        return inputExpression;
    }
    
    public List<UnaryTest> getInputValues() {
        return inputValues;
    }

    public String getInputValuesText() {
        return inputValuesText;
    }

    public CompiledExpression getCompiledInput() {
        return compiledInput;
    }

    public boolean isCollection() {
        return isCollection;
    }

}