/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.action.admin.cluster.snapshots.restore;

import org.opensearch.common.xcontent.XContentParser;
import org.opensearch.snapshots.RestoreInfo;
import org.opensearch.test.AbstractXContentTestCase;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestoreSnapshotResponseTests extends AbstractXContentTestCase<RestoreSnapshotResponse> {

    @Override
    protected RestoreSnapshotResponse createTestInstance() {
        if (randomBoolean()) {
            String name = randomRealisticUnicodeOfCodepointLengthBetween(1, 30);
            List<String> indices = new ArrayList<>();
            indices.add("test0");
            indices.add("test1");
            int totalShards = randomIntBetween(1, 1000);
            int successfulShards = randomIntBetween(0, totalShards);
            return new RestoreSnapshotResponse(new RestoreInfo(name, indices, totalShards, successfulShards));
        } else {
            return new RestoreSnapshotResponse((RestoreInfo) null);
        }
    }

    @Override
    protected RestoreSnapshotResponse doParseInstance(XContentParser parser) throws IOException {
        return RestoreSnapshotResponse.fromXContent(parser);
    }

    @Override
    protected boolean supportsUnknownFields() {
        return true;
    }
}
