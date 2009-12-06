package org.apache.cayenne.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.cayenne.access.DataNode;
import org.apache.cayenne.access.dbsync.CreateIfNoSchemaStrategy;
import org.apache.cayenne.access.dbsync.SchemaUpdateStrategy;
import org.apache.cayenne.itest.ItestDBUtils;
import org.apache.cayenne.itest.ItestTableUtils;

public abstract class CayenneServerRuntimeCase extends TestCase {

	static final Map<RuntimeName, CayenneServerRuntime> runtimeCache;

	static {
		runtimeCache = new HashMap<RuntimeName, CayenneServerRuntime>();
	}

	protected CayenneServerRuntime runtime;

	@Override
	protected void setUp() throws Exception {

		RuntimeName name = getRuntimeName();
		assertNotNull(name);

		runtime = runtimeCache.get(name);
		if (runtime == null) {
			runtime = new CayenneServerRuntime(name.name());
			runtimeCache.put(name, runtime);

			// setup schema

			// TODO: should that be drop/create?
			SchemaUpdateStrategy dbCreator = new CreateIfNoSchemaStrategy();
			dbCreator.updateSchema(getDataNode());
		}
	}

	@Override
	protected void tearDown() throws Exception {
		runtime = null;
	}

	protected abstract RuntimeName getRuntimeName();

	protected ItestDBUtils getDbUtils() {

		return new ItestDBUtils(getDataNode().getDataSource());
	}

	protected ItestTableUtils getTableHelper(String tableName) {
		return new ItestTableUtils(getDbUtils(), tableName);
	}

	private DataNode getDataNode() {
		Collection<DataNode> nodes = runtime.getDataDomain().getDataNodes();
		assertFalse("Can't find DataSource - no nodes configured", nodes
				.isEmpty());
		assertEquals("Can't find DataSource - multiple nodes found", 1, nodes
				.size());

		return nodes.iterator().next();
	}
}
