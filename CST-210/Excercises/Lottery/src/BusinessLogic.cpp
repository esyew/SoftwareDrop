//
// Created by Erick Grant on 1/27/23.
//

#include "BusinessLogic.h"
#include <iostream>
#include <random>
#include <vector>
#include <set>



void BusinessLogic::ShowNumbers(int sets)
{

  for (int w = 0; w < sets; w++) {

    std::random_device rd;
    std::mt19937_64 generator(rd());
    std::uniform_int_distribution<unsigned long long> dist{1, 69};
    //std::set<unsigned long long> results;
    std::set<unsigned long long> results = GenerateStdNums(5);

    for(auto &n : results)
    {
      if (n > 9) {
        std::cout << n << " ";
      } else {
        std::cout << n << "  ";
      }}




    // Powerball Generator
    std::cout << "PB: "; // Format for powerball
    std::cout << GeneratePowerBall(); //Print out powerball number
    std::cout << "\n";
  }
}


std::set<unsigned long long> BusinessLogic::GenerateStdNums(int cnt)
{


    std::random_device rd;
    std::mt19937_64 generator(rd());
    std::uniform_int_distribution<unsigned long long> dist{1, 69};
    std::set<unsigned long long> results;

    while(results.size() != cnt)
    {
      results.insert(dist(generator));
    }
  return results;
}
int BusinessLogic::GeneratePowerBall()
{
  return rand() % 26 + 1;
}


