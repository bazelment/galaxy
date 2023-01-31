#include "absl/flags/flag.h"
#include "absl/flags/parse.h"
#include "absl/log/initialize.h"
#include "absl/log/log.h"
#include "absl/strings/str_format.h"

ABSL_FLAG(std::string, foo, "world", "Whom to greet");

int main(int argc, char *argv[]) {
  absl::ParseCommandLine(argc, argv);
  absl::InitializeLog();
  LOG(INFO) << "Hello " << absl::GetFlag(FLAGS_foo);
  return 0;
}
