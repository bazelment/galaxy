workspace(name="galaxy")

# All new_local_repository, they can't show up after `load` calls, so
# put them at the beginning.
# Start of zlib
# End of zlib

local_repository(
    name = "bazel_skylib",
    path = "third_party/bazel-skylib",
)

local_repository(
    name = "rules_python",
    path = "third_party/rules_python",
)

local_repository(
    name = "rules_jvm_external",
    path = "third_party/rules_jvm_external",
)

local_repository(
  name = "boringssl",
  path = "third_party/boringssl/src",
)

local_repository(
    name = "com_google_googletest",
    path = "third_party/googletest",
)

local_repository(
    name = "com_google_absl",
    path = "third_party/abseil-cpp",
)

local_repository(
    name = "com_github_google_benchmark",
    path = "third_party/benchmark",
)

local_repository(
    name = "com_google_protobuf",
    path = "third_party/protobuf",
)

local_repository(
    name = "com_github_grpc_grpc",
    path = "third_party/grpc",
)

new_local_repository(
    name = "com_github_cares_cares",
    path = "third_party/c-ares",
    build_file = "@com_github_grpc_grpc//third_party:cares/cares.BUILD",
)

new_local_repository(
    name = "zlib",
    path = "third_party/zlib",
    build_file = "@com_github_grpc_grpc//third_party:zlib.BUILD",
)

local_repository(
    name = "io_grpc_grpc_java",
    path = "third_party/java/grpc-java",
)

# new_local_repository can't be used after load, so putting all load calls at the end.

# Start of rules_jvm_external
load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
rules_jvm_external_deps()
load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")
rules_jvm_external_setup()
load("@rules_jvm_external//:defs.bzl", "maven_install")

# End of rules_jvm_external

# Start of protobuf
load("@com_google_protobuf//:protobuf_deps.bzl", "PROTOBUF_MAVEN_ARTIFACTS", "protobuf_deps")
protobuf_deps()

bind(
    name = "python_headers",
    actual = "@com_google_protobuf//util/python:python_headers",
)
# All the maven_install related stuff is done in grpc-java below.

# End of protobuf

# Start of grpc
load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps", "grpc_test_only_deps")
grpc_deps()
grpc_test_only_deps()

load("@com_github_grpc_grpc//bazel:grpc_extra_deps.bzl", "grpc_extra_deps")
grpc_extra_deps()

# End of grpc

# Start of grpc-java
load("@io_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_ARTIFACTS")
load("@io_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS")
load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

# After updating this list, we should run this command, according to
# third_party/rules_jvm_external/README.md, to re-pin the unpinned `@maven`
# repository:
# $ bazel run @unpinned_maven//:pin

ADDITIONAL_MAVEN_ARTIFACTS = [
    "org.apache.logging.log4j:log4j-api:2.17.2",
    "org.apache.logging.log4j:log4j-core:2.17.2",
]

# They can be accessed like
# "@maven//:org_apache_logging_log4j_log4j_api"(preferred) or
# "@org_apache_logging_log4j_log4j_api//jar"(compat style).

maven_install(
    artifacts = IO_GRPC_GRPC_JAVA_ARTIFACTS + PROTOBUF_MAVEN_ARTIFACTS + ADDITIONAL_MAVEN_ARTIFACTS,
    generate_compat_repositories = True,
    override_targets = IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS,
    repositories = [
        "https://repo.maven.apache.org/maven2/",
    ],
    maven_install_json = "//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

load("@maven//:compat.bzl", "compat_repositories")
compat_repositories()
# End of grpc-java
