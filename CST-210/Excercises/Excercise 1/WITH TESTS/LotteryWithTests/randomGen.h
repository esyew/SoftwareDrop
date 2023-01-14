//
// Created by Erick Grant on 1/12/23.
//

#ifndef LOTTERYWITHTESTS_RANDOMGEN_H
#define LOTTERYWITHTESTS_RANDOMGEN_H

#include <random>
#include <vector>

class randomGen {
public:
    friend class lotteryTests;
    //Used for both powerball and main numbers
    static int randomNum(int range) {
        return rand() % range + 1;
    };



   static std::vector<int> getNumbers() {

        std::vector<int> output = {0,1,2,3,4};
        for (int i = 0; i < 5; i++) {
            output.at(i) = randomNum(69);
        }

//Detect duplicates
        for (int k = 0; k < 5; k++)
            for (int w = 0; w < 5; w++) {
                if (k != w) { //Attempt to find duplicates by comparing to other in array

                    while (output.at(w) == (output.at(k))) {
                        output.at(w) = randomNum(69);; //Get random number from 1-69
                    }


                }
            }
        return output;
    }


};


#endif //LOTTERYWITHTESTS_RANDOMGEN_H
