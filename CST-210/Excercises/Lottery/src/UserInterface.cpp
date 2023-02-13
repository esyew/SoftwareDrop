//
// Created by Erick Grant on 1/27/23.
//

#include "UserInterface.h"
#include <iostream>
bool UserInterface::AskForMore()
{
  bool isAnswered = false;
  while (!isAnswered) {
    cout << "Would you like to see more numbers? ('Y' or 'N')";
    char ans;
    std::cin >> ans; // Ask for user answer
    if ((ans == 'Y') || (ans == 'y')) { // Check if lower/uppercase Yes
      isAnswered = true;
      return true; //Restart script at main()
    } else if ((ans == 'N') || (ans == 'n')) {
      isAnswered = true;
      return false; //Pass to main() that will end script
    } else //User did not type "y" or "n"
      std::cout << "Error: Please type 'Y' or 'N'\n"; //Confront user
    isAnswered = false;
  }
  //Default, should never run
  return false;
}
