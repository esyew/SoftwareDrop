//
// Created by Erick Grant on 1/27/23.
//
// Erick Grant, my own work
#ifndef LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
#define LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
#include <iostream>
#include <vector>
class BusinessLogic
{
 public:
  static std::string encrypt(std::string ogText, int amt);
  static char encryptChar(char ogChar, int amt);
  //NOT MADE BY ERICK
  //https://stackoverflow.com/questions/890164/how-can-i-split-a-string-by-a-delimiter-into-an-array#890229
    static std::vector<std::string> explode(const std::string& str, const char& ch);

  static std::vector<std::vector<std::string> > wordArray(std::vector<std::string> wordVector, int amt);
  static std::vector<std::vector<std::string> >  generateDB(std::string ogText, int amt);

};

#endif //LUCKY_SEVEN_SRC_BUSINESSLOGIC_H_
