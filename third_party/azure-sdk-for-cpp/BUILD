COPTS = [
    "-std=c++14",
]

cc_library(
    name = "core",
    includes = [
        "src/sdk/core/azure-core/inc/",
    ],
    hdrs = [
        "src/sdk/core/azure-core/inc/azure/core/credentials/credentials.hpp",
        "src/sdk/core/azure-core/inc/azure/core/credentials/token_credential_options.hpp",
        "src/sdk/core/azure-core/inc/azure/core/cryptography/hash.hpp",
        "src/sdk/core/azure-core/inc/azure/core/diagnostics/logger.hpp",
        "src/sdk/core/azure-core/inc/azure/core/http/http_status_code.hpp",
        "src/sdk/core/azure-core/inc/azure/core/http/http.hpp",
        "src/sdk/core/azure-core/inc/azure/core/http/raw_response.hpp",
        "src/sdk/core/azure-core/inc/azure/core/http/policies/policy.hpp",
        "src/sdk/core/azure-core/inc/azure/core/http/transport.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/azure_assert.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/client_options.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/contract.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/cryptography/sha_hash.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/diagnostics/log.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/http/pipeline.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/io/null_body_stream.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/json/json_serializable.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/json/json.hpp",
        "src/sdk/core/azure-core/inc/azure/core/internal/strings.hpp",
        "src/sdk/core/azure-core/inc/azure/core/io/body_stream.hpp",
        "src/sdk/core/azure-core/inc/azure/core/rtti.hpp",
        "src/sdk/core/azure-core/inc/azure/core/base64.hpp",
        "src/sdk/core/azure-core/inc/azure/core/case_insensitive_containers.hpp",
        "src/sdk/core/azure-core/inc/azure/core/context.hpp",
        "src/sdk/core/azure-core/inc/azure/core/datetime.hpp",
        "src/sdk/core/azure-core/inc/azure/core/dll_import_export.hpp",
        "src/sdk/core/azure-core/inc/azure/core/etag.hpp",
        "src/sdk/core/azure-core/inc/azure/core/exception.hpp",
        "src/sdk/core/azure-core/inc/azure/core/match_conditions.hpp",
        "src/sdk/core/azure-core/inc/azure/core/modified_conditions.hpp",
        "src/sdk/core/azure-core/inc/azure/core/nullable.hpp",
        "src/sdk/core/azure-core/inc/azure/core/operation.hpp",
        "src/sdk/core/azure-core/inc/azure/core/paged_response.hpp",
        "src/sdk/core/azure-core/inc/azure/core/operation_status.hpp",
        "src/sdk/core/azure-core/inc/azure/core/platform.hpp",
        "src/sdk/core/azure-core/inc/azure/core/response.hpp",
        "src/sdk/core/azure-core/inc/azure/core/url.hpp",
        "src/sdk/core/azure-core/inc/azure/core/uuid.hpp",
        "src/sdk/core/azure-core/inc/azure/core.hpp",
    ],
    srcs = [
        "src/sdk/core/azure-core/src/azure_assert.cpp",
        "src/sdk/core/azure-core/src/cryptography/md5.cpp",
        "src/sdk/core/azure-core/src/cryptography/sha_hash.cpp",
        "src/sdk/core/azure-core/src/http/bearer_token_authentication_policy.cpp",
        "src/sdk/core/azure-core/src/http/http.cpp",
        "src/sdk/core/azure-core/src/http/log_policy.cpp",
        "src/sdk/core/azure-core/src/http/policy.cpp",
        "src/sdk/core/azure-core/src/http/raw_response.cpp",
        "src/sdk/core/azure-core/src/http/request.cpp",
        "src/sdk/core/azure-core/src/http/retry_policy.cpp",
        "src/sdk/core/azure-core/src/http/telemetry_policy.cpp",
        "src/sdk/core/azure-core/src/http/transport_policy.cpp",
        "src/sdk/core/azure-core/src/http/url.cpp",
        "src/sdk/core/azure-core/src/io/body_stream.cpp",
        "src/sdk/core/azure-core/src/io/random_access_file_body_stream.cpp",
        "src/sdk/core/azure-core/src/private/environment_log_level_listener.hpp",
        "src/sdk/core/azure-core/src/private/package_version.hpp",
        "src/sdk/core/azure-core/src/base64.cpp",
        "src/sdk/core/azure-core/src/context.cpp",
        "src/sdk/core/azure-core/src/datetime.cpp",
        "src/sdk/core/azure-core/src/environment_log_level_listener.cpp",
        "src/sdk/core/azure-core/src/etag.cpp",
        "src/sdk/core/azure-core/src/exception.cpp",
        "src/sdk/core/azure-core/src/logger.cpp",
        "src/sdk/core/azure-core/src/operation_status.cpp",
        "src/sdk/core/azure-core/src/strings.cpp",
        "src/sdk/core/azure-core/src/uuid.cpp",
    ],
    copts = COPTS,
    deps = [
        "@boringssl//:crypto",
    ]
)

