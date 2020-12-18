/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.jet.tests.file.ingestion;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.Serializable;

public class TestItem implements Serializable {

    private String name;
    private int val;

    public TestItem() {
    }

    public TestItem(int val) {
        this.name = "name: " + val;
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    static Schema avroSchema() {
        return SchemaBuilder
                .record(TestItem.class.getSimpleName())
                .namespace(TestItem.class.getPackage().getName())
                .fields()
                .requiredString("name")
                .requiredInt("val")
                .endRecord();
    }

    @Override
    public String toString() {
        return "TestItem{" +
                "name='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}
