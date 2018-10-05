/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.gradle.livereload

import net.alchim31.livereload.LRServer

import java.nio.file.FileSystems
import java.nio.file.Path

/**
 * @author Andres Almiray
 */
class LiveReloadServer {
    private final int port
    private final String docRoot
    private final int delay

    LiveReloadServer(int port, String docRoot, int delay) {
        this.port = port
        this.docRoot = docRoot
        this.delay = delay
    }

    void run() {
        Path docroot = FileSystems.default.getPath(docRoot)
        new LRServer(port, docroot, delay).run()
    }
}
