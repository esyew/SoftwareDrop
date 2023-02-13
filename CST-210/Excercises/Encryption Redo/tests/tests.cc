#include <gtest/gtest.h>
#include "../src/BusinessLogic.h"
#include <vector>
// Erick Grant, my own work
std::string oldText = "hello this is a test";
using namespace std;
TEST(StringTest, projectTests) {

  std::string newText = BusinessLogic::encrypt(oldText, 6);
  std::string sameText = BusinessLogic::encrypt(oldText, 0);
  std::string encryptedText = "nkrru znoy oy g zkyz";

  //Basic Sent tester with shift of 5

  EXPECT_TRUE((newText == encryptedText));
  EXPECT_TRUE((oldText == sameText));
}
TEST(CharTest, projectTests) {

  //Character Tester
  EXPECT_EQ(BusinessLogic::encryptChar('a', 5), 'f');
  EXPECT_EQ(BusinessLogic::encryptChar('A', 5), 'F');
  EXPECT_EQ(BusinessLogic::encryptChar('Z', 5), 'E');
  EXPECT_EQ(BusinessLogic::encryptChar('Z', 5), 'E');
  EXPECT_EQ(BusinessLogic::encryptChar('.', 5), '.');
  EXPECT_EQ(BusinessLogic::encryptChar(' ', 5), ' ');
  EXPECT_EQ(BusinessLogic::encryptChar('a', -5), 't');
  EXPECT_EQ(BusinessLogic::encryptChar('a', 0), 'a');

}

TEST(SenttoVector, projectTests)
{
  std::string oldText = "hello this is a test";



//Sentence to Vector Tester
  std::vector<std::string> sentenceWords = BusinessLogic::explode(oldText, ' ');

  std::string goodWords[] = {"hello", "this", "is", "a", "test"};

  for (int i = 0; i < sentenceWords.size(); i++) {
    std::string word = sentenceWords.at(i);

    bool match;
    if (word == goodWords[i]) {
      match = true;
    } else {
      match = false;
    }
    EXPECT_TRUE(match);

  }

}

TEST(encryptedVector, projectTests) {
  std::vector<std::string> sentenceWords = BusinessLogic::explode(oldText, ' ');

  std::string goodWords[] = {"hello", "this", "is", "a", "test"};

  std::string newWords[] = {"mjqqt", "ymnx", "nx", "f", "yjxy"};

  std::vector<std::vector<std::string> > secretDB = BusinessLogic::wordArray(sentenceWords, 5);

  //Check database of both encrypted and unencrypted words

  for (int i = 0; i < secretDB.size(); i++) {
    std::string oldWord = secretDB.at(i).at(0);
    std::string newWord = secretDB.at(i).at(1);
    bool match;
    //Check old words
    if (oldWord == goodWords[i]) {
      match = true;
    } else {
      match = false;
    }


    bool newmatch;
    //Check old words
    if (newWord == newWords[i]) {
      newmatch = true;
    } else {
      newmatch = false;
    }
    EXPECT_TRUE(newmatch);

  }
}