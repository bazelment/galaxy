load("@rules_proto//proto:defs.bzl", "proto_library")
load("@com_github_grpc_grpc//bazel:cc_grpc_library.bzl", "cc_grpc_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")
load("@com_github_grpc_grpc//bazel:grpc_build_system.bzl", "grpc_proto_library")

# See cc_grpc_library.bzl, this will create the following build targets:
# proto_library: "_bank_only"
# cc_proto_library: "_bank_cc_proto"
# generate_cc(generate grpc header/cpp files): "_bank_grpc_codegen"
# cc_library(for generate grpc stub files): "bank"

grpc_proto_library(
  name = "bank",
  srcs = [
    "bank.proto",
  ],
)

cc_binary(
  name = "bank-server",
  srcs = [
    "bank-server.cc"
  ],
  deps = [
      ":bank",
      "@com_github_grpc_grpc//:grpc++",
      "@com_google_absl//absl/flags:flag",
      "@com_google_absl//absl/flags:parse",
      "@com_google_absl//absl/log",
      "@com_google_absl//absl/log:flags",      
      "@com_google_absl//absl/log:initialize",
  ]
)

cc_binary(
  name = "bank-client",
  srcs = [
    "bank-client.cc"
  ],
  deps = [
      ":bank",
      "@com_github_grpc_grpc//:grpc++",      
      "@com_google_absl//absl/flags:flag",
      "@com_google_absl//absl/flags:parse",
      "@com_google_absl//absl/log",
      "@com_google_absl//absl/log:flags",      
      "@com_google_absl//absl/log:initialize",
  ]
)
