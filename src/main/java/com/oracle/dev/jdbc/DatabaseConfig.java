/*
  Copyright (c) 2024, Oracle and/or its affiliates.

  This software is dual-licensed to you under the Universal Permissive License
  (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License
  2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose
  either license.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.oracle.dev.jdbc;

import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * Configuration for connecting code samples to an Oracle Database instance.
 * </p>
 */
public class DatabaseConfig {

  private static final Properties CONFIG = new Properties();

  static {

    try (InputStream input = DatabaseConfig.class.getClassLoader()
        .getResourceAsStream("config.properties")) {
      if (input == null) {
        System.out.println("Sorry, unable to find config.properties");
        System.exit(1);
      }
      // load a properties file from class path, inside static method
      CONFIG.load(input);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static final String DB_USER = CONFIG.getProperty("DB_USER");

  private static final String DB_URL = CONFIG.getProperty("DB_URL");

  private static final String DB_PASSWORD = CONFIG.getProperty("DB_PASSWORD");

  public static String getDbUser() {
    return DB_USER;
  }

  public static String getDbUrl() {
    return DB_URL;
  }

  public static String getDbPassword() {
    return DB_PASSWORD;
  }

}
