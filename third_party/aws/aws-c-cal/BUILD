cc_library(
    name = "aws-c-cal",
    includes = [
        "src/include",
    ],
    copts = [
    ],
    hdrs = [
        "src/include/aws/cal/cal.h",
        "src/include/aws/cal/ecc.h",
        "src/include/aws/cal/exports.h",
        "src/include/aws/cal/hash.h",
        "src/include/aws/cal/hmac.h",
        "src/include/aws/cal/private/der.h",
        "src/include/aws/cal/private/ecc.h",
        "src/include/aws/cal/private/opensslcrypto_common.h",

    ],
    srcs = [
        #glob src/source/*.c
        "src/source/cal.c",
        "src/source/der.c",
        "src/source/ecc.c",
        "src/source/hash.c",
        "src/source/hmac.c",
        "src/source/unix/openssl_platform_init.c",
        "src/source/unix/opensslcrypto_ecc.c",
        "src/source/unix/opensslcrypto_hash.c",
        "src/source/unix/opensslcrypto_hmac.c",
    ],
    deps = [
        "//third_party/aws/aws-c-common",
    ],
    visibility = [
        "//visibility:public",
    ]
)
