#include <iostream>
using namespace std;
#include "BusinessLogic.h"
#include "UserInterface.h"
int main() {

  int sets = 0;
  std::cout << "How many lotto numbers do you want to generate? ";
  std::cin >> sets; //Ask user for nums
  BusinessLogic::ShowNumbers(sets);



  //End of run, restart
  if (UserInterface::AskForMore()) {//Ask user whether to get more numbers
    main();//Repeat function, avoid recursion
  }

  std::cout << "Good bye! " ;
    return 0;

}
