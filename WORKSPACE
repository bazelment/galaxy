workspace(name="galaxy")

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
load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
rules_jvm_external_deps()
load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")
rules_jvm_external_setup()
load("@rules_jvm_external//:defs.bzl", "maven_install")

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

load("@com_google_protobuf//:protobuf_deps.bzl", "PROTOBUF_MAVEN_ARTIFACTS", "protobuf_deps")
protobuf_deps()

bind(
    name = "python_headers",
    actual = "@com_google_protobuf//util/python:python_headers",
)

maven_install(
    artifacts = PROTOBUF_MAVEN_ARTIFACTS,
    # For updating instructions, see:
    # https://github.com/bazelbuild/rules_jvm_external#updating-maven_installjson
    maven_install_json = "@com_google_protobuf//:maven_install.json",
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://repo.maven.apache.org/maven2",
    ],
)
load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

# End of protobuf

