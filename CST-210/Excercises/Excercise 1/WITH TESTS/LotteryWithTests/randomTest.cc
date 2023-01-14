#include <gtest/gtest.h>
#include "randomGen.h"

//Ensures all numbers are within range
TEST(lotteryTest, powerTest) {
    int powerBall = (new randomGen()) -> randomNum(26);
    EXPECT_TRUE((powerBall <= 26)) << "POWERBALL MORE THAN RANGE";

    int mainNum = (new randomGen()) -> getNumbers().at(3);
    EXPECT_TRUE(mainNum <= 69)<< "Main Number more than range";
    EXPECT_TRUE((mainNum >= 1) && (powerBall >= 1)) << "One number is out of range";

    for (int i = 0; i < 1000; i ++) {
        int powerBallBatchTEST = (new randomGen()) -> randomNum(26);
        EXPECT_TRUE((powerBall <= 26)) << "POWERBALL MORE THAN RANGE";
 //std::cout << "Good so far\n";
        int mainNumBatchTEST = (new randomGen()) -> getNumbers().at(3);
        EXPECT_TRUE(mainNumBatchTEST <= 69)<< "Main Number more than range";
        EXPECT_TRUE((mainNumBatchTEST >= 1) && (powerBall >= 1)) << "One number is out of range";
    }

    std::vector<int> ranSelection = (new randomGen()) -> getNumbers();
    int ranInx = (new randomGen()) -> randomNum(4);
    int ranChoosen = ranSelection.at(ranInx);
    EXPECT_TRUE((ranChoosen >= 1) && (ranChoosen <= 69));


}