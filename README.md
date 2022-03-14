# galaxy
A mono repo for everything you need to build a galaxy with bazel, while
pulling critical libraries in the form of source code part of the
source tree.

## Quick Start

* Using this repo requires gclient from
  [depot_tools](https://commondatastorage.googleapis.com/chrome-infra-docs/flat/depot_tools/docs/html/depot_tools.html). Please
  follow the [installation
  guide](https://commondatastorage.googleapis.com/chrome-infra-docs/flat/depot_tools/docs/html/depot_tools_tutorial.html#_setting_up)
  to get started.
* Create an empty directory and switch to it.
* run `gclient config https://github.com/bazelment/galaxy` to
  initialize the config of gclient.
* run `gclient sync` to check out everything.

## How to add a new library

* Update `DEPS` file to include the SCM link of the given library, and
  a directory where the library should be included in the source
  tree. The general rule is most third party libraries should be under
  third_party.
  - A optional commit hash/version tag/branch name can be included in
    the SCM link to pin the version of the library.

* Update the bazel `WORKSPACE` file to include the given library.
 1. If the given library has bazel `WORKSPACE` file in its directory
    already, just use `local_repository` to include it.
 2. If the given library doesn't have bazel `BUILD` file or
    `WORKSPACE` file. There are two ways to add bazel BUILD support.
	- Put its source code inside `third_party/foo/src`, and create
      bazel BUILD file in `third_party/foo/BUILD`. Then they can be
      built with `bazel build third_party/foo/...`
	- Put its source inside `third_party/foo`', and create a
      `third_party/foo.BUILD` BUILD file, update `WORKSPACE` file to
      use `new_local_repository` rule to create another repo, with
      something like:
	  ```
	  new_local_repository(
        name = "com_github_cares_cares",
		path = "third_party/c-ares",
		build_file = "@com_github_grpc_grpc//third_party:cares/cares.BUILD",
	  )
	  ```

For some other languages like Java, when there is not significant
benefit of building from source, and the upstream doesn't change
frequently, it might be preferred to just pull in prebuilt artifacts
from maven. The following section talks about how to pull in maven
dependencies.

### Pull in prebuilt Java jars from maven
