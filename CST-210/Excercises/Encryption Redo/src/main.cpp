#include <iostream>
#include "BusinessLogic.h"
// Include for displaying table to console.
#include "VariadicTable.h"
// Erick Grant, my own work, except for table generator.


int main() {
  // Var declares
  std::string oldText;
  int amt;
  //oldText = "Hello this is Joe Biden its a pleasure to meet you!";


// Get string of words from user
  std::cout << "Enter the string that will be encrypted: ";
  std::getline(std::cin, oldText);


// Get shift amount from user
  std::cout << "Enter the shift amount: ";
  std::cin >> amt;


//Tester line, uncomment to be able to decrypt using -abs(amt)
//std::cout << BusinessLogic::encrypt(oldText, amt);

//Generates a database of encrypted words after the unencrypted words, from a string.
  std::vector<std::vector<std::string> > textDB = BusinessLogic::generateDB(oldText, amt);

  //Print out table
  //Note this uses open source code, from https://github.com/friedmud/variadic_table NOT ERICK MADE
  VariadicTable<std::string, std::string> vt({"Unencrypted",  "Encrypted"}, 10);


//Adds each item of the DB to the table
  for (int i = 0; i < textDB.size(); i++) {
    vt.addRow(textDB.at(i).at(0), textDB.at(i).at(1));
  }




//Prints out the table to the console
  vt.print(std::cout);

// Default return value, not used.
    return 0;

}
