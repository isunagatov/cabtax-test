/*
 * Copyright (c) 2008-2017 Haulmont.
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

package com.haulmont.masquerade.components;

import com.haulmont.masquerade.util.Log;

import java.util.Arrays;

public interface AppMenu extends Component<AppMenu> {
    @Log
    <T> T openItem(Class<T> clazz, String... path);
    @Log
    <T> T openItem(Menu<T> menu);
    @Log
    void openItem(String... path);

    class Menu<T> {
        private final Class<T> screenClass;
        private final String[] path;

        public Menu(Class<T> screenClass, String... path) {
            this.screenClass = screenClass;
            this.path = path;
        }

        public Class<T> getScreenClass() {
            return screenClass;
        }

        public String[] getPath() {
            return path;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "screenClass=" + screenClass +
                    ", path=" + Arrays.toString(path) +
                    '}';
        }
    }
}