//
// Created by Erick Grant on 1/27/23.
//

#ifndef LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
#define LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
#include <iostream>
#include <set>
class BusinessLogic
{
 public:
  static void ShowNumbers(int sets);
  static std::set<unsigned long long> GenerateStdNums(int cnt);
  static int GeneratePowerBall();
};

#endif //LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
