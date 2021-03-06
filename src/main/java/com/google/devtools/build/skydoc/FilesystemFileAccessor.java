// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.skydoc;

import com.google.devtools.build.lib.syntax.ParserInput;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Implementation of {@link SkylarkFileAccessor} which uses the real filesystem.
 */
public class FilesystemFileAccessor implements SkylarkFileAccessor {

  @Override
  public ParserInput inputSource(String filename) throws IOException {
    return ParserInput.create(Files.readAllBytes(Paths.get(filename)), filename);
  }

  @Override
  public boolean fileExists(String pathString) {
    return Files.exists(Paths.get(pathString));
  }
}
