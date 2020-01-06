/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api.response.visitor;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;

/**
 * Represents the result from a Visitor Query API call.
 */
public class VisitorQueryResponse {
    private VisitorQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    /**
     * Represents one or more visitors.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "visitor")
        private List<Visitor> visitors = Collections.emptyList();

        public Integer getTotalResults() {
            return totalResults;
        }

        /**
         * Visitors returned by the API.
         *
         * @return Visitor results.
         */
        public List<Visitor> getVisitors() {
            if (visitors == null) {
                visitors = Collections.emptyList();
            }
            return Collections.unmodifiableList(visitors);
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", visitors=" + visitors
                + '}';
        }
    }

    @Override
    public String toString() {
        return "VisitorQueryResponse{"
            + "result=" + result
            + '}';
    }
}
