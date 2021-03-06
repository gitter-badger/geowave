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
package mil.nga.giat.geowave.core.index.sfc.xz;

import org.junit.Assert;
import org.junit.Test;

import mil.nga.giat.geowave.core.index.dimension.BasicDimensionDefinition;
import mil.nga.giat.geowave.core.index.sfc.SFCDimensionDefinition;
import mil.nga.giat.geowave.core.index.sfc.data.BasicNumericDataset;
import mil.nga.giat.geowave.core.index.sfc.data.MultiDimensionalNumericData;
import mil.nga.giat.geowave.core.index.sfc.data.NumericData;
import mil.nga.giat.geowave.core.index.sfc.data.NumericRange;

public class XZOrderSFCTest
{

	@Test
	public void testIndex() {
		double[] values = {
			42,
			43,
			57,
			59
		};
		// TODO Meaningful examination of results?
		Assert.assertNotNull(createSFC().getId(
				values));
	}

	@Test
	public void testRangeDecomposition() {
		NumericRange longBounds = new NumericRange(
				19.0,
				21.0);
		NumericRange latBounds = new NumericRange(
				33.0,
				34.0);
		NumericData[] dataPerDimension = {
			longBounds,
			latBounds
		};
		MultiDimensionalNumericData query = new BasicNumericDataset(
				dataPerDimension);
		// TODO Meaningful examination of results?
		Assert.assertNotNull(createSFC().decomposeRangeFully(
				query));
	}

	private XZOrderSFC createSFC() {
		SFCDimensionDefinition[] dimensions = {
			new SFCDimensionDefinition(
					new BasicDimensionDefinition(
							-180.0,
							180.0),
					32),
			new SFCDimensionDefinition(
					new BasicDimensionDefinition(
							-90.0,
							90.0),
					32)
		};
		return new XZOrderSFC(
				dimensions);
	}
}
