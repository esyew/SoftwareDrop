include(FetchContent)

FetchContent_Declare(
        googletest
        GIT_REPOSITORY https://github.com/google/googletest.git
        GIT_TAG        release-1.11.0
)
FetchContent_MakeAvailable(googletest)
add_library(GTest::GTest INTERFACE IMPORTED  ../src/BusinessLogic.cpp ../src/BusinessLogic.h)
target_link_libraries(GTest::GTest INTERFACE gtest_main)

add_executable(projectTest tests.cc tests.cc ../src/BusinessLogic.cpp ../src/BusinessLogic.h)

target_link_libraries(projectTest
        PRIVATE
        GTest::GTest)

add_test(project_gtests projectTest)