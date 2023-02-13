cmake_minimum_required(VERSION 3.24)

project(Encryption)

set(CMAKE_CXX_STANDARD 20)




add_executable(Encryption src/main.cpp src/BusinessLogic.cpp src/BusinessLogic.h src/VariadicTable.h)



add_subdirectory(src)
add_subdirectory(tests)
