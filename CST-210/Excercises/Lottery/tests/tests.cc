#include <gtest/gtest.h>
#include "../src/BusinessLogic.h"

#include <set>





TEST(LotteryPicker, projectTests) {
  for (int i = 0; i < 1000; i++) {
    //Test creation of set of lottery numbers
    std::set<unsigned long long> results = BusinessLogic::GenerateStdNums(5);
    bool Good = false;
    for(auto &n : results)
    {

      if ((n >= 1) && (n <= 70)) {
        Good = true;
      } else {
        Good = false;
        std::cout << "Error at ran check";
      }
    }
    //Powerball tester
    int powerBall;
    powerBall = BusinessLogic::GeneratePowerBall();
    if ((powerBall >= 1) && (powerBall <= 26)) {
      Good = true;
    } else {
      std::cout << powerBall << "\n";
      std::cout << "Error at powerball";
      Good = false;
    }



    EXPECT_TRUE(Good);
    EXPECT_EQ(results.size(), 5); //Check count of generated numbers


  }



}