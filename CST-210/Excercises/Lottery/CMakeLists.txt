cmake_minimum_required(VERSION 3.24)

project(LotteryPicker)

set(CMAKE_CXX_STANDARD 20)




add_executable(LotteryPicker src/main.cpp src/BusinessLogic.cpp src/BusinessLogic.h src/UserInterface.cpp src/UserInterface.h)



add_subdirectory(src)
add_subdirectory(tests)
