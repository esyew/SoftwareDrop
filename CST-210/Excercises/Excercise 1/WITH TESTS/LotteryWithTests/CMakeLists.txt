cmake_minimum_required(VERSION 3.24)
project(LotteryWithTests)

set(CMAKE_CXX_STANDARD 20)

add_executable(LotteryWithTests main.cpp randomGen.cpp randomGen.h)

include(FetchContent)
FetchContent_Declare(
        googletest
        # Specify the commit you depend on and update it regularly.
        URL https://github.com/google/googletest/archive/5376968f6948923e2411081fd9372e71a59d8e77.zip
)
# For Windows: Prevent overriding the parent project's compiler/linker settings
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)
FetchContent_MakeAvailable(googletest)

# Now simply link against gtest or gtest_main as needed. Eg



enable_testing()

add_executable(
        randomTest
        randomTest.cc
)
target_link_libraries(
        randomTest
        GTest::gtest_main
)

include(GoogleTest)
gtest_discover_tests(randomTest)
