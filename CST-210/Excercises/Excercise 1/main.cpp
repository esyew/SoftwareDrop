//Erick Grant COPYRIGHT 2023
#include <iostream>
#include <random>
#include <vector>
//Generate random number from 1-69

std::vector<int> getNumbers() {
    std::vector<int> output = {0,1,2,3,4};
    for (int i = 0; i < 5; i++) {
        output.at(i) = rand() % 69 + 1;
    }
//Detect duplicates
    for (int k = 0; k < 5; k++)
        for (int w = 0; w < 5; w++) {
            if (k != w) { //Attempt to find duplicates by comparing to other in array

                while (output.at(w) == (output.at(k))) {
                    output.at(w) = rand() % 69 + 1; //Get random number from 1-69
                }


            }
        }
    return output;
}

int setPowerBall() {
    return rand() % 26 + 1; //generate a random 1-26 number

}

void showNumbers() {
    int sets = 0;

    std::cout << "How many lotto numbers do you want to generate? ";
    std::cin >> sets; //Ask user for nums

    for (int w = 0; w < sets; w++) {
        std::vector<int> nums = getNumbers();

        for (int i = 0; i < 5; i++) { //Make main array five integers
            if (nums.at(i) < 10) {
                std::cout << " "; // Add spacing for single digit numbers
            }
            std::cout << nums.at(i); //Print number at array index
            std::cout << " "; //Add space
        }
        std::cout << "PB: "; // Format for powerball
        std::cout << setPowerBall(); //Print out powerball number
        std::cout << "\n";
    }

}

bool askForMore() { //Ask user on whether to end or restart program.
    std::cout << "Would you like to see more numbers? ('Y' or 'N')";
    char ans;
    std::cin >> ans; // Ask for user answer
    if ((ans == 'Y') || (ans == 'y')) { // Check if lower/uppercase Yes
        return true; //Restart script at main()
    } else if ((ans == 'N') || (ans == 'n')) {
        return false; //Pass to main() that will end script
    }
    else //User did not type "y" or "n"
        std::cout << "Error: Please type 'Y' or 'N'\n"; //Confront user
        askForMore(); //Restart question


}
int main() {
    showNumbers(); //Ask user for numbers, self contained
    bool contin = false; //Help error handle, likely unneeded
contin = askForMore(); //Ask user whether to get more numbers
if (contin) { //User says they want more nums
    main(); //Repeat function, avoid recursion
}
//if here, then user declined more numbers
//          (99% of gamblers quit before hitting it big)
std::cout << "Good bye!"; // Say goodbye to user
    return 0;// last bit of error handling, unused.
}
