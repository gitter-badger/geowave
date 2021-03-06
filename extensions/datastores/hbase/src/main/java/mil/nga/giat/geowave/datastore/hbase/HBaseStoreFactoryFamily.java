/*******************************************************************************
 * Copyright (c) 2013-2017 Contributors to the Eclipse Foundation
 * 
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License,
 * Version 2.0 which accompanies this distribution and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 ******************************************************************************/
package mil.nga.giat.geowave.datastore.hbase;

import mil.nga.giat.geowave.core.store.DataStore;
import mil.nga.giat.geowave.core.store.DataStoreOperations;
import mil.nga.giat.geowave.core.store.GenericStoreFactory;
import mil.nga.giat.geowave.core.store.StoreFactoryFamilySpi;
import mil.nga.giat.geowave.core.store.adapter.AdapterIndexMappingStore;
import mil.nga.giat.geowave.core.store.adapter.AdapterStore;
import mil.nga.giat.geowave.core.store.adapter.statistics.DataStatisticsStore;
import mil.nga.giat.geowave.core.store.index.IndexStore;
import mil.nga.giat.geowave.core.store.index.SecondaryIndexDataStore;
import mil.nga.giat.geowave.datastore.hbase.index.secondary.HBaseSecondaryIndexDataStoreFactory;
import mil.nga.giat.geowave.datastore.hbase.metadata.HBaseAdapterIndexMappingStoreFactory;
import mil.nga.giat.geowave.datastore.hbase.metadata.HBaseAdapterStoreFactory;
import mil.nga.giat.geowave.datastore.hbase.metadata.HBaseDataStatisticsStoreFactory;
import mil.nga.giat.geowave.datastore.hbase.metadata.HBaseIndexStoreFactory;

public class HBaseStoreFactoryFamily extends
		AbstractHBaseFactory implements
		StoreFactoryFamilySpi
{
	@Override
	public GenericStoreFactory<DataStore> getDataStoreFactory() {
		return new HBaseDataStoreFactory();
	}

	@Override
	public GenericStoreFactory<DataStatisticsStore> getDataStatisticsStoreFactory() {
		return new HBaseDataStatisticsStoreFactory();
	}

	@Override
	public GenericStoreFactory<IndexStore> getIndexStoreFactory() {
		return new HBaseIndexStoreFactory();
	}

	@Override
	public GenericStoreFactory<AdapterStore> getAdapterStoreFactory() {
		return new HBaseAdapterStoreFactory();
	}

	@Override
	public GenericStoreFactory<SecondaryIndexDataStore> getSecondaryIndexDataStore() {
		return new HBaseSecondaryIndexDataStoreFactory();
	}

	@Override
	public GenericStoreFactory<AdapterIndexMappingStore> getAdapterIndexMappingStoreFactory() {
		return new HBaseAdapterIndexMappingStoreFactory();
	}

	@Override
	public GenericStoreFactory<DataStoreOperations> getDataStoreOperationsFactory() {
		return new HBaseOperationsFactory();
	}
}
