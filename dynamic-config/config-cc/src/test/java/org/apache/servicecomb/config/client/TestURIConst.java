/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.config.client;

import org.junit.Assert;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class TestURIConst {
  @Test
  public void testURI_v2(final @Mocked ConfigCenterConfig config) {
    new Expectations() {
      {
        config.getDomainName();
        result = "mytenant";
        config.getApiVersion();
        result = "v2";
      }
    };

    URIConst uriConst = new URIConst();
    Assert.assertEquals("/members", uriConst.MEMBERS);
    Assert.assertEquals("/configuration/v2/refresh/items", uriConst.REFRESH_ITEMS);
    Assert.assertEquals("/configuration/v2/items", uriConst.ITEMS);
  }

  @Test
  public void testURI_v3(final @Mocked ConfigCenterConfig config) {
    new Expectations() {
      {
        config.getDomainName();
        result = "mytenant";
        config.getApiVersion();
        result = "v3";
      }
    };

    URIConst uriConst = new URIConst();
    Assert.assertEquals("/v3/mytenant/configuration/members", uriConst.MEMBERS);
    Assert.assertEquals("/v3/mytenant/configuration/refresh/items", uriConst.REFRESH_ITEMS);
    Assert.assertEquals("/v3/mytenant/configuration/items", uriConst.ITEMS);
  }
}
