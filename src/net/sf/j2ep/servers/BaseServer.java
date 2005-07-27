/*
 * Copyright 2005 Anders Nyman.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sf.j2ep.servers;

import net.sf.j2ep.Server;

/**
 * A basic implementation of the Server interface using a single host name to map
 * all connections. Can be easily extended to create a server that gets it host
 * name in some other way. For instance a server fetching the host name from the
 * request could be made to change the proxy into a forwarding proxy.
 * 
 * @author Anders Nyman
 */
public class BaseServer implements Server {

    /**
     * The full path to connect to.
     */
    private String name;
    
    /**
     * The host and port for this server
     */
    private String hostAndPort;

    /**
     * @see net.sf.j2ep.Server#getName()
     */
    public String getName() {
        return name;
    }
    
    /**
     * @see net.sf.j2ep.Server#getHostAndPort()
     */
    public String getHostAndPort() {
        return hostAndPort;
    }

    /**
     * Sets the host name to use for connections.
     * 
     * @param name The host name to set
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "The host name string cannot be null.");
        } else {
            this.name = name;
            int firstSlash = name.indexOf("/");
            if (firstSlash != -1) {
                hostAndPort = name.substring(0, firstSlash);
            } else {
                hostAndPort = name;
            }
        }
    }



}