cc_library(
    name = "azure-storage-common",
    includes = [
        "src/sdk/storage/azure-storage-common/inc",
    ],
    hdrs = [
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/access_conditions.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/account_sas_builder.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/crypt.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/dll_import_export.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/concurrent_transfer.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/constants.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/file_io.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/reliable_stream.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/shared_key_policy.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/storage_per_retry_policy.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/storage_service_version_policy.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/storage_switch_to_secondary_policy.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/internal/xml_wrapper.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/storage_common.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/storage_credential.hpp",
        "src/sdk/storage/azure-storage-common/inc/azure/storage/common/storage_exception.hpp"
    ],
    srcs = [
        "src/sdk/storage/azure-storage-common/src/private/package_version.hpp",
        "src/sdk/storage/azure-storage-common/src/account_sas_builder.cpp",
        "src/sdk/storage/azure-storage-common/src/crypt.cpp",
        "src/sdk/storage/azure-storage-common/src/file_io.cpp",
        "src/sdk/storage/azure-storage-common/src/reliable_stream.cpp",
        "src/sdk/storage/azure-storage-common/src/shared_key_policy.cpp",
        "src/sdk/storage/azure-storage-common/src/storage_common.cpp",
        "src/sdk/storage/azure-storage-common/src/storage_credential.cpp",
        "src/sdk/storage/azure-storage-common/src/storage_exception.cpp",
        "src/sdk/storage/azure-storage-common/src/storage_per_retry_policy.cpp",
        "src/sdk/storage/azure-storage-common/src/storage_switch_to_secondary_policy.cpp",
        # This requires libxml
        "src/sdk/storage/azure-storage-common/src/xml_wrapper.cpp"
    ],
    copts = COPTS,
    deps = [
        ":core",
        "//third_party/libxml2",
    ]
)

cc_library(
    name = "azure-storage-blobs",
    includes = [
        "src/sdk/storage/azure-storage-blobs/inc",
    ],
    hdrs = [
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/protocol/blob_rest_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/append_blob_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_container_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_lease_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_options.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_responses.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_sas_builder.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/blob_service_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/block_blob_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/dll_import_export.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs/page_blob_client.hpp",
        "src/sdk/storage/azure-storage-blobs/inc/azure/storage/blobs.hpp"
    ],
    srcs = [
        "src/sdk/storage/azure-storage-blobs/src/private/package_version.hpp",
        "src/sdk/storage/azure-storage-blobs/src/append_blob_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_container_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_lease_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_responses.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_rest_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_sas_builder.cpp",
        "src/sdk/storage/azure-storage-blobs/src/blob_service_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/block_blob_client.cpp",
        "src/sdk/storage/azure-storage-blobs/src/page_blob_client.cpp"
    ],
    copts = COPTS,
    deps = [
        ":azure-storage-common",
    ]
)

# Samples of blob storage
cc_binary(
    name = "blob_getting_started",
    copts = COPTS,
    srcs = [
        "src/sdk/storage/azure-storage-blobs/samples/blob_getting_started.cpp",
    ],
    deps = [
        ":azure-storage-blobs"
    ]
)
