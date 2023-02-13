//
// Created by Erick Grant on 1/27/23.
//
// Erick Grant, my own work

#include "BusinessLogic.h"
#include <iostream>
#include <vector>


//Can be used for sentences, however this should only be used for words
std::string BusinessLogic::encrypt(std::string ogText, int amt)
{
  // Declare empty string for encrypted word/sentence.
  std::string newText;

  // Encrypt each character of word, runs encryptChar for each.
  for (int i = 0; i < ogText.length(); i++) {

    // Add encrypted character to the new String
    newText += encryptChar(ogText.at(i), amt);
      }
  //Return encrypted word or sentence.
  return newText;
}

//Encrypt single character
char BusinessLogic::encryptChar(char ogChar, int amt)
{
  // declare vars
  bool isUpperCase;
  char newChar;
  //Check for space, technically redundant code
  if (ogChar == ' ') {
    // Space should always stay a space, under normal conditions, spaces would never make it to this stage.
    return ' ';
  }
//Detect if character is a letter and if it is capitalized.
  if (ogChar >='A' && ogChar <= 'Z') {
    //Runs capital letter later
    isUpperCase = true;
  } else if (ogChar >='a' && ogChar <= 'z') {
    // runs lower case letter code later
    isUpperCase = false;
  } else {
    // Returns unencrypted special charcter.
    return ogChar; //For non letters
  }


    //Lowercase letters
if (!isUpperCase) {
  if (amt >= 0)
  {
    // Mod by 26 to get rid of alphabet looping
    amt = amt % 26;
    // Determine if starting from 'a' is needed.
    if (('z' - ogChar - amt) >= 0) {
      //For less than 'z'
      //Positive numbers
      // Calculate new character before 'z'
      newChar = ogChar + amt;
      // std::cout << "less than z";
    } else {
      //For more than 'z'
      //Positive numbers

      int takenOut = ('z' - ogChar);
      amt -= takenOut;
      //std::cout << "more than z, shifting a by " << amt; // Error printing
      // add remaining after 'z' to 'a'
      newChar = 'a' + (amt - 1);
    }
  } else {
    // Negative numbers
    //Reverse mode

    // Again, remove alphabet looping for large shift values.
    amt = amt % 26;
    if ((ogChar + amt - 'a') >= 0) {
      //For greater than 'a'
      //Negative numbers
      //amt is negative so this removing from ogChar.
      newChar = ogChar + amt;
      // std::cout << "less than z";
    } else {
      //For more than 'z'
      //Negative numbers
    // Calc remaining before a (before z)
      int takenOut = (ogChar - 'a');
      // fix amt
      amt -= takenOut;
      //std::cout << "more than z, shifting a by " << amt;
      newChar = 'z' + (amt - 1); // accounts for 'a' being present,
    }




  }
// Mostly the same code, with uppercase charcters instead of lowercase
} else if (isUpperCase) {

  if (amt >= 0)
  {
    amt = amt % 26;
    if (('Z' - ogChar - amt) >= 0) {
      //For less than 'z'
      //Positive numbers
      newChar = ogChar + amt;
      // std::cout << "less than z";
    } else {
      //For less than 'z'
      //Positive numbers

      int takenOut = ('Z' - ogChar);
      amt -= takenOut;
      //std::cout << "more than z, shifting a by " << amt;
      newChar = 'A' + (amt - 1);
    }
  } else {
    //Reverse mode
    amt = amt % 26;
    if ((ogChar + amt - 'A') >= 0) {
      //For greater than 'a'
      //Negative numbers
      newChar = ogChar + amt;
      // std::cout << "less than z";
    } else {
      //For m than 'z'
      //Positive numbers

      int takenOut = (ogChar - 'A');
      amt -= takenOut;
      //std::cout << "more than z, shifting a by " << amt;
      newChar = 'Z' + (amt - 1);
    }
}
}
// Returns the encrypted character
return newChar;

}
//CODE FROM https://stackoverflow.com/questions/890164/how-can-i-split-a-string-by-a-delimiter-into-an-array#890229
std::vector<std::string> BusinessLogic::explode(const std::string& str, const char& ch) {
  std::string next;
  std::vector<std::string> result;

  // For each character in the string
  for (std::string::const_iterator it = str.begin(); it != str.end(); it++) {
    // If we've hit the terminal character
    if (*it == ch) {
      // If we have some characters accumulated
      if (!next.empty()) {
        // Add them to the result vector
        result.push_back(next);
        next.clear();
      }
    } else {
      // Accumulate the next character into the sequence
      next += *it;
    }
  }
  if (!next.empty())
    result.push_back(next);
  return result;
}

// Accepts a vector of words, returns vector of vectors
std::vector<std::vector<std::string> > BusinessLogic::wordArray(std::vector<std::string> wordVector, int amt)
{
  //Declare Database
  std::vector<std::vector<std::string> > unEncrpytEncryptDB;

  //Fill Database
  for (int i = 0; i < wordVector.size(); i++) {
    std::string oldWord = wordVector.at(i); // OG word
    std::string newWord = encrypt(oldWord, amt); // Encrypt word
    std::vector<std::string> line; // row in database, with colomns for encrypted and old word
    line.push_back(oldWord);
    line.push_back(newWord);
// add row to database
    unEncrpytEncryptDB.push_back(line);

  }

//Return the database with encryted words
  return unEncrpytEncryptDB;
}

//Create full DB
std::vector<std::vector<std::string> > BusinessLogic::generateDB(std::string ogText, int amt)
{
  //Convert string to vector of words, using space as delimiter
  std::vector<std::string> ogDB = explode(ogText, ' ');

  // The big guns, generates a full database from string vector, retuns all in vector DB
  std::vector<std::vector<std::string>> fullDB = wordArray(ogDB, amt);

  // Returns the full database
  return fullDB;
}

