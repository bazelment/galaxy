java_binary(
    name = "log_generator",
    srcs = [
        "LogGenerator.java",
    ],
    main_class = "LogGenerator",
    resources = [
        "log4j2.xml"
    ],
    deps = [
        "@maven//:org_apache_logging_log4j_log4j_api",
        "@maven//:org_apache_logging_log4j_log4j_core",
    ]
)

load("@rules_proto//proto:defs.bzl", "proto_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")
load("@com_github_grpc_grpc//bazel:cc_grpc_library.bzl", "cc_grpc_library")

proto_library(
    name = "remote_log_proto",
    srcs = ["remote_log.proto"],
)

cc_proto_library(
    name = "remote_log_cc_proto",
    deps = [":remote_log_proto"],
)

cc_grpc_library(
    name = "remote_log_cc_grpc",
    srcs = [":remote_log_proto"],
    grpc_only = True,
    deps = [":remote_log_cc_proto"],
)

java_proto_library(
    name = "remote_log_java_proto",
    deps = [":remote_log_proto"],
)

java_grpc_library(
    name = "remote_log_java_grpc",
    srcs = [":remote_log_proto"],
    deps = [":remote_log_java_proto"],
)

java_library(
    name = "remote_log_java_client",
    srcs = [
        "RemoteLogJavaClient.java"
    ],
    deps = [
        ":remote_log_java_proto",
        ":remote_log_java_grpc",
        "@io_grpc_grpc_java//stub",
    ]
)

cc_binary(
    name = "log_server",
    srcs = [ "log_server.cc",
    ],
    deps = [
        "@com_github_grpc_grpc//:grpc++",
        "@com_github_grpc_grpc//:grpc++_reflection",
        ":remote_log_cc_grpc",
    ]
)

