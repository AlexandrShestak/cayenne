/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.access;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.di.Inject;
import org.apache.cayenne.testdo.testmap.Artist;
import org.apache.cayenne.unit.di.server.ServerCase;
import org.apache.cayenne.unit.di.server.UseServerRuntime;

@UseServerRuntime(ServerCase.TESTMAP_PROJECT)
public class NestedDataContextRollbackTest extends ServerCase {

    @Inject
    private ObjectContext context;

    public void testRollbackChanges() {
        ObjectContext child1 = context.createChildContext();

        assertFalse(context.hasChanges());
        assertFalse(child1.hasChanges());

        context.newObject(Artist.class);
        child1.newObject(Artist.class);

        assertTrue(context.hasChanges());
        assertTrue(child1.hasChanges());

        child1.rollbackChanges();
        assertFalse(context.hasChanges());
        assertFalse(child1.hasChanges());
    }

    public void testRollbackChangesLocally() {
        ObjectContext child1 = context.createChildContext();

        assertFalse(context.hasChanges());
        assertFalse(child1.hasChanges());

        context.newObject(Artist.class);
        child1.newObject(Artist.class);

        assertTrue(context.hasChanges());
        assertTrue(child1.hasChanges());

        child1.rollbackChangesLocally();
        assertTrue(context.hasChanges());
        assertFalse(child1.hasChanges());
    }
}
