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
package org.drools.mvel.expr;

import java.util.Calendar;

import org.drools.util.DateUtils;
import org.mvel2.ConversionHandler;

public class MVELCalendarCoercion implements ConversionHandler {

    public boolean canConvertFrom(Class cls) {
        return cls == String.class || cls.isAssignableFrom( Calendar.class );
    }

    public Object convertFrom(Object o) {
        if (o instanceof String) {
            Calendar cal = Calendar.getInstance();
            cal.setTime( DateUtils.parseDate( (String) o ) );
            return cal;
        } else {
            return o;
        }
    }

}
